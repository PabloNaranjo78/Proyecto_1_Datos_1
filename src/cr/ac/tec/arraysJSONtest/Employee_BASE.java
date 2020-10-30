package cr.ac.tec.arraysJSONtest;

public class Employee_BASE {
    private String firstname;
    private int age;
    private String mail;

    private Adress_NESTED address;

    private FamilyMember_ARRAY[] family;


//constructors


    public Employee_BASE() {
    }

    public Employee_BASE(String firstname, int age, String mail, Adress_NESTED address, FamilyMember_ARRAY[] family) {
        this.firstname = firstname;
        this.age = age;
        this.mail = mail;
        this.address = address;
        this.family = family;
    }


//getters n setteres


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Adress_NESTED getAddress() {
        return address;
    }

    public void setAddress(Adress_NESTED address) {
        this.address = address;
    }


    public FamilyMember_ARRAY[] getFamily() {
        return family;
    }

    public void setFamily(FamilyMember_ARRAY[] family) {
        this.family = family;
    }
}


