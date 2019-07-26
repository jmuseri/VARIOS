package com.museri.hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NumerosPrimos {

    // Complete the primality function below.
    // Complete the primality function below.
    static String primality(int n) {

          int contador = 2;
          boolean primo=true;
          if (n%2==0){
              primo =false;
          }else{
                if ((n>2)){
                    while ((primo) && (contador!=n)){
                        if (n % contador == 0)
                        primo = false;
                        contador++;
                    }
                }
          }
          return (primo?"Prime":"Not prime");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}