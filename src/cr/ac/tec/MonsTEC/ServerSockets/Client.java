package cr.ac.tec.MonsTEC.ServerSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Thread {

    private static String messages;
    Socket client;
    private static BufferedReader in_data;
    private static PrintStream out_data;
    private int port;
    private String ip;
    private static String in_message;

    /***
     * Crea el cliente
     * @param port puerto
     * @param ip ip
     */
    public Client(int port,String ip){
        this.port = port;
        this.ip = ip;
    }

    public void run(){
        try {
            System.out.println(port);
            client = new Socket(ip,port);
            in_data = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.out_data = new PrintStream(client.getOutputStream());
            Thread incomingDataThreadClient = new Thread(()-> { //Crea un Thread para el manejo de mensajes nuevos.
                while(true){
                    try {
                        in_message = in_data.readLine();
                        if (in_message!=null){
                            ServerController.setFlag();
                        }
                    } catch (IOException e) {
                    }
                }
            });
            incomingDataThreadClient.start(); //Inicia el thread

        } catch (IOException e) {
                e.printStackTrace();
        }
        }
    /*** Envía información nueva
    * Envía por el out_data la nueva info.
     */
    public static void send(String outJsonData) {
        out_data.println(outJsonData);

    }
    /***Devuelve la información nueva
     * @return Retorna la información que se tiene en la entrada.
     */
    public static String getIn_message() {
        if (in_message == null){
            return "";
        }
        else{
            return in_message;
        }
    }
}
