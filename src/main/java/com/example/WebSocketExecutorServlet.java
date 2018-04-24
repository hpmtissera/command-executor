package com.example;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/executeByWebSocket"}, loadOnStartup = 3)
public class WebSocketExecutorServlet extends WebSocketServlet {
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(WebSocketExecutor.class);
    }
}
