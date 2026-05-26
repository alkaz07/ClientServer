import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 7890);
            System.out.println("Просто подключается к " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Привет из " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Сервер ответил " + in.readUTF());
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}