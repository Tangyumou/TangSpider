import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
    public  void test(){
        try (InputStream input = getClass().getResourceAsStream("/default.properties")) {
            if (input != null) {
                System.out.println(true);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
