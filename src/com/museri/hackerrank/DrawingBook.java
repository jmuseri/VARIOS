package com.museri.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {
	static int pageCount(int n, int p) {
		int i = 1;
		int j = n;
		int min;
		int temp = 0;
		int t = 0;
		while (i < p && i <= n) {
			temp++;
			i = i + 2;
		}
		if (j % 2 != 0) {
			while (j - 1 > p && j >= 0) {
				t++;
				j = j - 2;
			}

		} else {
			while ((j - 1) >= p && j >= 0) {
				t++;
				j = j - 2;
			}

		}
		if (temp > t) {
			min = t;
		} else
			min = temp;
		return min;
	}
	
	   private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

	        int p = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

	        int result = pageCount(n, p);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	
	
}