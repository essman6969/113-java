

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] scores1 = {88, 81, 74, 68, 78, 76, 77, 85, 95, 93};
        int[] scores2 = Arrays.copyOf(scores1, scores1.length);
        int[] scores3 = scores1;
        int[] scores4 = scores1.clone();

        for(var score : scores2) {
            System.out.printf("%3d", score);
        }
        System.out.println();

        scores2[0] = 99;
        // 不影響score1參考的陣列物件
        for(var score : scores1) {
            System.out.printf("%3d", score);
        }
        
        System.out.println();

        scores3[0] = 199;
        // 不影響score1參考的陣列物件
        for(var score : scores1) {
            System.out.printf("%3d", score);
        }
        
        System.out.println();

        scores4[0] = 299;
        // 不影響score1參考的陣列物件
        for(var score : scores1) {
            System.out.printf("%3d", score);
        }
    }
}
