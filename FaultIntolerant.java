import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FaultIntolerant{
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("logfile.txt"));
			String line = bf.readLine();
	
			//array that stores the message/event type
			String[] values = new String[1000];
			while ((line = bf.readLine()) != null) {
				values = line.split(",");
				
				for (String s : values) {       //looking for "error" occurence
	                if ("1: 1631077133.1621487 ERROR Carrier signal lost.".equals(s)) {
                        System.out.println(Arrays.toString(values));
		            }
                }
			}
			bf.close();
            
    	} catch (FileNotFoundException e) {
            System.out.println("Cannot find logfile!");
			System.out.println("Exiting...");
			System.exit(0);
        }catch(Exception e){
			System.out.println("1: 1631077133.1621487 ERROR Carrier signal lost.");
		}
    }
}