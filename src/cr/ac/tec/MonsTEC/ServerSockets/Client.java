package cr.ac.tec.MonsTEC.ServerSockets;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client implements Runnable {

    String ip;
    int port;
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream dataOutputStream;
    String jsonOut;
    String jsonIn;
    Gson gson = new Gson();

    public Client(int port, String ip){
        this.port = port;
        this.ip = ip;
    }

    @Override
    public void run() {
        try {
            System.out.println("iniciando cliente");
            socket = new Socket(ip,port);
            System.out.println("Cliente inicializado");
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new PrintStream(socket.getOutputStream());

            jsonOut = gson.toJson(new Persona("ElPepe","Stece",8,9));
            dataOutputStream.println(jsonOut);

       //     jsonIn = dataInputStream.readLine();
      //      Persona ppp = gson.fromJson(jsonIn,Persona.class);
       //     System.out.println("Leyendo en client"+ppp.getName());



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
