import java.io.File;
import java.util.Scanner;

public class Code21 {

    static int[] offsetX = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] offsetY = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        /*
         * 입력으로 n*n개의 음이 아닌 한자리 정수가 2차원 배열로 주어진다.
         * 이 정수들 중 가로 세로 대각선의 8방향으로 연속된 숫자들을 합쳐서
         * 만들 수 있는 모든 소수를 찾아서 나열하는 프로그램을 작성하라
         * 중복된 수를 출력해도 된다
         */

        try {
            Scanner inFile = new Scanner(new File("data.txt"));
            n = inFile.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = inFile.nextInt();
                }
            }
            inFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // 두번째 for문까지는 시작점을 정한다
                for (int dir = 0; dir < 8; dir++) {
                    // 세번째 for문에서는 수열의 방향을 정한다
                    for (int length = 1; length <= n; length++) {
                        // 네번째 for문에서는 수열의 길이를 정한다
                        int value = computeValue(x, y, dir, length);
                        if (value != -1 && isPrime(value)) { // value가 -1인 것은 유효한 수열이 없는 것을 의미한다
                            System.out.println("value " + value + "는 소수이다");
                        }
                    }
                }
            }
        }

    }

    public static int computeValue(int x, int y, int dir, int length) {
        int value = 0;
        for (int i = 0; i < length; i++) {
            int digit = getDigit(x, y, dir, i); // 존재하지 않은 자리라면 -1을 반환한다
                                                // 시작 위치 (x,y)에서 dir 방향으로 i 칸 떨어진 자리에 있는 digit을 반환
            if (digit == -1) {
                return -1;

            }
            value = value * 10 + digit;
        }

        return value;
    }

    public static int getDigit(int x, int y, int dir, int i) {
        // int newX = x, newY = y;
        // // x = x좌표 , y = y좌표, dir = 방향, i = 움직인 칸 수
        // // switch(dir){
        // // case 0: newY -= i; break;
        // // case 1: newX += i; newY -= i; break;
        // // case 2: newX += i; break;
        // // case 3: newX += i; newY += i; break;
        // // case 4: newY += i; break;
        // // case 5: newX -= i; newY += i; break;
        // // case 6: newX -= i; break;
        // // case 7: newX -= i; newY -= i; break;
        // // }

        // if(newX < 0 || newX >= n || newY < 0 || newY >= n){
        // return -1;
        // }
        // return grid[newX][newY];

        int newX = x + i * offsetX[dir];
        int newY = y + i * offsetY[dir];

        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length) {
            return -1;
        } else {
            return grid[newX][newY];
        }

    }

    static boolean isPrime(int n) { // 소수 계산기

        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }

            }
            return true;
        }
    }

}

/*
 * structured programming 구조화된 프로그래밍
 * 프로그램을 함수/메서드로 잘게 쪼개어서 각 함수/메서드는 충분히 짧게,
 * 간단명료하게 설명할 수 있을 정도로 쪼개는 것이 이념
 * 
 * 무식하지만 논리적으로 가장 명료한 방법을 먼저 찾아라
 * 그리고 개선할 점을 생각하자(계산의 중복을 제거할 방법 등)
 * 
 * 
 */
