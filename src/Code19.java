import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code19 {
    public static void main(String[] args) {

        Scanner scanner;
        String[] name = new String[1000]; // name, number 모두 몇명일지 모르는 상황이기 때문에 넉넉히 크기를 잡음
        String[] number = new String[1000];
        int count = 0;

        try {
            scanner = new Scanner(new File("input.txt")); // File 객체는 매개변수로 파일 경로와 이름을 받아 해당 파일을 읽는다
            // System.in은 표준 입출력(키보드 입력)을 의미
            // File은 파일을 읽어온다는 의미
            // FileNotFound Exception 발생할 수 있음 - 이를 핸들링 해줘야 한다

            while (scanner.hasNext()) { // Scanner.hasNext() -> 다음 토큰이 존재하는지 확인하는 메서드
                name[count] = scanner.next();
                number[count] = scanner.next();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1); // 프로그램을 종료하는 코드
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + name[i] + " Phone: " + number[i]);
        }
    }
}
