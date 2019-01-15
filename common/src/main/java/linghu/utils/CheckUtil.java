package linghu.utils;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtil {

    private final static String telRegex = "^(\\d{3,4}-)?\\d{6,8}$";
    private final static String mobileRegex = "^(114|13[0-9]|15[0-9]|18[0-9]||19[0-9]|147|17[0-9])[0-9]{8}$";
    private final static String looseMobileRegex = "^(13|14|15|16|17|18|19)[0-9]{9}$";
    private final static String carNumberRegex = "^[\\u4e00-\\u9fa5]{1}[A-Za-z]{1}[a-zA-Z_0-9]{4,5}[a-zA-Z_0-9_\\u4e00-\\u9fa5]$";

    public static void main(String[] args) {

        Pattern.matches(mobileRegex,"");

        Pattern pattern = Pattern.compile(telRegex);
        Matcher matcher = pattern.matcher("123213123123");

        matcher.find();
        matcher.lookingAt();
        matcher.matches();

        if(matcher.find()){
            MatchResult result = matcher.toMatchResult();
            result.group();
        }

    }

}
