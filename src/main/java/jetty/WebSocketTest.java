package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import static java.lang.Thread.sleep;

public class WebSocketTest {

    public static final int MIN = 8000;
    public static final int MAX = 8002;


    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = MIN; i < MAX; ++i) {
//                    openSocketServer(i);
//                    try {
//                        sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        Thread t = new Thread(runnable);
//        t.start();
        openSocketServer(8000);
    }

    public static void openSocketServer(int port) {
        Server server = new Server(port);
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(MyWebSocketHandler.class);
            }
        };
        server.setHandler(wsHandler);
        try {
            server.start();
            server.join();
        } catch (Exception e) {

        }
    }

}