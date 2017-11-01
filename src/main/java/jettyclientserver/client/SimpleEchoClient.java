package jettyclientserver.client;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

/**
 * Example of a simple Echo Client.
 */
public class SimpleEchoClient
{

    private static long startTime;
    private static long stopTime;

    public static void main(String[] args)
    {
        String destUri = "ws://127.0.0.1:8000/";
        if (args.length > 0)
        {
            destUri = args[0];
        }
        WebSocketClient client = new WebSocketClient();
        SimpleEchoSocket socket = new SimpleEchoSocket();
        try
        {
            client.start();
            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket,echoUri,request);
//            System.out.printf("Connecting to : %s%n",echoUri);
            startTime = System.currentTimeMillis();
            System.out.println("Start time: " + startTime);
            // wait for closed socket connection.
            socket.awaitClose(100, TimeUnit.SECONDS);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        finally
        {
            try
            {
                client.stop();
                stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("elapsedTime = " + elapsedTime);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}