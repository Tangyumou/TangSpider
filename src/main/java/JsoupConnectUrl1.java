import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupConnectUrl1 {
    public static void main(String[] args) throws IOException{
        Connection connect = Jsoup.connect("http://127.0.0.1:8080/toLogin");
        Document document = connect.get();
        System.out.println(document);

    }
}
