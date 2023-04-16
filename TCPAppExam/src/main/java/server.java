import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(5678);
        while (true) {
            Socket connection = socket.accept();
            DataInputStream datainputstream = new DataInputStream(connection.getInputStream());
            byte[] arr = readMessage(datainputstream);
            System.out.println(new String(arr));
        }

    }

    public static byte[] readMessage(DataInputStream din) throws Exception {
        int msgLen = din.readInt();
//        System.out.println("message lengt=" + msgLen);
        byte[] message = new byte[msgLen];
        din.readFully(message);
        return message;
    }
}
