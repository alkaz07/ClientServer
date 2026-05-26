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
                counter++;
                Socket server = ss.accept();
                System.out.println("ÛÛÍ "+counter);
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("in.readUTF() = " + in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(" Û "+counter);
                server.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
