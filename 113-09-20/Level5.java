

public class Level5 {
    public static void main(String[] args) {
        final String warning = "�]���I���ή�F�I�^";
        
        var score = 59;
        var quotient = score / 10;
        var level = switch(quotient) {
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C"; 
            case 6     -> "D"; 
            default    -> {
                String message = "E" + warning;
                yield message ;
            }
        };
        System.out.printf("�o�����šG%s%n", level);
    }
}