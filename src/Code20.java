import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
    static String[] name; // 클래스 전역에서 쓰는 경우 메서드 바깥에서 선언한다(클래스 멤버 변수)
    static String[] number;
    static int count;

    public static void main(String[] args) {
        name = new String[1000];
        number = new String[1000];

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                name[count] = scanner.next();
                number[count] = scanner.next();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bubbleSort(count, name, number);

        for (int i = 0; i < count; i++) {
            System.out.println(name[i] + ": " + number[i]);
        }
    }

    static void bubbleSort(int count, String[] name, String[] number) {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                {
                    if (name[j].compareTo(name[j + 1]) > 0) { // 같은 위치의 문자를 비교하여 아스키값을 기준으로 비교 처리를 한다
                        String tmp = name[j]; // 즉 abcd... 순으로 정렬하면 아스키 코드 값이 작은 쪽이 앞으로 와야한다
                        name[j] = name[j + 1]; // 기준 문자열.compareTo(비교할 문자열)은 (기준 문자열의 아스키 값 - 비교할 문자열의 아스키 값)을 리턴한다
                        name[j + 1] = tmp; // "a".compareTo("c") -> -2 리턴
                                           // 즉, compareTo()의 값이 0 이상이면 기준 문자열의 첫 알파벳의 순서가 비교할 문자열의 첫 알파벳보다 뒤라는 의미이다
                                           // 기준 문자열에 비교할 문자열이 '포함'되어 있으면 문자열 길이의 차이값을 리턴한다
                        tmp = number[j]; // compoareTo() 대신 compareToIgnoreCase() 메서드로 대소문자 무시하고 비교하기도 가능하다
                        number[j] = number[j + 1];
                        number[j + 1] = tmp;
                    }
                }
            }
        }
    }
}
