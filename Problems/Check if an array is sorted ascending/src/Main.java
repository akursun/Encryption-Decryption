import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size ; i++) {
            array[i] = Integer.parseInt(scan.next());
        }

        for (int i = 0; i < size - 1  ; i++) {
            if ( array[i] < array[i+1]) {
                count++;
                continue;

            }

        }
        System.out.println((count == size - 1) ? true:false);
    }
}