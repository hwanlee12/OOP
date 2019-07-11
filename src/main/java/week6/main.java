package week6;

public class main {
    public static void main(String[] args) {
        String firstname = "Jason";
        String lastname = "Bourne";
        String birthday = "19920401";

        Member member1 = new Member(firstname, lastname, birthday);
        System.out.println(member1.toString());

        Student student1 = new Student(firstname, lastname, birthday, 15);
        System.out.println(student1.toString());

        Graduate graduate1 = new Graduate(firstname, lastname, birthday, 10);
        System.out.println(graduate1.toString());

        Undergraduate undergraduate1 = new Undergraduate(firstname, lastname, birthday, 18);
        System.out.println(undergraduate1.toString());
    }
}
