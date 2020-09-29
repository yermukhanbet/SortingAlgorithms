import java.util.Scanner;
import java.util.*;

public class BucketSort {

	static float[] copyArray(float[] array,int size) {
		float newArray[] = new float[size];
		int i=0;
		for(i=0;i<size;i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	static float[] changeBase(float[] array) {
		int i=0;
		for(i=0;i<array.length;i++) {
			array[i] = array[i]*10;
		}
		return array;
	}
	static float[] BucketSort(float[] array) {
		float sortedArray[] = new float[array.length];
		float newArray[] = new float[array.length];
		int index = 0;
		int j=0;
		int numberOfElementsInBucket = 0;
		
		//newArray = changeBase(array);
		
		LinkedList<Float> bucket[] = new LinkedList[10];
		for(int i=0;i<10;i++) {
			bucket[i] = new LinkedList<Float>();
		}
		//System.out.println(array.length);
		for(int i=0;i<array.length;i++) {
			index = (int) (array[i]*10);
			//System.out.print(index + " ");
			bucket[index].add(array[i]);
		}
		for(int i=0;i<10;i++) {
			Collections.sort(bucket[i]);
		}
		for(int i=0;i<10;i++) {
			if(bucket[i].size()>0) {
				numberOfElementsInBucket = bucket[i].size();
				for(int k=0;k<numberOfElementsInBucket;k++) {
					sortedArray[j]=bucket[i].removeFirst();
					j++;
				}
			}
		}
		return sortedArray;
	}
	static void printArray(float[]array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
	}
	public static void main(String[] args) {
		float A[] = new float[1000];
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		Scanner lineScan = new Scanner(line);
		while(lineScan.hasNextFloat()) {
			A[i]=lineScan.nextFloat();
			i++;
		}
		float array[] = new float[i];
		array = copyArray(A,i);
		//printArray(array);
		array = BucketSort(array);
		printArray(array);

	}

}
