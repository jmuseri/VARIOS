package com.museri.hackerrank;

import java.util.Scanner;

public class Palindrome{


public static boolean isPalindrome(String word) {
	      String reverse = null;
			int length = word.length();   
	      for ( int i = length - 1; i >= 0; i-- )  
	         reverse = reverse + word.charAt(i);  
	      
	      
	      if (word.equals(reverse))  
	         return true;  
	      else  
	         return false;   
	   }

	public static void main(String[] args) {
		  Scanner reader = new Scanner(System.in);
		  String word = reader.nextLine();
		  System.out.println(isPalindrome(word));
		  reader.close();
	}

}