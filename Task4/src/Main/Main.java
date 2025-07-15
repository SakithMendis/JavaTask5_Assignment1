package Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public HashMap<Character, Integer>  textExtract(String input) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (c == ' ') continue;  // Skip spaces
            frequencyMap.put(c, frequencyMap.getOrDefault(c,0) + 1);
        }
        return frequencyMap;
    }

    public void print(HashMap<Character, Integer> frequencyMap) {
        Iterator<Map.Entry<Character, Integer>> iterator = frequencyMap.entrySet().iterator();
        for (Map.Entry<Character, Integer> frequencyMapValues : frequencyMap.entrySet()) {
            System.out.println(frequencyMapValues.getKey() + ": " + frequencyMapValues.getValue());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        main.print(main.textExtract(input));

    }
}