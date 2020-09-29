
import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

public class RadixSort {
	static int[] copyArray(int[] array,int size) {
		int i=0;
		int newArray[] = new int[size];
		for(i=0;i<size;i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	static int findMax(int[] array) {
		int max = -1;
		for(int i=0;i<array.length;i++) {
			if(max<array[i]) {
				max = array[i];
			}
		}
		return max;
	}
	static int findIndex(int number,int order) {
		int index = 0;
		for(int i=0;i<=order;i++) {
			index = number%10;
			number = number/10;
		}
		return index;
	}
	static int findLength(int number) {
		int length = 0;
		while(number!=0) {
			number = number/10;
			length++;
		}
		return length;
	}
	static void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
	}
	static int[] RadixSort(int[] array) {
		int sortedArray[] = new int[array.length];
		int max = findMax(array);
		int lengthOfDigit = findLength(max);
		int index;
		int order = 0;
		int numberOfElementsInBucket = 0;
		int j=0;
		LinkedList<Integer> bucket[] = new LinkedList[10];
		for(int i=0;i<10;i++) {
			bucket[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<lengthOfDigit;i++) {
			for(j=0;j<array.length;j++) {
				index = findIndex(array[j], i);
				bucket[index].add(array[j]);
			}
			j=0;
			for(int l=0;l<10;l++) {
				if(bucket[l].size()>0) {
					numberOfElementsInBucket = bucket[l].size();
					for(int k=0;k<numberOfElementsInBucket;k++) {
						array[j]=bucket[l].removeFirst();
						j++;
					}
				}
			}
		}
		sortedArray = copyArray(array, array.length);
	return sortedArray;
	}
	
	
	public static void main(String[] args) {
		int A[] = new int[1000];
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		Scanner lineScan = new Scanner(line);
		while(lineScan.hasNextInt()) {
			A[i]=lineScan.nextInt();
			i++;
		}
		//System.out.println("I am out of while");
		int array[] = new int[i];
		array = copyArray(A,i);
		array = RadixSort(array);
		printArray(array);
		
	}


}