/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeextreme9;

import java.util.Scanner;

/**
 *
 * @author Gishan-mac
 */
public class ZoomIn {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int columns = s.nextInt(), rows = s.nextInt(), noofchars = s.nextInt();
        char[][] charset1 = new char[rows][columns * noofchars];
//        char[][] charset2 = new char[rows][columns * noofchars];
        char[] chars = new char[noofchars];
        if ((rows <= 100) && (rows >= 1) && (columns <= 100) && (columns >= 1) && (noofchars <= 95) && (noofchars >= 1)) {
            for (int i = 0; i < noofchars; i++) {
                String s1 = s.next();
                chars[i] = s1.charAt(0);
                s.nextLine();
                for (int j = 0; j < rows; j++) {
                    String line = s.nextLine();
                    for (int k = 0; k < columns; k++) {
                        charset1[j][k + (i * columns)] = line.charAt(k);
                    }
                }
            }
            int integer = s.nextInt();
            s.nextLine();
//            System.out.println("int "+integer);
            String[] word = new String[integer];
            for (int i = 0; i < integer; i++) {
                word[i] = s.nextLine();
//                System.out.println(word[i]+" , ");
            }

            // int no = Integer.parseInt(integer);
            for (int o = 0; o < word.length; o++) {
                char[][] wordchar = new char[rows][word[o].length()];
                for (int i = 0; i < word.length; i++) {
//                    wordchartemp = new char[word[o].length()];
                    char[] wordchartemp = word[o].toCharArray();
                    for (int j = 0; j < wordchartemp.length; j++) {
                        wordchar[i][j] = wordchartemp[j];
                    }
                }
                char[][] charset2 = new char[rows][columns * word[o].length()];
                f1:
                for (int i = 0; i < integer; i++) {
                boolean b = true;
                    for (int l = 0; l < word[i].length(); l++) {
                        if (!((wordchar[i][l] >= 32) && (wordchar[i][l] <= 126))) {
                            b = false;
                            break f1;
                        }
                        if (wordchar[i][l] == chars[l]) {
                            for (int j = 0; j < rows; j++) {
                                for (int k = 0; k < columns; k++) {
                                    charset2[j][k + (l * columns)] = charset1[j][k + (l * columns)];
                                }
                            }
                        } else {
                            for (int m = 0; m < chars.length; m++) {
                                if (wordchar[i][l] == chars[m]) {
                                    for (int j = 0; j < rows; j++) {
                                        for (int k = 0; k < columns; k++) {
                                            charset2[j][k + (l * columns)] = charset1[j][k + (m * columns)];
                                        }
                                    }
                                }
                            }
                        }
                    if (integer >= 1 && integer <= 500 && b) {
                        for (int m = 0; m < rows; m++) {
                            for (int j = 0; j < columns * word.length; j++) {
                                System.out.print(charset2[m][j]);
                            }
                            System.out.println();
                        }
                    }
                    }
                }
            }
        }
    }
}
