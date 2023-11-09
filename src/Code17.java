public class Code17 {
    public static void main(String[] args) {
        for (int n = 0; n <= 100; n++) {
            if (isPrime(n)) {
                System.out.println(n + " 은 소수입니다");
            }
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
