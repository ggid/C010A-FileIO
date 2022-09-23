import java.util.ArrayList;

public class Student implements Comparable<Student> {
	
	private String name;
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		// TODO: match format in figure 1
		
		return "Student [name=" + name + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}


	@Override
	public int compareTo(Student o) {
		
		return this.getName().compareTo(o.getName());
	}
	
	
}
