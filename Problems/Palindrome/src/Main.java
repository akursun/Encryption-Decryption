import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] str = scan.next().toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if ( str[i] == str[str.length - 1 - i])
                count++;
        }
        System.out.println(count == str.length ? "yes":"no");
    }
}