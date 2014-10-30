import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class Parser {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Import Car Parser
		Scanner fileInput = new Scanner(new File("import.txt"));
		
		//Saves String variable to output final result
		String endCopy = "";
		
		//Parsing through all text
		while(fileInput.hasNextLine()) {
			Scanner line = new Scanner(fileInput.nextLine());
			line.useDelimiter("\t");
			
			//Breaking down the line into individual variables
			String sku = line.next();
			String year = line.next();
			String make = line.next();
			String model = line.next();
			
			//Converts the lines that feature a range of years to individual lines with only one year
			if (year.contains("-")) {
				Scanner temp = new Scanner(year);
				temp.useDelimiter("-");
				int startYear = Integer.parseInt(temp.next());
				int endYear = Integer.parseInt(temp.next());
				
				//Include a new line in endCopy with the left "startYear" range.
				//Adds 1 to "startYear"
				//Keeps making new lines with same pattern until startYear reaches endYear

				while(startYear != endYear + 1) { //the +1 is added to endYear so the endYear is also included
					endCopy += sku + "\t" + startYear + "\t" + make + "\t" + model + "\n";
					startYear++;
				}
			
			//Another case of range of years that needs formatting
			} else if (year.contains("+")) {
				int tempYear = Integer.parseInt(year.substring(0, year.length() - 1));
				while (tempYear != 2016) {
					endCopy += sku + "\t" + tempYear + "\t" + make + "\t" + model + "\n";
					tempYear++;
				}
				
			//If line does not need formatting, add it to endCopy as it is.
			} else {
				endCopy += sku + "\t" + year + "\t" + make + "\t" + model + "\n";;
			}
		}
		
		//outputs endCopy to text file
		PrintWriter out = new PrintWriter("output.txt");
		out.println(endCopy);
		out.close();
	}

}
