import java.util.Scanner;

public class Code4 {
    public static void main(String[] args) {
        String name = null;
        int age;
        String gender;

        Scanner scanner = new Scanner(System.in);
        System.out.println("이름과 나이, 성별을 입력해주세요");

        name = scanner.next();
        age = scanner.nextInt();
        gender = scanner.next();

        if (gender.equals("male")) {
            System.out.println("name: " + name + " age: " + age + " gender: male");
        } else {
            System.out.println("name: " + name + " age: " + age + " gender: female");
        }
        scanner.close();
        ;
    }
}
