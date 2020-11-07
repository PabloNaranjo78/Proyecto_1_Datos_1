package cr.ac.tec.MonsTEC.ServerSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static String message;
    private int port;
    static ServerSocket server;
    Socket socket;
    private static PrintStream out_data;
    private static BufferedReader in_data;
    private static String in_message;

    /***
     * Servidor de sockets
     * @param port puerto que se desea abrir
     */
    public Server(int port){
        this.port = port;
    }
    /***
     * Este es llamado apenas se inicia el Thread, se encarga de iniciar el servidor con el puerto dado.
     */
    @Override
    public void run() {
        try {
            server = new ServerSocket(port); //Declara el socket con el puerto.
        } catch (IOException e) {
        }
        socket = new Socket();
        while (true) {
            try {
                socket = server.accept(); //Espera una llamada hacia este servidor.
                System.out.println("Conexión entrante lista");
                in_data = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out_data = new PrintStream(socket.getOutputStream());
                Thread incomingDataThreadServer = new Thread(()-> { //Se crea un Thread para el manejo de la entrada de información.
                    while(true){
                        try {
                            in_message = in_data.readLine();
                            if (in_message!=null){
                                System.out.println("Nuevo mensaje");
                                ServerController.setFlag(); //Llama a setFlag() para cambiar el estado y que se pueda leer la info
                            }
                        } catch (IOException e) {
                        }
                    }
                });
                incomingDataThreadServer.start(); //Inicia el Thread.
                break;
            }
            catch (IOException e) {
            }
        }
    }

    /*** Devuelve el mensaje nuevo.
     *
     * @return Retorna la información que se tiene en la entrada.
     * En caso de ser null, enviará un string vacío para evitar errores.
     */
    public static String getIn_message() {
        if (in_message == null){
            return "";
        }
        else{
            return in_message;
        }
    }

    /***
     * Envía la información al cliente
     */

    public static void send(String outJsonData) {
        out_data.println(outJsonData);


}}
