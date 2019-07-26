package com.museri.hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SockMerchant {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		HashMap<Integer, Integer> inventory = new HashMap<Integer, Integer>();

		int matchingPairs = 0;

		for (int i = 0; i < n; i++) {
			int color = ar[i];

			// This checks if we already have 1 sock of that color and if we do then we
			// increment matchingPairs and set unmatched //socks of that color back to 0
			if (inventory.containsKey(color) && inventory.get(color).equals(1)) {
				inventory.put(color, 0);
				matchingPairs++;
				continue;
			}
			inventory.put(color, 1);
		}
		return matchingPairs;
	}
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}