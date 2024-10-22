import java.util.Scanner;

public class TodoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character player = new Character("勇者", 1, 100);  // キャラクターを作成
        TaskManager taskManager = new TaskManager();  // タスクマネージャーを作成
        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        player.showStatus();  // キャラクターステータスを表示
                    } catch (Exception e) {
                        System.out.println("エラー: ステータスを表示できませんでした。");
                    }
                    break;
                case "2":
                    try {
                        taskManager.addTask(scanner);  // タスクを追加
                    } catch (Exception e) {
                        System.out.println("エラー: タスクを追加できませんでした。");
                    }
                    break;
                case "3":
                    try {
                        player.completeTask(taskManager, scanner);  // タスク完了と経験値獲得
                    } catch (NumberFormatException e) {
                        System.out.println("無効なタスク番号です。数値を入力してください。");
                    } catch (Exception e) {
                        System.out.println("エラー: タスクの完了中に問題が発生しました。");
                    }
                    break;
                case "4":
                    try {
                        taskManager.showTasks();  // タスクを表示
                    } catch (Exception e) {
                        System.out.println("エラー: タスクを表示できませんでした。");
                    }
                    break;
                case "5":
                    System.out.println("ゲームを終了します。");
                    running = false;
                    break;
                default:
                    System.out.println("無効な選択です。もう一度選んでください。");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n===== To-DoリストRPG メニュー =====");
        System.out.println("1. キャラクターのステータスを表示");
        System.out.println("2. タスクを追加");
        System.out.println("3. タスクを完了");
        System.out.println("4. タスクを表示");
        System.out.println("5. ゲームを終了");
        System.out.print("選択肢を入力してください: ");
    }
}

