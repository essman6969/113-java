

public class Odd {
    public static void main(String[] args) {
        var input = 10;
        var remain = input % 2; 
        
        if(remain == 1) {
            System.out.printf("%d �O�_��%n", input); 
        } 
        else {
            System.out.printf("%d �O����%n", input); 
        }
    }
}