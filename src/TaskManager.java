import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // タスクを追加
    public void addTask(Scanner scanner) {
        System.out.print("追加するタスクを入力してください: ");
        String taskDescription = scanner.nextLine();
        tasks.add(new Task(taskDescription));
        System.out.println("タスクを追加しました: " + taskDescription);
    }

    // タスクを表示
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("現在、タスクはありません。");
        } else {
            System.out.println("\n===== 現在のタスク =====");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ": " + tasks.get(i).getDescription());
            }
        }
    }

    // タスクを完了
    public boolean completeTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            return false;
        }

        Task completedTask = tasks.remove(taskNumber - 1);
        System.out.println("タスク完了: " + completedTask.getDescription());
        return true;
    }

    // タスクリストが空かどうか
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
