package day18;

import java.util.ArrayList;

public class ListTest3 {

	public static void main(String[] args) {
		/* indexOf() */
		ArrayList<Student> list = new ArrayList<Student>();
		Student std1 = new Student(1, 1, 1, "홍길동");
		Student std2 = new Student(1, 1, 1, "홍길동");
		list.add(std1);
		
		//Student클래스에서 equals를 만들어 줌(오버라이딩)으로써 객체의 주소가아닌 안에있는 데이터 값을 비교한다.
		System.out.println("리스트에 학생 정보가 있습니까? " + list.indexOf(std2));
		System.out.println("리스트에 학생 정보가 있습니까? " + list.contains(std2));
	}
}

class Student{
	int grade;
	int classNum;
	int num;
	String name;
	
	public Student(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}
	
	//equals를 해줘야 주소값이아닌 데이터값으로 비교해준다.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
	
	
}
