package week2.src.Lab2;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("<Body Mass Calculator>");
        System.out.println("Eneter 1 for(K,M), 2 for (P, I) :");

        Scanner in = new Scanner(System.in);
        int select = in.nextInt();

        System.out.println("How many? : ");
        int num = in.nextInt();
        human[] bmi_list = new human[num];

        int test = 0;
        int weight;
        float height;
        float result = 0;

        switch(select){
            case 1 :
                System.out.println("kg, meter");
                for(int i = 0; i < num; i++){
                    System.out.println("Enter Weight : ");
                    weight = in.nextInt();
                    System.out.println("Enter Height : ");
                    height = in.nextFloat();
                    //bmi_list[i] = new human(weight, height, result);
                    bmi_list[i] = new human(test, test, result);
                    bmi_list[i].setWeight(weight);
                    bmi_list[i].setHeight(height);
                }
                break;

            case 2:
                System.out.println("pound inch");
                for(int i = 0; i < num; i++){
                    System.out.println("Enter Weight : ");
                    weight = in.nextInt();
                    System.out.println("Enter Height : ");
                    height = in.nextFloat();
                    //bmi_list[i] = new human(weight, height, result);
                    bmi_list[i] = new human(test, test, result);
                    bmi_list[i].setWeight(weight);
                    bmi_list[i].setHeight(height);
                }
                break;
        }

        for(int i = 0; i < num; i++) {
            System.out.printf("person %d BMI is : %.4f\n", i + 1, bmi_list[i].getResult(select));
        }
    }
}
