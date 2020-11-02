package cr.ac.tec.MonsTEC2;

import com.google.gson.Gson;
import cr.ac.tec.MonsTEC2.DeckCartas.Cartas;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeEsbirros;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeHechizos;
import cr.ac.tec.MonsTEC2.DeckCartas.CardTypes.TypeSecretos;
import cr.ac.tec.MonsTEC2.DeckCartas.DeckCartas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MainJSON {

    public static void main(String[] args) {
//        String json = "";
//        BufferedReader br;
//        {
//            try {
//                br = new BufferedReader(new FileReader("AllCarts.json"));
//
//                String linea = "";
//                while ((linea = br.readLine()) != null) {
//                    json += linea;
//                }
//                br.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            System.out.println(json);
//
//            Gson gson = new Gson();
//            Cartas c = gson.fromJson(json, Cartas.class);
////            System.out.println(c);
//            TypeEsbirros[] esb = c.getEsbirro();
//            TypeSecretos[] secrt = c.getSecreto();
//            TypeHechizos[] hchiz = c.getHechizo();

//            Test
//            System.out.println(esb[10].getID());
//            for (int i = 0 ; i < 10 ; i++) {
//                System.out.println(esb[i].getID());
//                System.out.println(esb[i].getCost());
//            }

//            Stack<TypeEsbirros> stack4carts = new Stack<>();
//            for (int i = 0 ; i < 4 ; i++) {
//                stack4carts.add(c.getEsbirro()[i]);
//            }
//            System.out.println(stack4carts.peek());
//
//        }


        DeckCartas deck = new DeckCartas();
        System.out.println(deck);

//        for (int i = 0 ; i < 4 ; i++) {
//                DeckCartas.(c.getEsbirro()[i]);
//            }

    }
}
