import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(7890);
            ss.setSoTimeout(10000);
            int counter=0;
            while(true){
                try {
                    Socket server = ss.accept();
                    counter++;
                    //Когда сервер дождался запроса от клиента
                    System.out.println("уук " + counter);
                    DataInputStream in = new DataInputStream(server.getInputStream());
                    System.out.println("in.readUTF() = " + in.readUTF());
                    DataOutputStream out = new DataOutputStream(server.getOutputStream());
                    out.writeUTF("Ку " + counter);
                    //Поработали с клиентом и хватит
                    server.close();
                }
                catch (IOException e) {
                    System.out.println("Серверу никто не пишет...");
                }
            }
        } catch (IOException e) {
            System.out.println("Сервер и остановлен");
        }
    }
}
