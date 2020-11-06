import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.*;

import java.io.*;


public class JsoupConnectInputSream {
    public static void main(String[] args) {
        String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604657963087&di=4b36155f5742b5cfb663b98ae7c4d6e9&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F8ae010762da6663b7f5b6a39b38f8aebc378a14e12afa-BiQbos_fw658";
        Connection connection = Jsoup.connect(imageUrl);
        Response response = null;
        try {
            response = connection.method(Method.GET).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件类型为："+response.contentType());
        BufferedInputStream bufferedInputStream = response.bodyStream();
        saveImage(bufferedInputStream,"image/3.jpg");
    }
    public static void saveImage(BufferedInputStream bufferedInputStream,String savePath){
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            while((len = bufferedInputStream.read(buffer,0,1024))!=-1){
                bufferedOutputStream.write(buffer,0,len);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
