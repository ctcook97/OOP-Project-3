package application;

import java.util.HashMap;
import java.util.Map;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	
	private int[][] array;
	private int defaultVal;
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/* Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		this.array = new int[rows][cols];
		this.defaultVal = defaultVal;
		initArray(defaultVal);
	}
	
	public void initArray(int defaultVal) {
		/* (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		for(int i = 0; i < array.length; ++i) {
			for(int j = 0; j < array[0].length; ++j) {
				array[i][j] = defaultVal;
			}
		}
	}
	
	public String insertInt(int row, int col, int val) {
		/* "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		
		//What if you try and set something that is already the default val to val?
		//Do I need to do checks to make sure row and col are in the array?
		if (array[row][col] == defaultVal) {
			if(val != defaultVal) {
				array[row][col] = val;
				return "Success! " + val + " was inserted.";
			}
			else
				return "Failure: " + val + " is not allowed.";
		}
		else
			return "Failure: "+ row + ", " + col + " is not empty.";
		
	}
	
	public int getInt(int row, int col) {
		/*Return the value at the specified row, col
		 * 
		 */
		
		return array[row][col];
	}
	
	public String getArrayDisplay() {
		/* Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		
		String arrayString = "\n"; //Start with a new line to make the test program look good
		for(int i = 0; i < array.length; ++i) {
			for(int j = 0; j < array[0].length; ++j) {
				arrayString += array[i][j] + " ";
			}
			arrayString += "\n";
		}
		return arrayString;
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		String output = "";
		output += array.length + " rows\n";
		output += array[0].length + " columns\n";
		
		//Uses a hashmap to find the counts of all the different values in the array
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; ++i) {
			for(int j = 0; j < array[0].length; ++j) {
				if (values.containsKey(array[i][j])) {
					values.put(array[i][j], values.get(array[i][j]) + 1);
				}
				else {
					values.put(array[i][j], 1);
				}
			}
		}
		//Adds those values to the output string
		for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
			output += "value:" + entry.getKey() + " count:" + entry.getValue() + "\n";
		}
		
		return output;
	}		

}