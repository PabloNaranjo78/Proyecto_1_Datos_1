package cr.ac.tec.arraysJSONtest;

import com.google.gson.Gson;

public class MainActivity {
    public static void main(String[] args) {

//        W/ GSON--------------------------------------------------------------------------------------------
        Gson gson = new Gson();

//       To Json

//        Adress_NESTED adressc = new Adress_NESTED("Germany", "Berlin");
//
//        List<FamilyMember_ARRAY> family = new ArrayList<>();
//        family.add(new FamilyMember_ARRAY("wife", 30));
//
//        Employee_BASE employee = new Employee_BASE("Dani", 20, "mail", adressc, family);
//        String json = gson.toJson(employee);
//        System.out.println(json);

//       From Json to object

        String json = "{\n" +
                "  \"firstname\": \"Dani\",\n" +
                "  \"age\": 20,\n" +
                "  \"mail\": \"mail\",\n" +
                "  \"address\": {\n" +
                "    \"country\": \"Germany\",\n" +
                "    \"city\": \"Berlin\"\n" +
                "  },\n" +
                "  \"family\": [\n" +
                "    {\n" +
                "      \"role\": \"wife\",\n" +
                "      \"age\": 30,\n" +
                "      \"sex\": \"F\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"role\": \"sis\",\n" +
                "      \"age\": 20,\n" +
                "      \"sex\": \"F\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Employee_BASE employee = gson.fromJson(json, Employee_BASE.class);
//        Map<?,?> employee = gson.fromJson(json, Map.class);
        System.out.println("First name:" + employee.getFirstname());
        Adress_NESTED nest = employee.getAddress();
        System.out.println("Country:" + nest.getCountry());
        FamilyMember_ARRAY[] farray = employee.getFamily();
        System.out.println(farray[1].getRole());
        for (int i = 0 ; i < farray.length ; i++) System.out.println(farray[i].getRole());

//        System.out.println(json);
//        ------------------------------------------------------------------------------------------------------

//        W/ POJO////////////////////////////////////////////////////////////////////////////////////////////
//        SpringApplication.run(MainActivity.class, args);

//        W/ POJO////////////////////////////////////////////////////////////////////////////////////////////
    }
}
