import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCompanies = scan.nextInt();
        int[] incomes = new int[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies ; i++) {
            incomes[i] = scan.nextInt();
        }
        int[] taxes = new int[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies ; i++) {
            taxes[i] = scan.nextInt();
        }
        double largest = 0.0;
        int counter = 0;
double[] taxAmaount = new double[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies; i++) {
            taxAmaount[i] = incomes[i] * taxes[i] / 100.0;
            if (taxAmaount[i] > largest) {
                largest = taxAmaount[i];
                counter  = i + 1;
            }
        }
        System.out.println(counter);
    }
}