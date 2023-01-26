import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Summary {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("logfile.txt"));
			String line = bf.readLine();
	
            int counterError = 0;
			int counterWarning = 1;
            int counterNotify = 0;

            //array that stores the message/event type
			String[] values = new String[1000];
			while ((line = bf.readLine()) != null) {
				values = line.split(" ");
                
                for (String s : values) {       //looking for amount of "warning" occurences
	                if ("WARNING".equals(s)) {
                        counterWarning++;
		            }
                }

                for (String s : values) {       //looking for amount of "error" occurences
	                if ("ERROR".equals(s)) {
                        counterError++;
		            }
                }

                for (String s : values) {       //looking for amount of "notify" occurences
	                if ("NOTIFY".equals(s)) {
                        counterNotify++;
		            }
                }

                
            }    
            bf.close();

            System.out.println("Summary");
            System.out.println("-----------------");
            System.out.println("Notifications: " + counterNotify);
            System.out.println("Warnings: " + counterWarning);
            System.out.println("Errors: " + counterError);
            
	
		} catch (FileNotFoundException e) {
            System.out.println("Cannot find logfile!");
			System.out.println("Exiting...");
			System.exit(0);
        }
    }
}