import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;

public class HttpclientTest {
    public static void main(String[] args) throws ParseException,IOException{
        //初始化HttpContext
        HttpContext localContext = new BasicHttpContext();
        String url = "https://how2j.cn/k/idea/idea-pull/1363.html";
        //初始化HttpClient
        HttpClient httpClient = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url);
        //执行请求获取HttpResponse
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet,localContext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取具体响应信息
        System.out.println("response:"+httpResponse);
        //响应状态
        String status = httpResponse.getStatusLine().toString();
        System.out.println("status:"+status);
        //获取响应状态码
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);
        //协议版本号
        ProtocolVersion protocolVersion = httpResponse.getProtocolVersion();
        System.out.println("protocolVersion：" + protocolVersion);
        //是否OK
        String phrase = httpResponse.getStatusLine().getReasonPhrase();
        System.out.println("phrase:"+phrase);
        Header[] headers = httpResponse.getAllHeaders();
        System.out.println("输出头信息为：");
        for(int i = 0; i<headers.length;i++){
            System.out.println(headers[i]);
        }
        System.out.println("头信息输出结束");
        if(statusCode== HttpStatus.SC_OK){
            //获取实体内容
            HttpEntity entity = httpResponse.getEntity();
            String entityString = EntityUtils.toString(entity,"gbk");
            //输出实体内容
            System.out.println(entityString);
            EntityUtils.consume(entity);
        }else{
            //关闭HttpEntity的流实体
            EntityUtils.consume(httpResponse.getEntity());
        }
    }
}
