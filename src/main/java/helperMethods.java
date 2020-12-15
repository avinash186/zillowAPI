import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class helperMethods {

    public static String encode (String input) throws UnsupportedEncodingException {
        String out = URLEncoder.encode(input, "UTF-8");
        return out;
    }
}
