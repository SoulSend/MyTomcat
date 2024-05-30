import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

//处理http服务
public class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String method=exchange.getRequestMethod();
        URI uri=exchange.getRequestURI();
        String path=uri.getPath();
        String query=uri.getQuery();
        System.out.println(method+":"+path+"?"+query);

        Headers resHeader=exchange.getResponseHeaders();
        resHeader.set("Content-Type", "text/html; charset=utf-8");
        resHeader.set("Cache-Control", "no-cache");
        System.out.println("get and handle");

        exchange.sendResponseHeaders(200,0);
        //响应内容
        String s="<h1>Hello, world.</h1><p>"+ LocalDateTime.now().withNano(0) + "</p>";
        try(OutputStream out=exchange.getResponseBody()){
            out.write(s.getBytes(StandardCharsets.UTF_8));
        }

    }
}
