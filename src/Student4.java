
public class Student4 {
	 String name;
	 int score;
	static int counter = 0;
	Student4(String name) {
		this.name = name;
		System.out.println("名前は" + name + "です");
		counter ++;
	}
	Student4(String name, int score){
		this.name= name;
		this.score = score;
		counter ++;
		score ++;
		System.out.println("名前は" + this.name + "です。点数は" + this.score + "です。"+ score);
	}
	
	static void display() {
		System.out.println(counter + "人目です");
		System.out.println("-----");
	}
}
