package sorting;

import java.util.*;

public class Sort2 {
	
	public static int left (int i) {
		/*
		 * fill in your program
		 */
	}
	
	public static int right (int i) {
		/*
		 * fill in your program
		 */
	}
	
	public static int parent (int i) {
		/*
		 * fill in your program
		 */
	}
	
	public static int[] max_heapify (int[] array, int heap_size, int i) {
		/*
		 * fill in your program
		 */
	}
	
	public static int[] build_heap (int[] array) {
		/*
		 * fill in your program
		 */
	}
	
	public static int[] heap_sort (int[] array) {
		/*
		 * fill in your program
		 */
	}
	
	public static int[] quick_sort (int[] array, int p, int r) {
		/*
		 * fill in your program
		 */
	}
	
	public static int partition (int[] array, int p, int r) {
		/*
		 * fill in your program
		 */
	}
	
	/*
	 * the values in array range from 0 to k
	 */
	public static int[] counting_sort (int[] array, int k) {
		/*
		 * fill in your program
		 */
	}
	
	/*
	 * n: the size of the output array
	 * k: the maximum value in the array
	 */
	public static int[] generate_random_array (int n, int k) {
		List<Integer> list;
		int[] array;
		Random rnd;
		
		rnd = new Random(System.currentTimeMillis());
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(rnd.nextInt(k+1)));
		
		Collections.shuffle(list, rnd);
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * n: the size of the output array
	 */
	public static int[] generate_random_array (int n) {
		List<Integer> list;
		int[] array;
		
		list = new ArrayList<Integer> ();
		for (int i = 1; i <= n; i++) 
			list.add(new Integer(i));
		
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
		
		array = new int[n];
		for (int i = 0; i < n; i++) 
			array[i] = list.get(i).intValue();
		
		return array;
	}
	
	/*
	 * Input: an integer array
	 * Output: true if the array is acsendingly sorted, otherwise return false
	 */
	public static boolean check_sorted (int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i])
				return false;
		}
		return true;
	}
	
	public static void print_array (int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 100;
		
		System.out.println("Heap sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort2.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort2.heap_sort(array);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort2.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Heap sort ends ------------------");

		
		System.out.println("Quick sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort2.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort2.quick_sort(array, 0, n-1);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort2.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Quick sort ends ------------------");
		
		System.out.println("Counting sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort2.generate_random_array(n, k);
			long t1 = System.currentTimeMillis();
			array = Sort2.counting_sort(array, k);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort2.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Counting sort ends ------------------");
	}

}
