package fpt_udemy.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static String input_url = "D:\\WorkSpace\\Code-of-Advent-2022\\solution_8\\input.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(handleFirstLogic());
        System.out.println(handleSecondLogic());
    }

    static long handleFirstLogic() throws IOException {
        ArrayList<String> input = convertInput();
        ArrayList<String> columnsDirection = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String s = "";
            for (int j = 0; j < input.size(); j++) {
                s += input.get(j).charAt(i);
            }
            columnsDirection.add(s);
        }
        //
        long ans = 4 * (input.size() - 1);
        for (int i = 1; i <= input.size() - 2; i++) {
            for (int j = 1; j <= input.size() - 2; j++) {
                if (maxLeftOrRight(input.get(i), j) || maxTopOrBottom(columnsDirection.get(j), i)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    static long handleSecondLogic() throws IOException {
        ArrayList<String> input = convertInput();
        ArrayList<String> columnsDirection = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String s = "";
            for (int j = 0; j < input.size(); j++) {
                s += input.get(j).charAt(i);
            }
            columnsDirection.add(s);
        }
        //
        long ans = 1l;
        for (int i = 1; i <= input.size() - 2; i++) {
            for (int j = 1; j <= input.size() - 2; j++) {
                ans = Math.max(ans, countLeftOrRight(input.get(i), j) * countTopOrBottom(columnsDirection.get(j), i));
            }
        }

        return ans;
    }

    static ArrayList<String> convertInput() throws IOException {
        File file = new File(input_url);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            arrayList.add(line);
        }

        return arrayList;
    }

    static boolean maxLeftOrRight(String inputData, int index) {
        String leftString = inputData.substring(0, index);
        String rightString = inputData.substring(index + 1);

        long maxLeftString = maxValue(leftString);
        long maxRightString = maxValue(rightString);
        long value = Long.parseLong(String.valueOf(inputData.charAt(index)));

        if (value > maxLeftString || value > maxRightString)
            return true;
        return false;
    }

    static boolean maxTopOrBottom(String inputData, int index) {
        String topString = inputData.substring(0, index);
        String bottomString = inputData.substring(index + 1);

        long maxTopString = maxValue(topString);
        long maxBottomString = maxValue(bottomString);
        long value = Long.parseLong(String.valueOf(inputData.charAt(index)));

        if (value > maxTopString || value > maxBottomString)
            return true;
        return false;
    }

    static long maxValue(String s) {
        long ans = Long.parseLong(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            ans = Math.max(ans, Long.parseLong(String.valueOf(s.charAt(i))));
        }

        return ans;
    }

    static long count(long value, String s, String direction) {
        long ans = 0;
        int index;
        if (direction == "left" || direction == "top") {
            index = s.length() - 1;
            while (index >= 0 && value > Long.parseLong(String.valueOf(s.charAt(index)))) {
                ans++;
                index--;
            }
            if (index > 0) {
                if (value == Long.parseLong(String.valueOf(s.charAt(index)))) {
                    ans++;
                }
            } else if (index == 0) {
                ans++;
            }
        } else if (direction == "right" || direction == "bottom") {
            index = 0;
            while (index <= s.length() - 1 && value > Long.parseLong(String.valueOf(s.charAt(index)))) {
                ans++;
                index++;
            }
            if (index < s.length() - 1) {
                if (value == Long.parseLong(String.valueOf(s.charAt(index)))) {
                    ans++;
                }
            } else if (index == s.length() - 1) {
                ans++;
            }
        }

        return ans;
    }

    static long countLeftOrRight(String inputData, int index) {
        String leftString = inputData.substring(0, index);
        String rightString = inputData.substring(index + 1);

        long value = Long.parseLong(String.valueOf(inputData.charAt(index)));

        return count(value, leftString, "left") * count(value, rightString, "right");
    }

    static long countTopOrBottom(String inputData, int index) {
        String topString = inputData.substring(0, index);
        String bottomString = inputData.substring(index + 1);

        long value = Long.parseLong(String.valueOf(inputData.charAt(index)));

        return count(value, topString, "top") * count(value, bottomString, "bottom");
    }
}
