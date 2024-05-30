import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            MyHttpServer server=new MyHttpServer("0.0.0.0",8080);
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}