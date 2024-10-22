import java.util.Scanner;

public class Character {
    private String name;
    private int level;
    private int experience;
    private int experienceToLevelUp;
    private int hp;

    public Character(String name, int level, int hp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.experience = 0;
        this.experienceToLevelUp = 100;  // レベルアップに必要な経験値
    }

    // キャラクターのステータスを表示
    public void showStatus() {
        System.out.println("\n===== キャラクター ステータス =====");
        System.out.println("名前: " + name);
        System.out.println("レベル: " + level);
        System.out.println("HP: " + hp);
        System.out.println("経験値: " + experience + "/" + experienceToLevelUp);
    }

    // 経験値を得てレベルアップを判定
    public void gainExperience(int gainedExperience) {
        experience += gainedExperience;
        System.out.println(gainedExperience + " 経験値を獲得しました。");

        if (experience >= experienceToLevelUp) {
            levelUp();
        }
    }

    // レベルアップ
    private void levelUp() {
        level++;
        experience -= experienceToLevelUp;  // 次のレベルに必要な経験値
        experienceToLevelUp += 100;  // レベルアップするごとに必要な経験値が増加
        hp += 20;  // レベルアップごとにHPが増加
        System.out.println("レベルアップしました！現在のレベルは " + level + " です。");
    }

    // タスク完了して経験値を得る
    public void completeTask(TaskManager taskManager, Scanner scanner) {
        if (taskManager.isEmpty()) {
            System.out.println("完了するタスクがありません。");
            return;
        }

        taskManager.showTasks();
        System.out.print("完了するタスク番号を選んでください: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (taskManager.completeTask(taskNumber)) {
            gainExperience(50);  // タスク完了ごとに50経験値を得る
        } else {
            System.out.println("無効なタスク番号です。");
        }
    }
}
