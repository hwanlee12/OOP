package week10;

import java.util.Set;
import java.lang.String;

public class main {
    public static void main(String[] args) {
        String[] names = {
                "Lasandra Packer",
                "Oren Evan",
                "Danelle Wasko",
                "Rich Havel",
                "Kristle Woodruff",
                "Tara Witt",
                "Patti Kellner",
                "Thanh Bunkley",
                "Lorraine Skelly",
                "Lorraine Skelly"
        };

        String[] phoneNumbers = {
                "(958) 416-6820",
                "(958) 416-6820",
                "(422) 559-3857",
                "(673) 509-8613",
                "(551) 981-6195",
                "(892) 408-6187",
                "(554) 452-6981",
                "(531) 558-3976",
                "(260) 206-2730"
        };

        String[] deleteNames = {
                "Lasandra Packer"
        };

        PhoneBook pb = new PhoneBook();

        System.out.println("전화번호부 추가");
        for(int i = 0; i < names.length - 1; i++){
            if(pb.add(names[i],phoneNumbers[i]) == false) {
                System.out.printf("이미 존재 %s\n", new Person(names[i], pb.get(names[i])));
            }
            else {
                System.out.printf("추가 %s\n", new Person(names[i], pb.get(names[i])));
            }
        }
        System.out.println();

        System.out.println("이름 번호 삭제");
        for(int i = 0; i < deleteNames.length; i++) {
            System.out.printf("%s\n",deleteNames[i]);
            pb.delete(deleteNames[i]);
        }
        System.out.println();

        System.out.println("전화번호부 모두 공개");
        Set<Person> list = pb.list();
        for(Person i : list) {
            System.out.println((i));
        }
        System.out.println();
    }
}
