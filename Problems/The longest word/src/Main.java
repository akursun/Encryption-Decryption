import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        String longest = str[0];
        for(int i = 0; i < str.length ; i++){
           if(longest.length() < str[i].length()){
               longest = str[i];
           }
        }
        System.out.println(longest);
    }
}