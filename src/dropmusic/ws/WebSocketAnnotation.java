package dropmusic.ws;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/ws")
public class WebSocketAnnotation {
    private static final AtomicInteger sequence = new AtomicInteger(1);
    private final String username;
    private Session session;

    public WebSocketAnnotation() {
        username = "User" + sequence.getAndIncrement();
    }

    @OnOpen
    public void start(javax.websocket.Session session) {
        this.session = session;
        String message = "*" + username + "* connected.";
        sendMessage(message);
    }

    @OnClose
    public void end() {
        // clean up once the WebSocket connection is closed
    }

    @OnMessage
    public void receiveMessage(String message) {
        // one should never trust the client, and sensitive HTML
        // characters should be replaced with &lt; &gt; &quot; &amp;
        String upperCaseMessage = message.toUpperCase();
        sendMessage("[" + username + "] " + upperCaseMessage);
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

    private void sendMessage(String text) {
        try {
            this.session.getBasicRemote().sendText(text);
        } catch (IOException e) {
            // clean up once the WebSocket connection is closed
            try {
                this.session.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
