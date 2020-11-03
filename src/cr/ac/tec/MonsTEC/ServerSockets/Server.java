package cr.ac.tec.MonsTEC.ServerSockets;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class Server extends Observable implements Runnable {

    int port;
    String ip;
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    PrintStream dataOutputStream;
    String jsonIn;
    Gson gson = new Gson();
    boolean isWaiting = true;
    static boolean isStarted = false;


    public Server(int port, String ip){
        this.ip = ip;
        this.port = port;

    }

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(port);

       socket = serverSocket.accept();
       setIsStarted();
       dataInputStream = new DataInputStream(socket.getInputStream());
       dataOutputStream = new PrintStream(socket.getOutputStream());
       System.out.println("iniciado");

       jsonIn =  dataInputStream.readLine();

       System.out.println(jsonIn);

       Persona prueba = gson.fromJson(jsonIn, Persona.class);
       System.out.println(prueba.getName());



        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void sendData(String jsonOut){
        dataOutputStream.println(jsonOut);
    }
    public void setIsStarted(){
        System.out.println("cambiao");
        isStarted = true;
    }
    public static boolean getIsStarted(){
        return isStarted;
    }


}



