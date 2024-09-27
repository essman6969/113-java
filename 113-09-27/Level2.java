import  java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        char level = '\0';
        
        
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入分數:");
        int score =input.nextInt();
        
        
        switch(score/10) { 
            case 10: 
            case 9: 
                level = 'A';
                break; 
            case 8: 
                level = 'B';
                break; 
            case 7: 
                level = 'C';
                break; 
            case 6: 
                level = 'D';
                break; 
            default: 
                level = 'E';
        }
        System.out.printf("得分等級:%c%n", level);
    }
}
