package week6;

public class Member {
    protected String firstName;
    protected String lastName;
    protected String birthday;

    public Member(String firstName, String lastName, String birthday)
    {
        if(firstName.length() > 20)
        {
            System.out.println("the maximum length of first name is 20");
            System.exit(0);
        }
        else
            this.firstName = firstName;

        if(lastName.length() > 20)
        {
            System.out.println("the maximum length of last name is 20");
            System.exit(0);
        }
        else
            this.lastName = lastName;

        if(birthday.length() > 8)
        {
            System.out.println("the maximum length of birthday is 8");
            System.exit(0);
        }
        else
            this.birthday = birthday;
    }

    public String toString()
    {
        String result;
        result = String.format("<Member>\nfirst name : %s\nlast name : %s\nbirthday : %s\n",
                firstName, lastName,birthday);
        return  result;
    }
}
