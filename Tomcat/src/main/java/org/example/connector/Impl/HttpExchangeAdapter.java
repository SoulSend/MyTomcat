package org.example.connector.Impl;

import org.example.connector.HttpExchangeRequest;
import org.example.connector.HttpExchangeResponse;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * 重写所有接口的方法，其实就只是将HttpExchange封装一下，我们传入一个HttpExchange
 * 然后就可以使用一个HttpExchangeRequest或者HttpExchangeResponse来接收同时调用
 * HttpExchangeAdapter的方法来操作HttpExchange
 * 这就是一个转换器 HttpExchangeRequest/HttpExchangeResponse-》HttpExchange
 */
public class HttpExchangeAdapter implements HttpExchangeRequest, HttpExchangeResponse {
    //你可以把这个exchange看成一个请求和响应

    final HttpExchange exchange;

    public HttpExchangeAdapter(HttpExchange exchange) {
        this.exchange = exchange;
    }
    @Override
    public String getRequestMethod() {
        return this.exchange.getRequestMethod();
    }

    @Override
    public URI getRequestURI() {
        return this.exchange.getRequestURI();
    }

    @Override
    public Headers getResponseHeaders() {
        return this.exchange.getResponseHeaders();
    }

    @Override
    public void sendResponseHeaders(int rCode, long responseLength) throws IOException {
        this.exchange.sendResponseHeaders(rCode,responseLength);
    }

    @Override
    public OutputStream getResponseBody() {
        return this.exchange.getResponseBody();
    }
}
