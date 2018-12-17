package dropmusic.ws;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe que gere os métodos das WebSockets
 */
@ServerEndpoint(value = "/ws")
public class WebSocketAnnotation {
    private static final AtomicInteger sequence = new AtomicInteger(1);
    private final String username;
    private Session session;

    List<Session> socketSessions = Collections.synchronizedList(new ArrayList<Session>());

    public WebSocketAnnotation() {
        username = "User" + sequence.getAndIncrement();
    }

    /**
     * Ao iniciar, define a sessão e adiciona-a a uma lista de sessões
     * @param session
     */
    @OnOpen
    public void start(javax.websocket.Session session) {
        socketSessions.add(session);
        this.session = session;
        String message = "*" + username + "* connected.";
        broadcast(message);
    }

    /**
     * Ao terminar a sessão, remove-a da lista
     */
    @OnClose
    public void end() {
        // clean up once the WebSocket connection is closed
        socketSessions.remove(session);
    }

    /**
     * Ao haver uma mensagem, envia-a através da função sendMessage()
     * @param message mensagem a ser enviada
     */
    @OnMessage
    public void receiveMessage(String message) {
        // one should never trust the client, and sensitive HTML
        // characters should be replaced with &lt; &gt; &quot; &amp;
        String upperCaseMessage = message.toUpperCase();
        sendMessage("[" + username + "] " + upperCaseMessage);
        broadcast("NOTIFICACAO");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

    /**
     * Envia a mensagem pela WebSocket
     * @param text mensagem a ser enviada
     */
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

    /**
     * Envia a mensagem pela WebSocket a todos os utilizadores logados
     * @param message mensagem a ser enviada
     */
    public void broadcast(String message){
        for(Session session: socketSessions){
            try {
                System.out.println(session.getUserPrincipal());
                session.getBasicRemote().sendText(message);
            } catch (IOException e2){
                e2.printStackTrace();
            }
        }
    }
}
