
/**
 * @author pkohl
 *
 */
public class Student implements Comparable<Student>{

	String name;
	int score;
	public Student() {
		score = 0;
		name = "";
	}
	
	
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
