package cr.ac.tec.MonsTEC2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainJSON {

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
            Cartas c = gson.fromJson(json, Cartas.class);
//            System.out.println(c);
            TypeEsbirros[] esb = c.getEsbirro();
            TypeSecretos[] secrt = c.getSecreto();
            TypeHechizos[] hchiz = c.getHechizo();

//            Test
            System.out.println(esb[10].getID());
            System.out.println(secrt[10].getID());
            System.out.println(hchiz[10].getID());
        }
    }
}
