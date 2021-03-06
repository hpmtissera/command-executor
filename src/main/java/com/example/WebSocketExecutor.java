package com.example;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.logging.Logger;

@WebSocket
public class WebSocketExecutor {
    private static Logger logger = Logger.getLogger(WebSocketExecutor.class.getName());

    @OnWebSocketMessage
    public void onText(Session session, String command) throws IOException {
        String result = Executor.executeCommand(command);
        if (session.isOpen()) {
            session.getRemote().sendString(result);
        }
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        logger.info("WebSocket connected!");
    }

    @OnWebSocketClose
    public void onClose(Session session, int status, String reason) {
        logger.info("WebSocket closed!");
    }
}