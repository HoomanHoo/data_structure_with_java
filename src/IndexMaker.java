import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexMaker {
    /*
     * 입력으로 하나의 텍스트 파일(smaple.txt)를 읽는다
     * 텍스트 파일에 등장하는 모든 단어들의 목록을 만들고
     * 각 단어가 텍스트 파일에 등장하는 횟수를 센다
     * 사용자가 요청하면 단어 목록을 하나의 파일로 저장한다
     * 사용자가 단어를 검색하면 그 단어가 텍스트 파일에 몇번 등장하는지 출력한다
     */

    static String[] words = new String[100000];
    static int[] count = new int[100000];
    static int n = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String command = sc.next();
            if (command.equals("read")) {
                String fileName = sc.next();
                makeIndex(fileName);

            } else if (command.equals("find")) {
                String word = sc.next();
                int index = findWord(word);
                if (index > -1) {
                    System.out.println("The word : " + words[index] + " appears " + count[index] + " times ");
                } else {
                    System.out.println("The word " + word + " does not appear");
                }

            } else if (command.equals("saveas")) {
                String fileName = sc.next();
                saveAs(fileName);

            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("명령어를 다시 입력해주세요");
            }
        }

        sc.close();
        // for (int i = 0; i < n; i++) {
        // System.out.println(words[i] + " " + count[i]);
        // }
        System.out.println("main end");
    }

    static void makeIndex(String fileName) {
        System.out.println(fileName);
        try {
            Scanner inFile = new Scanner(new BufferedReader(new FileReader(fileName)));
            // int cnt = 0;
            // System.out.println(inFile.hasNext());
            while (inFile.hasNext()) {
                String word = inFile.next();

                String trimmed = trimming(word);

                addWord(word);
                // System.out.println(cnt);
                // cnt++;
            }
            // System.out.println(cnt);
            System.out.println("makeIndex end");
            inFile.close();
        } catch (Exception e) {

            e.printStackTrace();
            return;
        }
    }

    static String trimming(String word) {

        if (word == null || word.length() <= 0) {

        }

        return null;
    }

    static void addWord(String word) {
        int arrayIndex = findWord(word); // 배열에서 단어를 찾으면 인덱스, 못 찾으면 -1을 리턴한다

        if (arrayIndex != -1) {
            count[arrayIndex]++;
        } else {
            words[n] = word;
            count[n] = 1;
            n++;
        }
        System.out.println("addWord end");
    }

    static int findWord(String word) {
        for (int i = 0; i < n; i++) {
            if (words[i].equalsIgnoreCase(word)) {
                System.out.println("findWord find word end");
                return i;
            }
        }
        System.out.println("findWord No word end");
        return -1; // return 없이 for문을 빠져나왔다는 것은 찾는 단어가 배열에 없다는 의미이다
    }

    static void saveAs(String fileName) {
        try {
            PrintWriter fileOut = new PrintWriter(new FileWriter(fileName)); // fileName으로 파일을 만들어 저장함

            for (int i = 0; i < n; i++) {
                fileOut.println(words[i] + " " + count[i]); // 생성한 파일에 데이터를 쓰는 메서드는 println으로 동일함
            }

            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/*
 * 어떠한 프로그램을 만들 때 가장 먼저 생각할 것은 자료구조
 * 데이터를 저장하고 처리할 때 중요하기 때문이다
 */