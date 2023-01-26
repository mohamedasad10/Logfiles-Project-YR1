//Author        : Mohamed Asad Bandarkar
//Student Number: 4271451
//Main code taken from and edited by me https://www.geeksforgeeks.org/read-file-into-an-array-in-java/#:~:text=In%20Java%2C%20we%20can%20store,or%20by%20using%20readAllLines%20method.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display {
	public static void main(String[] args)throws IOException{
		try{
			List<String> listOfStrings = new ArrayList<String>();	
			BufferedReader bf = new BufferedReader(new FileReader("logfile.txt"));
	
			// reading entire line as string
			String line = bf.readLine();
	
			// checking for end of file
			while (line != null) {
				listOfStrings.add(line);
				line = bf.readLine();
			}
			bf.close();
	
			// storing the data from the arraylist to array
			String[] array = listOfStrings.toArray(new String[0]);

			//creating a new array to store the two input values from the user 
			String [] input ;
            int input1;
			int input2;
			Scanner num = new Scanner(System.in);
            System.out.println("Enter a start and end index separated by a space: ");
        
            input = num.nextLine().split(" ");
            input1 = Integer.parseInt(input[0]);
            input2 = Integer.parseInt(input[1]);
			
			
			//Copies the given range of the array and prints out to the terminal
			Object copy[] = Arrays.copyOfRange(array, input1,input2 + 1);
        	for (int i = 0; i < copy.length; i++){
            	System.out.println(copy[i]);
			}
		
		}catch (FileNotFoundException e) {
            System.out.println("Cannot find logfile!");
			System.out.println("Exiting...");
			System.exit(0);
		}
		
	}	
}