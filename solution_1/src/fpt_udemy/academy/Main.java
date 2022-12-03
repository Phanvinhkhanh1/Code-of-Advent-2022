package fpt_udemy.academy;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static String url = "D:\\WorkSpace\\Code-of-Advent-2022\\solution_1\\day_1_input.txt";

    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println(handleFirstQuestion());
        System.out.println(handleSecondQuestion());
    }

    static long handleFirstQuestion() throws IOException {
        File file = new File(url);
        BufferedReader bf = new BufferedReader(new FileReader(file));

        String line;
        long result = 0l;
        long prev_result = 0l;
        while ((line = bf.readLine()) != null) {
            if (line.isBlank()) {
                result = Math.max(result, prev_result);
                prev_result = 0l;
            } else {
                prev_result += Long.parseLong(line);
            }
        }
        return result;
    }

    static long handleSecondQuestion() throws IOException {
        File file = new File(url);
        BufferedReader bf = new BufferedReader(new FileReader(file));

        String line;
        long result = 0l;
        List<Long> arr = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            if (line.isBlank()) {
                arr.add(result);
                result = 0l;
            } else {
                result += Long.parseLong(line);
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        return arr.get(0) + arr.get(1) + arr.get(2);
    }
}
