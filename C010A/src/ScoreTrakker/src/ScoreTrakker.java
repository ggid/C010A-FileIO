import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	// class variables
	private ArrayList<Student> file = new ArrayList<Student>();
	private String[] files = { "scores.txt", "badscore.txt", "nofile.txt" };

	// reads student data from file and stores student object in array list
	public void loadDataFile(String fileName) throws FileNotFoundException {
		
			// clear the array list
			file.clear();
			
			// loading file
			FileReader reader = new FileReader(fileName);
			Scanner scan = new Scanner(reader);
			
			// store into array list
			while (scan.hasNextLine()) {
				
				// getting the name and score of the student
				String stringName = scan.nextLine();
				String line = scan.nextLine();
				
				try {
					
					int score = Integer.parseInt(line);
					// create a new student
					Student superhero = new Student(stringName, score);
					// add to ArrayList
					file.add(superhero);
					
				} catch (NumberFormatException nfe) {
					System.out.println("Incorrect format for " + stringName + " not a valid score: " + line);
			}
			}		
		}

	// sort and print array list
	public void printInOrder() {

		// sorting the array
		Collections.sort(file);

		System.out.println("Superhero Score List");
		// printing out each student and their scores
		for (Student students : file) {
			System.out.println(students.getName() + " " + students.getScore());
		}

	}

	public void processFiles() throws FileNotFoundException {
		
		for (String names : files ) {
			
			try {
				// call functions
				loadDataFile(names);
				printInOrder();
				
			} catch (FileNotFoundException fnfe) {
				System.out.println("Can't open file: " + names);
			}
		}
	

	}

	public static void main(String[] args) throws FileNotFoundException {

		ScoreTrakker trakk = new ScoreTrakker();
		trakk.processFiles();

	}
}
