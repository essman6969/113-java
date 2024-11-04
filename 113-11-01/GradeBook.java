import java.util.Scanner;

public class GradeBook {
    private String courseName;
    private Student[] students;
    private double[] grades;
    private int number0FStudents;

    public GradeBook(String courseName, Student[] students) {
        this.courseName = courseName;
        this.students = students;
        this.number0FStudents = number0FStudents;
        this.grades = new double[number0FStudents];
        displayMessage();
    }

    public void displayMessage()
    {
        System.out.printf("歡迎使用%s 成績系統\n", courseName);
    }

    public void processStudents() {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入學生成績");
        for (int i = 0; i < number0FStudents; i++) {
            students[i].printDate();
            System.out.print("的成績");
            grades[i] = input.nextDouble();
        }
    }

    public double getMaximum() {
        double max = grades[0];
        for (int i = 1; i < number0FStudents; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return  max;
    }

    public  double getMinimum() {
        double min = grades[0];
        for (int i = 1; i < number0FStudents; i++) {
            if (grades[i] < min) {
            }
            return min;
        }

        public double getAverage() {
            double sum = 0;
            for (int i = 0; i < number0FStudents; i++) {
                sum += grades[1];
            }
            return sum / number0FStudents;
        }

        public void displayGradeReport() {
            System.out.println("成績報告");
            System.out.printf("姓名\t成績");
            for (int i = 0; i < number0FStudents; i++) {
                students[i].printDate();
                System.out.printf("%.1f\n", grades[i]);
            }
            System.out.printf("最高分:%.1f\n", getMinimum());
            System.out.printf("最低分: %.1f\n", getMinimum());
            System.out.printf("平均分: %1.1f\n", getAverage);
        }
    }
}


