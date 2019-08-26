package com.museri;

import java.util.Arrays;

public class SortAlgorithms {
	
	

	public static void main(String[] args) {
		int[] lst = {4,9,7,1,3,6,5};
		selectionSort(lst);
		System.out.println(Arrays.toString(lst));
	}
	static void selectionSort(int[] lst) {
		
		for (int i = 0; i < lst.length; i++) {
			int minIndex=i;	
			for (int j = i; j < lst.length; j++) {
				if (lst[minIndex]>lst[j]) {
					minIndex=j;
				}
			}
			//swapeo
			int tmp =lst[i];
			lst[i]=lst[minIndex];
			lst[minIndex]=tmp;
		}
	}
	
	static void bubbleSort(int[] lst) {
		int n = lst.length;
		boolean swapped;
		do 
		{
			swapped = false;
			for (int i = 0; i < n-1; i++) {
				if (lst[i] > lst[i+1]) {
					int temp = lst[i];
					lst[i] = lst[i+1];
					lst[i+1] = temp;
					swapped = true;
				}
			}
		} while (swapped == true);
		
		System.out.println(Arrays.toString(lst));
	}
	
	
}
