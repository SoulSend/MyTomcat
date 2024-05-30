import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

//启动一个http服务
public class MyHttpServer implements AutoCloseable {
    //持有一个服务类的实例
    private final HttpServer httpServer;

    //构造方法，传入服务器和端口号
    public MyHttpServer(String host, int post) throws IOException {

        httpServer = HttpServer.create(new InetSocketAddress(host, post), 0);
        httpServer.createContext("/",new MyHttpHandler());

        httpServer.start();
        System.out.printf(host+":"+post);

    }

    @Override
    public void close() throws Exception {
        httpServer.stop(3);
    }

}
