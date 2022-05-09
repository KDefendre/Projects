# Projects
package sorting;

import java.util.*;

public class Sort {
	
	
	public static int[] insertion_sort (int[] array) {
		/*
		 * fill in your program
		 * 
		 */ 
		for(int i = 1; i<array.length; i++){
			
				int j = i - 1;
				
				while(j >= 0 && array[j]>array[i] ){
					
					array[j+1] = array[j];
					
					j--;
		  
				}
				
				array[j+1] = array[i];
			}
		return array;
		}

	 
	
	public static int[] merge_sort (int[] array, int p, int r) {
		
		 // fill in your program
		 
	
		if(p < r) {
			
			int q = (p+r)/2;
			
			merge_sort(array,p,q);
			
			merge_sort(array,q+1,r);
			
		    merge(array,p,q,r);
		}
		 return array;

	}
	
	public static int[] merge (int[] array, int p, int q, int r) {
		
		 // fill in your program
		 
		
		int temp[] = new int[array.length];
		
		int num1 = q-p+1;
		
		int num2 = r-q;
		
		 int left[] = new int[q - p +1+1];
		 
		 int right[] = new int[r-q+1];
		 
		 for( int i = 0; i<num1; i++){
			 
			 left[i] = array[p+i];
			 
			 }
	     for(int j = 0; j<num2;j++){
	    	 
			 right[j] = array[q+1+j];
			 
			 }
	     left[num1] = Integer.MAX_VALUE;
	     
	     right[num2] = Integer.MAX_VALUE;
	     
	     int k = p;
	     
	     int i = 0;
	     
	     int j = 0;
	     
	     while(i<num1&&j<num2){
	    	 
	    	if(left[i]<=right[j])
	    		
	    	{
	    		temp[k] = left[i];
	    		
	    		i++;
	    	
	    	}
	    	else{
	    		
	    		temp[k] = right[j];
	    		
	    		j++;
	    	}
	    	k++;
	     }
	     while(j<num2){
	    	 
	    	 temp[k] = right[j];
	    	 
	    	 j++;
	    	 
	    	 k++;
	     }
	     while(i<num1){
	    	 
	    	 temp[k] = left[i];
	    	 
	    	 i++;
	    	 
	    	 k++;
	     }
	       
	     for (int m=0; m<array.length; m++) {
	    	 
	    	 array[m]=temp[m];
	     }
		 
	     return array;

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
		
		System.out.println("Insertion sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort.insertion_sort(array);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Insertion sort ends ------------------");

		
		System.out.println("Merge sort starts ------------------");
		for (int n = 10; n <= 100000; n=n*2) {
			int[] array = Sort.generate_random_array(n);
			long t1 = System.currentTimeMillis();
			array = Sort.merge_sort(array, 1, n-1);
			long t2 = System.currentTimeMillis();
			long t = t2 - t1;
			boolean flag = Sort.check_sorted(array);
			System.out.println(n + "," + t + "," + flag);
		}
		System.out.println("Merge sort ends ------------------");
	}

}
