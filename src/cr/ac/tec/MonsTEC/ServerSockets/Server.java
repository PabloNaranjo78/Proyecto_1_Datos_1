//package cr.ac.tec.MonsTEC.ServerSockets;
//
//import com.google.gson.Gson;
//import cr.ac.tec.MonsTEC.MainWindow.Main;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Observable;
//import java.util.Observer;
//
//public class Server extends Observable implements Runnable {
//
//    int port;
//    String ip;
//    ServerSocket serverSocket;
//    Socket socket;
//    DataInputStream dataInputStream;
//    DataOutputStream dataOutputStream;
//    String jsonIn;
//    String jsonOut;
//    Gson gson = new Gson();
//
//    public Server(int port, String ip){
//        this.ip = ip;
//        this.port = port;
//    }
//
//    @Override
//    public void run() {
//
//        try {
//            serverSocket = new ServerSocket(port);
//
//            while (true){
//                socket = serverSocket.accept();
//                dataInputStream = new DataInputStream(socket.getInputStream());
//                dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                System.out.println("iniciado");
//
//                jsonIn =  dataInputStream.readLine();
//
//                System.out.println(jsonIn);
//
//
//
//                Persona prueba = gson.fromJson(jsonIn, Persona.class);
//                System.out.println(prueba.getName());
//
//             //   System.out.println("???");
//
//             //   jsonOut = gson.toJson(new Persona("ElPepe","Stece",8,9));
//
//             ///   dataOutputStream.writeUTF(jsonOut);
//
//
//
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//
//    }
//}
