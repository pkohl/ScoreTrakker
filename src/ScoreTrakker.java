import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * 
 * Class ScoreTrakker
 * Cycles through specified text files as inputs.
 * Reads student names and scores into an ArrayList.
 * Sorts and prints student names and scores.
 * Handles bad file names and bad student scores.
 * 
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 *
 */
public class ScoreTrakker {

	private ArrayList<Student> studentList;
	
	// list of files from which to draw student information
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	
	public ScoreTrakker() {
		studentList = new ArrayList<Student>();
	}
	
	
	/**
	 * Loads Student data from a file, checking for bad file names and
	 * non-numeric scores.
	 * 
	 * @param inputFileName Name of the file to be read from
	 * @throws FileNotFoundException
	 */
	public void loadDataFromFile(String inputFileName) throws FileNotFoundException{
		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		
		// read students in one at a time, expecting one line for the student name
		// followed by one line for the student score
		while (in.hasNextLine()){
			Student currentStudent = new Student();
			
			// declare a string to hold the score so we can access it with the try-catch
			String score = "";  
			try{
				currentStudent.name = in.nextLine();
				score = in.nextLine();
				currentStudent.score = Integer.parseInt(score);
				studentList.add(currentStudent);
				}
			catch(NumberFormatException e){
				System.out.println("Incorrect format for " + currentStudent.name + " not a valid score: " + score);
				System.out.println();
			}
		}
		
	}
	
	
	/**
	 * Sorts the students in studentList and prints their names and scores.
	 */
	public void printInOrder(){
		Collections.sort(studentList);
		System.out.println("Student Score List");
		for (Student student : studentList){
			System.out.println(student);			
		}
		System.out.println();
	}
	
	
	/**
	 * Loops through several file names and attempts to process each in turn.
	 * Handles bad file names.
	 */
	public void processFiles(){
		for(String file : files){
			try{
				loadDataFromFile(file);
				printInOrder();		
			}
			catch(FileNotFoundException e){
				System.out.println("Can't open file: " + file);
			}
			// After each file, clear studentList in preparation for the next file.
			studentList.clear();
			
		}		
	}
	
	public static void main(String[] args){
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
	
	

}
