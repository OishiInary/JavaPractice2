//
//public class Student {
//	public static void main(String[] args) {
//		Student4.display();
//		
//		Student4 stu1 = new Student4("吉村");
//		Student4.display();
//		
//		Student4 stu2 = new Student4("カミーユ");
//		Student4.display();
//		
//		Student4 stu3 = new Student4("ギギギガンデス",65);
//		Student4.display();
//		
//		EliteStudent4 stu4 = new EliteStudent4("木村どぐろう",99);
//		Student4.display();
//		
//		WorstStudent stu5 = new WorstStudent("悪田やさお",6);
//		Student4.display();
//	}
//
//}
class Student{
	public static void main(String[] args) {
		int power;
		power = 5;
		int speed = 88;
		int[] score = new int[4];
		
		String[] name = {"田中", "イキスギ", "三番目の誰か"};
		score[0] = 5;
		score[1] = 11;
		score[2] = 22;
		score[3] = 19;
		System.out.println("おはようございます");
		System.out.println("パワーは" + power);
		System.out.println("スピードは" + speed);
		System.out.println("普通にプロントアウト。名前" + name[0] + "点数は" + score[0]);
		for (int i = 0; i< score.length; i++) {
			System.out.println(name[i] + "さんは" + score[i] + "点です");
		}
	}
}