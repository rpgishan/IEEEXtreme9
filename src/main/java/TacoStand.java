/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeextreme9;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gishan-mac
 */
public class TacoStand {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testcases = s.nextInt();
        int[][] data = new int[testcases][4];
        for (int i = 0; i < testcases; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = s.nextInt();
            }
        }
        f1:
        for (int i = 0; i < testcases; i++) {
            int totsh = 1,count = 0;
            if (data[i][0] == 0) {
                System.out.println(0);
                continue;
            }
            for (int j = 1; j < 4; j++) {
                if (data[i][j] == 0) {
                    count++;
                    if (count >= 2) {
                        System.out.println(0);
                        continue f1;
                    }
                }
            }
            w1:
            while (true) {
                for (int j = 0; j < 4; j++)
                    data[i][j] -= 1;
                if (data[i][0] == 0) {
                    System.out.println(totsh);
                    continue f1;
                }
                totsh++;
                for (int j = 1; j < 4; j++) {
                    if (data[i][j] == 0) {
                        count++;
                        if (count >= 2) {
                            System.out.println(totsh);
                            continue f1;
                        }
                    }
                }
            }
        }
    }
}
