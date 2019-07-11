package week6;

public class Student extends Member {
    protected int credit;

    public Student(String firstName, String lastName, String birthday, int credit)
    {
        super(firstName, lastName, birthday);
        if(credit > 21)
        {
            System.out.println("the maximum credit is 21");
            System.exit(0);
        }
        else
            this.credit = credit;
    }

    @Override
    public String toString()
    {
        String result;
        result = String.format("<Student>\nfirst name : %s\nlast name : %s\nbirthday : %s\ncredit : %d\n",
                                firstName, lastName,birthday,credit);
        return result;
    }
}
