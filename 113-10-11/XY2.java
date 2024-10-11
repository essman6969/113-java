public class XY2 {
    public static void main(String[] args) {
        int[][] cords = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for(int[] row : cords) {   //巡行二維陣列  x為列數
            for(int c : row) {     //巡行二維陣列
                System.out.printf("%2d", c);
            }
            System.out.println();
        }
    }
} 