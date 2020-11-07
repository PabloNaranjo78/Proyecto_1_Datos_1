package cr.ac.tec.MonsTEC.ServerSockets;

import com.google.gson.Gson;

import java.util.Observable;

public class ServerController extends Observable {

    boolean isHost;
    int port;
    String ip;
    public static boolean flag = false;
    public static String outData;
    static String inData;
    Gson gson = new Gson();

    public ServerController(boolean isHost, int port, String ip){
        this.isHost = isHost;
        this.ip = ip;
        this.port = port;
        startServer();
        if (isHost){
            newConnection();
        }
    }

    public void startServer(){
        Thread incomingData = new Thread(()->{
            while(true){
                if (isHost){
                    this.inData = Client.getIn_message();
                }else{
                    this.inData = Server.getIn_message();
                }
       //         if (flag){ //Este flag será verdadero cuando haya un mensaje nuevo.
       //             log.debug("Nuevo mensaje entrante");
                //    deserializeJson(inData);
               //     System.out.println("pasando info nueva");
                    //text_box.setText(text_box.getText()+"\n"+"Amigo"+": "+ incomingMessages);
          //          flag = false;
           //     }else{
         //           try {
            //            Thread.sleep(10);
          //          } catch (InterruptedException e) {
              //          log.error(e.getMessage(),e); //Envía el error al logger
            //        }}
            }

        });
        incomingData.start();
    }

    public static String getNewData(){
        return inData;
        //tiene que llamar a Game Board
    //    EventRegister eventRegister = gson.fromJson(inData,EventRegister.class);
   //     this.setChanged();
   //     this.notifyObservers("inData");
    //    this.clearChanged();
    }

    public void sendData(String outData){
        if (isHost){
            Client.send(outData);
        }else{
            Server.send(outData);
        }
    }

    public void newConnection(){
        try{
  //          String ip = new_chat_ip.getText();
     //       int port_client = Integer.valueOf(new_chat_port.getText());
     //       log.debug("Iniciando Conexión");
                Thread startServer = new Client(this.port, this.ip);
     //       setReceiveOrSend();
            startServer.start();}
        catch (IllegalArgumentException e){
    //        log.error(e.getMessage(),e);  //Envía el error al logger
            throw new IllegalArgumentException("Ip o puerto inválido");
        }
    }
    public static void setFlag(){
        flag = true;
    }

    public static boolean getFlag(){
        return flag;

    }
    public static void setFlagFalse(){
        flag = false;
    }

  //  public static String getMessage(){
 //       return outData;
 //   }
}
