package week8;

import java.util.ArrayList;
import java.util.Scanner;

public class Wordbook implements AutoCloseable {
    ArrayList<String> list;
    Scanner in = new Scanner(System.in);

    public Wordbook(ArrayList<String> list)
    {
        this.list = list;
    }

    public int getSize()
    {
        return list.size();
    }

    public void enter(String name) throws Exception
    {
        if(list.contains(name))
        {
            list.remove(name);
        }
        else if(name.equals("stop"))
        {
            System.out.println("Program finished");
            System.exit(0);
        }
        else if(name.isEmpty())
        {
            System.out.println("You must type a word! Your input is empty");
            throw new Exception("You must type a word! Your input is empty");
        }
        else {
            throw new Exception(name + " is not in the WordBook");
        }
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("=======Remained words=====");
        System.out.println(list);
    }
}
