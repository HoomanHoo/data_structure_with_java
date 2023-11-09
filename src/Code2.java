import java.util.Objects;
import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        String str = "Hello, world";
        String input = null;

        System.out.print("문자열을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        // input = scanner.next();
        // input: Hello, -> Scanner.next() 는 사용자가 입력한 첫번째 단어만 받아들인다

        input = scanner.nextLine();

        if (str.equals(input)) {
            // str == input 는 메모리 주소값을 비교한다
            // == 는 프리미티브 타입(기본 타입)의 값 비교에만 사용할 수 있다
            // 객체간의 비교는 equals() 메서드를 사용한다
            System.out.println("문자열이 일치합니다");
        } else {
            System.out.println("input: " + input);
            System.out.println("문자열이 일치하지 않습니다");
        }

        scanner.close();
    }
}
