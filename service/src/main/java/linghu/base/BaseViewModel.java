package linghu.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import linghu.entity.BaseDbModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseViewModel {
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaseDbModel toDbModel() throws Exception{
        throw new Exception();
    }
}
