package linghu.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import linghu.base.BaseActionRequest;
import linghu.base.BaseViewModel;
import linghu.exceptionservice.ServiceException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SerializeConfig {

//    @Value("${spring.jackson.date-format}")
    static private String formatValue = "yyy-MM-dd HH:mm:ss";

    @Bean(name = "format")
    DateTimeFormatter format() {
        return DateTimeFormatter.ofPattern(formatValue);
    }

    @Bean
    public ObjectMapper serializingObjectMapper(@Qualifier("format") DateTimeFormatter format) {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(format));
        javaTimeModule.addSerializer(Instant.class, new InstantCustomSerializer(format));
        javaTimeModule.addSerializer(Date.class, new DateSerializer(false, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(javaTimeModule);
        return mapper;
    }

    class InstantCustomSerializer extends JsonSerializer<Instant> {
        private DateTimeFormatter format;

        private InstantCustomSerializer(DateTimeFormatter formatter) {
            this.format = formatter;
        }

        @Override
        public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (instant == null) {
                return;
            }
            String jsonValue = format.format(instant.atZone(ZoneId.systemDefault()));
            jsonGenerator.writeString(jsonValue);
        }
    }

    class BaseActionRequestDeserializer extends JsonDeserializer<BaseActionRequest> {
        private Map<String,String> classMap;

        public Map<String, String> getClassMap() {
            return classMap;
        }

        void setClassMap(Map<String, String> classMap) {
            this.classMap = classMap;
        }

        @Override
        public BaseActionRequest deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            String cName = node.get("className").asText();
            String action = node.get("action").asText();
            if(cName == null||action == null){
                throw ServiceException.createException("className or action is null");
            }
            String innerCName = classMap.get(cName+"-"+action);
            if(innerCName == null){
                innerCName = classMap.get(cName);
            }
            if(innerCName == null){
                throw ServiceException.createException("没有匹配的内部类");
            }

            JsonNode vmNode = node.get("viewModel");
            ObjectMapper mapper = new ObjectMapper();
            Class<?> clazz = null;
            try {
                clazz = Class.forName(innerCName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            BaseActionRequest request = mapper.treeToValue(node,BaseActionRequest.class);
            BaseViewModel vm = (BaseViewModel)mapper.treeToValue(vmNode,clazz);
            request.setViewModel(vm);
            return request;
        }
    }

    @Bean(name = "innerClassMap")
    public Map<String,String> innerClassMap(){
        Map<String,String> map = new HashMap<>();

        map.put("product","linghu.product.dto.ProductViewModel");
        map.put("store","linghu.store.dto.CreateStoreRequest");
        map.put("product-query","linghu.base.SearchModel");
        map.put("user","linghu.account.dto.WXUserViewModel");
        map.put("sms","linghu.sms.dto.SmsViewModel");
        return map;
    }
}


