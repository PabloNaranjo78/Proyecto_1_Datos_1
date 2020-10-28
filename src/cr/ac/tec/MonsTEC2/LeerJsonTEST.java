package cr.ac.tec.MonsTEC2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerJsonTEST {

    public static void main(String[] args) {

        String json = "";
        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader("AllCarts.json"));

                String linea = "";
                while ((linea = br.readLine()) != null) {
                    json += linea;
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(json);

            Gson gson = new Gson();
            Carta c = gson.fromJson(json, Carta.class);
            c.setDmg(10);
            System.out.println(c);
        }

    }
}
