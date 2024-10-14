
 abstract class Club {
	String name;
	Club(String name){
		this.name = name;
	}
	void display() {
		System.out.println("部活は" + name);
	}
	abstract void practice();

}
//abstractの付いたこのクラスは　抽象クラス　といい実体がないためインスタンス化できない！
//大本であり型だけといえば分かりやすいかもしれない。