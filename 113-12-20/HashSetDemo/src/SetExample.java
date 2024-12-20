import java.util.HashSet;
import java.util.Scanner;

public class SetExample {
    public static void main(String[] args) {
        // 使用 HashSet 儲存學生名單
        HashSet<String> students = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        // 初始資料
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        // 主選單
        while (true) {
            System.out.println("\n=== 學生名單管理系統 ===");
            System.out.println("1. 添加學生");
            System.out.println("2. 刪除學生");
            System.out.println("3. 列出所有學生");
            System.out.println("4. 查詢學生");
            System.out.println("5. 退出");
            System.out.print("請選擇操作: ");

            input = scanner.nextLine();

            switch (input) {
                case "1": // 添加學生
                    System.out.print("輸入學生姓名: ");
                    String newStudent = scanner.nextLine();
                    if (students.add(newStudent)) {
                        System.out.println("學生 " + newStudent + " 已成功添加！");
                    } else {
                        System.out.println("學生 " + newStudent + " 已存在！");
                    }
                    break;

                case "2": // 刪除學生
                    System.out.print("輸入要刪除的學生姓名: ");
                    String deleteStudent = scanner.nextLine();
                    if (students.remove(deleteStudent)) {
                        System.out.println("學生 " + deleteStudent + " 已刪除！");
                    } else {
                        System.out.println("學生 " + deleteStudent + " 不存在！");
                    }
                    break;

                case "3": // 列出所有學生
                    System.out.println("當前學生名單: ");
                    if (students.isEmpty()) {
                        System.out.println("名單中沒有任何學生。");
                    } else {
                        for (String student : students) {
                            System.out.println(" - " + student);
                        }
                    }
                    break;

                case "4": // 查詢學生
                    System.out.print("輸入要查詢的學生姓名: ");
                    String searchStudent = scanner.nextLine();
                    if (students.contains(searchStudent)) {
                        System.out.println("學生 " + searchStudent + " 存在於名單中！");
                    } else {
                        System.out.println("學生 " + searchStudent + " 不存在！");
                    }
                    break;

                case "5": // 退出
                    System.out.println("退出系統，感謝使用！");
                    scanner.close();
                    return;

                default:
                    System.out.println("無效選項，請重新輸入！");
            }
        }
    }
}

