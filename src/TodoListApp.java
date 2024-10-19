import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoListApp{
	
	//タスクを保存するリスト
	private static List<String> todoList = new ArrayList<>();
	
	//メインメソッド
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		loadTodoList(); //アプリ起動時にタスクリストを読み込む
		
		while(true) {
			System.out.println("\nTo-Doリストアプリ");
			System.out.println("1: タスクを追加");
			System.out.println("2: タスクを表示");
			System.out.println("3: タスクを削除");
			System.out.println("4: 保存して終了");
			System.out.println("選択してください: ");
			
			String input = scanner.nextLine();
			
			switch (input) {
				case "1" :
					addTask(scanner);
					break;
					
				case "2" :
					showTasks();
					break;
				case "3" :
					removeTask(scanner);
					break;
				case "4" :
					saveTodoList();
					System.out.println("保存して終了します。");
					return;
				default:
					System.out.println("無効な選択です。もう一度お試しください。");	
			}
		}
	}
	
	//タスクを追加する
	private static void addTask(Scanner scanner) {
		System.out.println("追加するタスクを入力してください: ");
		String task = scanner.nextLine();
		todoList.add(task);
		System.out.println("タスクが追加されました。");
		
	}
	
	//タスクを表示する
	private static void showTasks() {
		if (todoList.isEmpty()) {
			System.out.println("タスクリストは空です。");
		} else {
			System.out.println("\n現在のタスク: ");
			for (int i =0; i < todoList.size(); i++) {
				System.out.println((i +1) + ": " + todoList.get(i));
			}
		}
	}
	
	
	private static void removeTask(Scanner scanner) {
		showTasks();
		if (todoList.isEmpty()) {
			return;
		}
		System.out.println("削除するタスクの番号を入力してください: ");
		try {
			int taskNumber= Integer.parseInt(scanner.nextLine());
			if (taskNumber > 0 && taskNumber <= todoList.size()) {
				todoList.remove(taskNumber - 1);
				System.out.println("タスクが削除されました。");
			}else {
				System.out.println("無効な番号です。");
			}
		} catch (NumberFormatException e) {
			System.out.println("無効な入力です。数字を入力してください。");
		}
		
	}
	
	//タスクをファイルに保存する
	private static void saveTodoList() {
		try (BufferedWriter  writer= new BufferedWriter(new FileWriter("todolist.txt"))){
			for (String task : todoList) {
				writer.write(task);
				writer.newLine();
			}
					System.out.println("タスクリストが保存されました。");
		}catch (IOException e) {
			System.out.println("タスクの保存中にエラーが発生しました。");
		}
	}
	//タスクリストをファイルから読み込む
	private static void loadTodoList() {
		try (BufferedReader reader = new BufferedReader(new FileReader("todolist.txt"))){
			String line;
			while ((line = reader.readLine()) != null) {
				todoList.add(line);
			}
			System.out.println("タスクリストが読み込まれました。");
		}catch (FileNotFoundException e) {
			System.out.println("todolist.txtファイルが見つかりませんでした。新しいリストを作成しました。");
		}catch (IOException e) {
			System.out.println("タスクの読み込み中にエラーが発せしました。");
		}
	}
}