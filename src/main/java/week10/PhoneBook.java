package week10;

import java.lang.String;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> phonebook;

    public PhoneBook() {
        phonebook = new HashMap<String, String>();
    }

    public String get(String name) {
        return phonebook.get(name);
    }

    public boolean containsName(String name) {
        return phonebook.containsKey(name);
    }

    public boolean containsNum(String number) {
        return phonebook.containsValue(number);
    }

    public Boolean add(String name, String phonenumber) {
        if(containsName(name) || containsNum(phonenumber)) {
            return false;
        }
        else {
            phonebook.put(name, phonenumber);
            return true;
        }
    }

    public Boolean delete(String name) {
        if(containsName(name) == true) {
            phonebook.remove(name);
            return true;
        }
        else {
            return false;
        }
    }

    public Set<Person> list() {
        HashSet<Person> result = new HashSet<Person>();
        for(String name : phonebook.keySet()) {
            String phonenumber = phonebook.get(name);
            result.add(new Person(name, phonenumber));
        }
        return result;
    }
}
