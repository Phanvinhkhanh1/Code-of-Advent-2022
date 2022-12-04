package fpt_udemy.academy;

import java.io.*;

public class Main {

    static String url = "D:\\WorkSpace\\Code-of-Advent-2022\\solution_4\\input.txt";

    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println(handleFirstLogic());
        System.out.println(handleSecondLogic());
    }

    static long handleFirstLogic() throws IOException {
        File file = new File(url);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        long result = 0;
        while ((line = br.readLine()) != null) {
            String arr[] = line.split(",");
            long num1 = Long.parseLong(arr[0].split("-")[0]);
            long num2 = Long.parseLong(arr[0].split("-")[1]);
            long num3 = Long.parseLong(arr[1].split("-")[0]);
            long num4 = Long.parseLong(arr[1].split("-")[1]);

            if ((num1 <= num3 && num2 >= num4) || (num1 >= num3 && num4 >= num2)) {
                result++;
            }
        }

        return result;
    }

    static long handleSecondLogic() throws IOException {
        File file = new File(url);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        long result = 0;
        while ((line = br.readLine()) != null) {
            String arr[] = line.split(",");
            long num1 = Long.parseLong(arr[0].split("-")[0]);
            long num2 = Long.parseLong(arr[0].split("-")[1]);
            long num3 = Long.parseLong(arr[1].split("-")[0]);
            long num4 = Long.parseLong(arr[1].split("-")[1]);

            if ((num3 >= num1 && num3 <= num2) || (num1 >= num3 && num1 <= num4)) {
                result++;
            }
        }

        return result;
    }
}
