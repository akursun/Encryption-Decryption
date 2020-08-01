package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mode = "";
        String data = "";
        String input = "";
        String output = "";
        String alg = "";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;

                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;

                case "-data":
                    data = args[i + 1];
                    break;

                case "-in":
                    input = args[i + 1];
                    break;

                case "-out":
                    output = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }
        if (!data.equals("") && !input.equals("") && output.equals("")) {
            switch (alg) {
                case "shift":
                    System.out.println(shiftAlgorithm(input, key, mode));
                    break;
                case "unicode":
                    System.out.println(unicodeAlgorithm(input, key, mode));
                    break;
            }

        } else if (!data.equals("") && !input.equals("") && !output.equals("")) {
            File file = new File(output);
            try (FileWriter writer = new FileWriter(file)) {
                switch (alg) {
                    case "shift":
                        writer.write(shiftAlgorithm(input, key, mode));
                        break;
                    case "unicode":
                        writer.write(unicodeAlgorithm(input, key, mode));
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        String datam;
        if (!input.equals("") && output.equals("")) {

            try (Scanner scan = new Scanner(new File(input))) {
                input = scan.nextLine();
                switch (alg) {
                    case "shift":
                        System.out.println(shiftAlgorithm(input, key, mode));
                        break;
                    case "unicode":
                        System.out.println(unicodeAlgorithm(input, key, mode));
                        break;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //Data from a file, output on the file
        } else if (!input.equals("") && !output.equals("")) {
            try (Scanner scan = new Scanner(new File(input)); FileWriter writer = new FileWriter(output)) {
                datam = scan.nextLine();
                switch (alg) {
                    case "shift":
                        writer.write(shiftAlgorithm(datam, key, mode));
                        break;
                    case "unicode":
                        writer.write(unicodeAlgorithm(datam, key, mode));
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    public static String unicodeAlgorithm(String data, int shift, String mode) {
        String newText = "";
        char[] msgArr = data.toCharArray();
        switch (mode) {
            case "enc":
                for (int i = 0; i < data.length(); i++) {
                    newText += (char) (msgArr[i] + shift);
                }
                break;

            case "dec":
                for (int i = 0; i < data.length(); i++) {
                    newText += (char) (msgArr[i] - shift);
                }
                break;
        }
        return newText;
    }


    public static String shiftAlgorithm(String data, int shift, String mode) {
        String newText = "";
        char[] dataToChar = data.toCharArray();
        shift = shift % 26 < 0 ? (shift + 26) : shift;
        switch (mode) {
            case "enc":
                for (int i = 0; i < dataToChar.length; i++) {
                    if (Character.isLetter(dataToChar[i])) {
                        if (Character.isUpperCase(dataToChar[i])) {
                            dataToChar[i] = Character.isUpperCase((char) (dataToChar[i] + shift))
                                    ? (char) (dataToChar[i] + shift)
                                    : (char) (dataToChar[i] + shift - 26);
                        }
                        if (Character.isLowerCase(dataToChar[i])) {
                            dataToChar[i] = Character.isLowerCase((char) (dataToChar[i] + shift))
                                    ? (char) (dataToChar[i] + shift)
                                    : (char) (dataToChar[i] + shift - 26);
                        }

                    }

                    newText += dataToChar[i];
                }
                break;
            case "dec":
                for (int i = 0; i < dataToChar.length; i++) {
                    if (Character.isLetter(dataToChar[i])) {
                        if (Character.isUpperCase(dataToChar[i])) {
                            dataToChar[i] = Character.isUpperCase((char) (dataToChar[i] - shift))
                                    ? (char) (dataToChar[i] - shift)
                                    : (char) (dataToChar[i] - shift + 26);
                        }
                        if (Character.isLowerCase(dataToChar[i])) {
                            dataToChar[i] = Character.isLowerCase((char) (dataToChar[i] - shift))
                                    ? (char) (dataToChar[i] - shift)
                                    : (char) (dataToChar[i] - shift + 26);
                        }
                    }
                    newText += dataToChar[i];
                }

                break;
        }
        return newText;
    }

}
