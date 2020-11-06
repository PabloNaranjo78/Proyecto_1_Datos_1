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

    public Client(int port,String ip){
        this.port = port;
        this.ip = ip;
    }

    public void run(){
        try {
            client = new Socket(ip,port);
            in_data = new BufferedReader(new InputStreamReader(client.getInputStream()));
    //        data = new BufferedReader(new InputStreamReader(System.in));
            out_data = new PrintStream(client.getOutputStream());
            Thread incomingDataThreadClient = new Thread(()-> { //Crea un Thread para el manejo de mensajes nuevos.
                while(true){
                    try {
                        in_message = in_data.readLine();
                        if (in_message!=null){
                            System.out.println("Mensaje nuevo!!!");
                     //       Controller.setFlag(); //Cambia el estado del flag para poder mostrar los mensajes.
                        }
                    } catch (IOException e) {
                  //      log.error(e.getMessage(),e); //Envía el error al logger
                    }
                }
            });
            incomingDataThreadClient.start(); //Inicia el thread

        } catch (IOException e) {
                e.printStackTrace();

        }
        }
    /*** Envía mensajes nuevos
    * Envía por el out_data un nuevo mensaje.
     */
    public static void send() {
            //           messages = Controller.getMessage();   toma string de envío en event register
        out_data.println(messages);


    }
    /***Devuelve el mensaje nuevo.
     * @return Retorna el mesaje que se tiene en la entrada.
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
