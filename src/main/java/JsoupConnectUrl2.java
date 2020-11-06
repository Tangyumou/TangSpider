import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class JsoupConnectUrl2 {
    public static void main(String[] args) throws IOException{
        Response response = Jsoup.connect("http://127.0.0.1:8080/toLogin")
                .method(Method.GET)
                .execute();
        URL url = response.url();
        int statusCode = response.statusCode();
        String contentType = response.contentType();
        String statusMessage = response.statusMessage();
        System.out.println(statusMessage);
        if(statusCode==200){
            String html = new String(response.bodyAsBytes());
            Document document = response.parse();
        }
    }
}
