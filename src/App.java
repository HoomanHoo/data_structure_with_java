import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int number = 123;
        Scanner scanner = new Scanner(System.in);
        // Scanner 는 System.in을 매개변수로 받는다
        // System.in은 표준 입력을 의미한다 (키보드)
        //

        System.out.println("정수를 입력해주세요: ");

        int input = scanner.nextInt();

        if (input == number) {
            System.out.println("숫자가 일치합니다");
        } else {
            System.out.println("숫자가 맞지 않습니다");
        }

        scanner.close(); // Scanner의 사용이 끝나면 close() 메서드를 호출해줘야한다
    }
}
