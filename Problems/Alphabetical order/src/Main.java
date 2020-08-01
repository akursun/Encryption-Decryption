import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        int count = 0;
        for (int i = 0; i < str.length - 1; i++) {
                if (str[i].compareTo(str[i + 1]) <= 0) {
                    count++;
            }
        }
        if (count == str.length - 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}