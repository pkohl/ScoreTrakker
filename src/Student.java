
/**
 * 
 * Class Student
 * Student object holds name and score information for a single student.
 * Includes toString and compareTo methods.
 * 
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 *
 */
public class Student implements Comparable<Student>{

	String name;
	int score; // Student's score - not specific about what the score is for
	
	public Student() {
		score = 0;
		name = "";
	}
	
	
	// compareTo compares students by their scores, not their names
	@Override
	public int compareTo(Student otherStudent) {
		int compareResult;
		if (score < otherStudent.score){
			compareResult = -1;
		}
		else if (score == otherStudent.score){
			compareResult = 0;
		}
		else compareResult = 1;
		return compareResult;
	}


	@Override
	public String toString() {
		return name + " " + score;
	}
	
	

}
