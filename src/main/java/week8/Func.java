package week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Func {
    final ArrayList<String> list = new ArrayList<String>(
            Arrays.asList(
                    "Malfurion",
                    "Uther",
                    "Thrall",
                    "Guldan",
                    "Anduin",
                    "Rexxar",
                    "Jaina",
                    "Valeera",
                    "Garrosh"
            )
    );

    final Wordbook wordbook = new Wordbook(list);

    public void show()
    {
        System.out.println("input 'stop' if you want");
        System.out.println("=====Created words=====");
        System.out.println(list);
    }

    public void input()
    {
        Scanner scanner = new Scanner(System.in);
        String name;
        try
        {
            while (wordbook.getSize() > 0) {
                show();
                name = scanner.nextLine();
                wordbook.enter(name);
                System.out.flush();
            }
        } catch (Exception err) {
            err.printStackTrace();
            System.out.println("다시 입력");
            input();
        }
    }
}
