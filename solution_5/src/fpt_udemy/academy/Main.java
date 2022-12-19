package fpt_udemy.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    static String input_url = "D:\\WorkSpace\\Code-of-Advent-2022\\solution_5\\input.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(handleFirstLogic());
        System.out.println(handleSecondLogic());
    }

    static String handleFirstLogic() throws IOException {
        File file = new File(input_url);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String ans = "";
        String line;
        ArrayList<Stack<String>> stackArrayList = new ArrayList<>();
        String[] arrayList = new String[]{"LNWTD", "CPH", "WPHNDGMJ", "CWSNTQL", "PHCN", "THNDMWQB", "MBRJGSL", "ZNWGVBRT", "WGDNPL"};
        for (int i = 0; i < arrayList.length; i++) {
            Stack<String> s = new Stack<>();
            String element = arrayList[i];
            for (int p = 0; p < element.length(); p++)
                s.push(String.valueOf(element.charAt(p)));
            stackArrayList.add(s);
        }
        //
        while ((line = bf.readLine()) != null) {
            String[] arr = line.split(" ");
            int quantity = Integer.parseInt(arr[1]);
            int from = Integer.parseInt(arr[3]);
            int to = Integer.parseInt(arr[5]);
            while (quantity > 0 && !stackArrayList.get(from - 1).empty()) {
                quantity--;
                stackArrayList.get(to - 1).push(stackArrayList.get(from - 1).pop());
            }
        }
        //
        for (int i = 0; i < arrayList.length; i++) {
            if (stackArrayList.get(i).isEmpty())
                ans += "b";
            else
                ans += stackArrayList.get(i).peek();
        }

        return ans;
    }

    static String handleSecondLogic() throws IOException {
        File file = new File(input_url);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String ans = "";
        String line;
        ArrayList<Stack<String>> stackArrayList = new ArrayList<>();
        String[] arrayList = new String[]{"LNWTD", "CPH", "WPHNDGMJ", "CWSNTQL", "PHCN", "THNDMWQB", "MBRJGSL", "ZNWGVBRT", "WGDNPL"};
        for (int i = 0; i < arrayList.length; i++) {
            Stack<String> s = new Stack<>();
            String element = arrayList[i];
            for (int p = 0; p < element.length(); p++)
                s.push(String.valueOf(element.charAt(p)));
            stackArrayList.add(s);
        }
        //
        while ((line = bf.readLine()) != null) {
            String[] arr = line.split(" ");
            int quantity = Integer.parseInt(arr[1]);
            int from = Integer.parseInt(arr[3]);
            int to = Integer.parseInt(arr[5]);
            String originalData = arrayList[from - 1];
            Stack<String> middle = new Stack<>();
            while (quantity > 0) {
                middle.push(stackArrayList.get(from - 1).pop());
                quantity--;
            }
            while (!middle.isEmpty()) {
                stackArrayList.get(to - 1).push(middle.pop());
            }
        }
        //
        for (int i = 0; i < arrayList.length; i++) {
            if (stackArrayList.get(i).isEmpty())
                ans += "b";
            else
                ans += stackArrayList.get(i).peek();
        }

        return ans;
    }
}
