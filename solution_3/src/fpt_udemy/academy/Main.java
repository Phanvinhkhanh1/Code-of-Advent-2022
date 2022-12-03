package fpt_udemy.academy;

import java.io.*;
import java.util.*;

public class Main {

    static String url = "D:\\WorkSpace\\Code-of-Advent-2022\\solution_3\\input_3.txt";

    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println(handleFirstLogic());
        System.out.println(handleSecondLogic());

    }

    static long handleFirstLogic() throws IOException {
        File file = new File(url);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        long result = 0l;
        while ((line = br.readLine()) != null) {
            int size = line.length();
            Set<Character> s1 = new HashSet<>();
            Set<Character> s2 = new HashSet<>();
            String first = line.substring(0, size / 2);
            for (char c : first.toCharArray()) {
                s1.add(c);
            }
            String second = line.substring(size / 2, size);
            for (char c : second.toCharArray()) {
                s2.add(c);
            }

            s1.retainAll(s2);

            char c = (char) s1.toString().charAt(1);
            if (c >= 'a' && c <= 'z') {
                result += 1 + (c - 'a');
            } else if (c >= 'A' && c <= 'Z') {
                result += 27 + (c - 'A');
            }
        }

        return result;
    }

    static long handleSecondLogic() throws IOException {
        File file = new File(url);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        long result = 0l;
        int count = 0;
        Set<Character> current_set = new HashSet<>();
        Set<Character> prev_set = new HashSet<>();
        Set<Character> next_set = new HashSet<>();
        while ((line = br.readLine()) != null) {
            if (count == 0) {
                for (char c : line.toCharArray()) {
                    prev_set.add(c);
                }
            }
            if (count == 1) {
                for (char c : line.toCharArray()) {
                    current_set.add(c);
                }
            }
            if (count == 2) {
                for (char c : line.toCharArray()) {
                    next_set.add(c);
                }

                current_set.retainAll(prev_set);
                next_set.retainAll(current_set);

                char c = (char) next_set.toString().charAt(1);
                if (c >= 'a' && c <= 'z') {
                    result += 1 + (c - 'a');
                } else if (c >= 'A' && c <= 'Z') {
                    result += 27 + (c - 'A');
                }

                prev_set.clear();
                current_set.clear();
                next_set.clear();
            }

            count = (count + 1) % 3;
        }

        return result;
    }
}
