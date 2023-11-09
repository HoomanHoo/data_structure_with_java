import java.util.Scanner;

public class Code16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a의 b승을 구하는 계산기 입니다 숫자를 입력해주세요: ");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a <= 0 || b <= 0) {
            System.out.println("숫자는 0보다 커야합니다");
        } else {
            Calc calcurator = new Calc();

            int result = calcurator.calc(a, b);
            System.out.println("result: " + result);
        }
        scanner.close();

    }

}

class Calc {
    public int calc(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}
