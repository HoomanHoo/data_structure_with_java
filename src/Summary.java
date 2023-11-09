import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Summary {

    static String[] names = new String[1000];
    // static int[] numbers = new int[1000];
    static String[] numbers = new String[1000];
    static int n = 0;

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            // Scanner scanner = new Scanner(System.in);

            // int k = scanner.nextInt();
            // for (int i = 0; i < k; i++) {
            // names[i] = scanner.next();
            // numbers[i] = scanner.nextInt();
            // }

            while (scanner.hasNext()) {
                names[n] = scanner.next();
                numbers[n] = scanner.next();
                System.out.println("N: " + n);
                n++;
            }
            scanner.close();
            bubbleSort(n, names, numbers);
            for (int i = 0; i < n; i++) {
                System.out.println("name: " + names[i] + " number: " + numbers[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void bubbleSort(int n, String[] names, String[] numbers) {// call-by-value 방식으로 매개변수 호출만 지원
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (names[j].compareTo(names[j + 1]) > 0) { // 같은 위치의 문자를 비교하여 아스키값을 기준으로 비교 처리를 한다
                    String tmp = names[j]; // 즉 abcd... 순으로 정렬하면 아스키 코드 값이 작은 쪽이 앞으로 와야한다
                    names[j] = names[j + 1]; // 기준 문자열.compareTo(비교할 문자열)은 (기준 문자열의 아스키 값 - 비교할 문자열의 아스키 값)을 리턴한다
                    names[j + 1] = tmp; // "a".compareTo("c") -> -2 리턴
                                        // 즉, compareTo()의 값이 0 이상이면 기준 문자열의 첫 알파벳의 순서가 비교할 문자열의 첫 알파벳보다 뒤라는 의미이다
                                        // 기준 문자열에 비교할 문자열이 '포함'되어 있으면 문자열 길이의 차이값을 리턴한다
                    tmp = numbers[j]; // compoareTo() 대신 compareToIgnoreCase() 메서드로 대소문자 무시하고 비교하기도 가능하다
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
    }
}
