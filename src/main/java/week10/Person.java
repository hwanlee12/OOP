package week10;

public class Person {
    private String name;
    private String phonenumber;

    public Person(String name, String phonenumber)
    {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName(){
        return name;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)",name, phonenumber);
    }
}
