/**
 *@author Wei Zhang
 *@version build Feb 23, 2013 
 *this class sort the integer array based on the descending order of the integer frequency
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;

public class sortarray {
	/** This function takes in the unsorted pairs of integers and their frequencies, returns 
	 *  the sorted pairs in the descending order of the frequencies 
	 * 
	 * @param IntegerArray			the input integer array
	 * @return			            the Arraylist of sorted integers and their frequencies
	 */
	public static ArrayList<Entry<Integer, Integer>> getSorted(int[] IntegerArray){
		//store the integers in a HashMap, get the frequency of each integer
		Map<Integer, Integer> unsorted = new HashMap<Integer, Integer>();
		for (int i = 0; i < IntegerArray.length; i++) {
                if (unsorted.get(IntegerArray[i]) != null) {  
                    int value = unsorted.get(IntegerArray[i]).intValue();  
                    value++;  
                    unsorted.put(IntegerArray[i], value);  
                } else  
                	unsorted.put(IntegerArray[i], 1);  
            }  
		//save the entrySet of the HashMap into an Arraylist, rearrange the sequence of elements by setting a new comparator
		ArrayList<Map.Entry<Integer, Integer>> sorted = new ArrayList<Map.Entry<Integer, Integer>>(unsorted.entrySet());  
        Collections.sort(sorted, new Comparator<Map.Entry<Integer, Integer>>(){  
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {  
                return (o2.getValue()).compareTo(o1.getValue());  
                }  
			});
        return sorted;
	}
	
	public static void main(String[] args) throws IOException {
		//use standard input to get the integers
		System.out.println("Please input the integers, seperated by space, press enter when ends"); 
		String input = (new Scanner(System.in)).nextLine();
		String[] ary = input.split("\\s+");
		//save the input string to a integer array
		int[] numbersInput = new int[ary.length];
		 for(int i = 0; i < ary.length; i++){
			   numbersInput[i] = Integer.parseInt(ary[i]);
			  }
		 
		ArrayList<Entry<Integer, Integer>> SortedArray=getSorted(numbersInput);
        System.out.println("Display integers in the descending order of their frequencies:");  
        System.out.println(SortedArray);  
		
	}
}
