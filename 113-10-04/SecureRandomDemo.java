import  java.security.SecureRandom;

public class SecureRandomDemo {
    public static void main(String[] args) {
        SecureRandom randomNumber = new SecureRandom();
        while(true) {
            var number = randomNumber.nextInt(10);
            System.out.println(number);
            
            if(number == 5) {
                System.out.println("I hit 5....Orz");
                break;
            }
        }
    }
}