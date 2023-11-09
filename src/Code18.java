import java.util.Scanner;

public class Code18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] data = new int[num];

        for (int i = 0; i < num; i++) {
            data[i] = scanner.nextInt();

        }

        scanner.close();

        bubbleSort(data); // 호출문 안의 매개변수룰 actual parameter, 메서드 안의 매개변수는 formal parameter

        System.out.println("Sorted Data:");
        for (int i = 0; i < num; i++) {
            System.out.println(data[i]);
        }

    }

    static void bubbleSort(int[] data) { // 버블 정렬 - 시간복잡도 O(n^2)
        for (int i = data.length - 1; i > 0; i--) { // 데이터의 맨 끝 인덱스부터 시작

            for (int j = 0; j < i; j++) { // 데이터의 첫번째 인덱스부터 시작 - i 값과 만날 때 까지 실행

                if (data[j] > data[j + 1]) {
                    System.out.println("data[j]: " + data[j] + " data[j+1]: " + data[j + 1]);
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                } // j번째 값과 j+1번째 값을 비교하여 j번째 값이 크면 두 값의 자리를 바꾼다
            }
        }
        // return data;
    }
}

// 두번째 for문 안의 변수 값을 swap 하는 로직은 별개의 메서드로 분리할 경우 return 타입 void일 경우 정렬 연산이 적용되지
// 않는다
// 그 이유는 배열 인덱스 내부 값은 별개의 메서드의 매개변수로 사용될 때 그 값이 다른 메모리 공간으로 복사되어 연산이 수행될 뿐으로
// 실제 배열 내부에서 연산이 진행되는 것이 아니다. -> 값에 의한 호출
// 배열의 경우 호출된 메서드에서 변경하면 호출한 쪽의 값도 변경이 된다 ->
// 프리미티브(기본)타입은 값에 의한 호출이 가능 / 배열과 같은 참조 타입 변수들은 참조된 메모리 주소가 복사되기 때문에 연산이 진행됨

// 참조에 의한 호출 - > C/Java에서는 없는 개념 - C++에 존재함 -> 하나의 메모리 공간을 참조하는 매개변수 a로 메서드/함수를
// 호출하는것
