package week4;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static int calAvrg(member[] club)
    {
        int average = 0;
        int sum = 0;

        for(int i = 0; i < club.length; i++)
            sum += club[i].getAge();

        average = sum / club.length;

        return average;
    }

    public static ArrayList<String> findintersec(member[] club1, member[] club2)
    {
        ArrayList<String> person = new ArrayList<String>();
        for(int i = 0; i < club1.length; i++)
        {
            for(int j = 0; j < club2.length; j++)
            {
                if(club1[i].getName().equals(club2[j].getName()))
                {
                    person.add(club1[i].getName());
                }
            }
        }
        return person;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the number of people in the bicycle club : ");
        int num = in.nextInt();
        member[] bicycle = new member[num];
        for(int i = 0; i < num;i++)
        {
            System.out.printf("Enter the Member %d's name : ", i+1);
            String name = in.next();
            System.out.printf("Enter the Member %d's age : ", i+1);
            int age = in.nextInt();
            bicycle[i] = new member(age, name);
        }

        System.out.print("Input the number of people in the tennis club : ");
        num = in.nextInt();
        member[] tennis = new member[num];
        for(int i = 0; i < num;i++)
        {
            System.out.printf("Enter the Member %d's name : ", i+1);
            String name = in.next();
            System.out.printf("Enter the Member %d's age : ", i+1);
            int age = in.nextInt();
            tennis[i] = new member(age, name);
        }

        System.out.println();
        System.out.println("=======================");

        System.out.printf("The average age of the bicycle club = %d\n", main.calAvrg(bicycle));
        System.out.printf("The average age of the bicycle club = %d\n", main.calAvrg(tennis));
        ArrayList<String> result = main.findintersec(bicycle, tennis);
        System.out.println(result + "joined the both clubs");
    }
}
