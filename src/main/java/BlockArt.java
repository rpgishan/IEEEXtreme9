package ieeextreme9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gishan-mac
 */
public class BlockArt {

    public static void main(String[] args) throws IOException {
        int r, co, n, count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        co = Integer.parseInt(line[1]);
        n = Integer.parseInt(br.readLine());
        int[][] array1 = new int[r][co];
        String[][] array2 = new String[n][5];
        if (r >= 1 && r <= 12 && co >= 1 && n >= 1 && co <= Math.pow(10, 6) && n <= Math.pow(10, 4)) {
            for (int k = 0; k < n; k++) {
                String array3[] = br.readLine().split(" ");
                for (int i = 0; i < array3.length; i++) {
                    array2[k][i] = array3[i];
                }
            }
            for (int i = 0; i < n; i++) {
                count = 0;
                if (array2[i][0].equalsIgnoreCase("a")) {
                    for (int q = (Integer.parseInt(array2[i][1]) - 1); q < Integer.parseInt(array2[i][3]); q++) {
                        for (int j = (Integer.parseInt(array2[i][2]) - 1); j < Integer.parseInt(array2[i][4]); j++) {
                            array1[q][j] += 1;
                        }

                    }
                } else if (array2[i][0].equalsIgnoreCase("q")) {
                    for (int q = (Integer.parseInt(array2[i][1]) - 1); q < Integer.parseInt(array2[i][3]); q++) {
                        for (int j = (Integer.parseInt(array2[i][2]) - 1); j < Integer.parseInt(array2[i][4]); j++) {
                            if (array1[q][j] != 0) {
                                count += array1[q][j];
                            }
                        }
                    }
                    System.out.println(count);
                } else if (array2[i][0].equalsIgnoreCase("r")) {
                    for (int q = (Integer.parseInt(array2[i][1]) - 1); q < Integer.parseInt(array2[i][3]); q++) {
                        for (int j = (Integer.parseInt(array2[i][2]) - 1); j < Integer.parseInt(array2[i][4]); j++) {
                            array1[q][j] = (array1[q][j] != 0) ? array1[q][j] - 1 : array1[q][j];
                        }
                    }
                } else {
                    continue;
                }

            }
        }
    }
}
