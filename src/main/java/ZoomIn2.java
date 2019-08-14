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
public class ZoomIn2 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int cols, rows, k, x;//,max=0;
        String temp1;
        String[] temp2;
        char[] line;
        char[][] letters, zoom;

        cols = s.nextInt();
        rows = s.nextInt();
        k = s.nextInt();
        s.nextLine();

        line = new char[k];
        letters = new char[rows][cols * k];

        for (int i = 0; i < k; i++) {
            line[i] = s.nextLine().charAt(0);
            for (int j = 0; j < cols; j++) {
                temp1 = s.nextLine();
                for (int l = 0; l < rows; l++) {
                    letters[j][l + (cols * i)] = temp1.charAt(l);
                }
            }
        }
        x = s.nextInt();
        s.nextLine();
        temp2 = new String[x];
        for (int i = 0; i < x; i++) {
            temp2[i] = s.nextLine();
            //    max=(max<temp2[i].length())?temp2[i].length():max;
        }

        for (int i = 0; i < temp2.length; i++) {
            zoom = new char[rows][cols * temp2[i].length()];
            for (int j = 0; j < temp2[i].length(); j++) {
                for (int l = 0; l < line.length; l++) {
                    if (line[l] == temp2[i].charAt(j)) {

                        for (int m = 0; m < rows; m++) {
                            for (int n = 0; n < cols; n++) {
                                zoom[m][n + (cols * j)] = letters[m][n+ (cols * l)];
                            }
                        }

                        break;
                    }
                }
            }

            for (int l = 0; l < rows; l++) {
                for (int m = 0; m < cols * temp2[i].length(); m++) {
                    System.out.print(zoom[l][m]);
                }
                System.out.println();
            }

        }

    }
}
