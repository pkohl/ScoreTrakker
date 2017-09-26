import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {

	private ArrayList<Student> studentList;
	
	public ScoreTrakker() {
		studentList = new ArrayList<Student>();
	}
	
	public void loadDataFromFile(String inputFileName) throws FileNotFoundException{
		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		
		while (in.hasNextLine()){
			Student currentStudent = new Student();
			currentStudent.name = in.nextLine();
			currentStudent.score = Integer.parseInt(in.nextLine());
			studentList.add(currentStudent);
		}
		
	}
	
	public void printInOrder(){
		Collections.sort(studentList);
		for (Student student : studentList){
			System.out.println(student);
		}
	}
	
	public void processFiles() throws FileNotFoundException{
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
	
	

}
