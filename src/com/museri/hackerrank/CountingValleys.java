package com.museri.hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	int nivel=0;
    	int valleys=0;
    	char[] chars= s.toCharArray();
    	for (int i = 0; i < chars.length; i++) {
    		
    		if (chars[i]=='D') {
    			if (nivel==0) valleys+=1;
    			nivel= nivel-1;
    		}
    		if (chars[i]=='U') nivel= nivel+1;
 		}
    	return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
