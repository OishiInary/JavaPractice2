
public class Student {
	public static void main(String[] args) {
		Student4.display();
		
		Student4 stu1 = new Student4("吉村");
		Student4.display();
		
		Student4 stu2 = new Student4("カミーユ");
		Student4.display();
		
		Student4 stu3 = new Student4("ギギギガンデス",65);
		Student4.display();
		
		EliteStudent4 stu4 = new EliteStudent4("木村どぐろう",99);
		Student4.display();
		
		WorstStudent stu5 = new WorstStudent("悪田やさお",6);
		Student4.display();
	}

}
