import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        SortedSet<String> names = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter List of names (When You finish Enter '-' : ");
        int count =1;
        while(true) {
            System.out.print(count+". ");
            String name = scanner.nextLine();
            if(name.equals("-"))break;
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            names.add(name);
            count++;
        }
        Iterator<String> iterator = names.iterator();
        System.out.println("""
                ---------------------------------------------------------------
                                    🧾 Sorted Name List
                ---------------------------------------------------------------
                """);
        do {
            System.out.println(iterator.next());
        } while (iterator.hasNext());
    }



}