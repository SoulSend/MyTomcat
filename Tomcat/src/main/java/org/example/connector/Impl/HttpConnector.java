package org.example.connector.Impl;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.connector.Impl.HttpExchangeAdapter;
import org.example.engine.HttpServletRequestImpl;
import org.example.engine.HttpServletResponseImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;

public class HttpConnector implements HttpHandler,AutoCloseable {
    final HttpServer httpServer;

    public HttpConnector( ) throws Exception {
        httpServer=HttpServer.create(new InetSocketAddress(8080),0);
        httpServer.createContext("/",this);
        httpServer.start();
        System.out.println("server has been open");
    }

    @Override
    public void close() throws Exception {
        httpServer.stop(3);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        //使用适配器转换exchange->servlet
        HttpExchangeAdapter adapter = new HttpExchangeAdapter(exchange);
        HttpServletRequest request = new HttpServletRequestImpl(adapter);
        HttpServletResponseImpl response = new HttpServletResponseImpl(adapter);
        //处理
        process(request,response);
        System.out.println("response success!");
    }
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        String html="<h1>hello, "+((name==null)?"world":name+".</h1>");
        response.setContentType("text/html");
        PrintWriter printWriter=response.getWriter();
        printWriter.write(html);
        printWriter.close();
    }
}
