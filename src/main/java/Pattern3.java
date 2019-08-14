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
public class Pattern3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nooflines = s.nextInt();
        if(nooflines>10||nooflines<1){
            System.exit(0);
        }
        s.nextLine();
        String[] lines = new String[nooflines];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = s.nextLine();
        }
        for (int i = 0; i < lines.length; i++) {
            System.out.println(pat(lines[i]));
        }
    }

    static int pat(String s) {
        int n = 1;
        boolean b = false;
        char line[] = s.toCharArray();
        int patternno = 0;
        while (!b) {
            b = true;
            char init[] = new char[n];
            for (int i = 0; i < init.length; i++) {
                init[i] = line[i];
            }
            f1:
            for (int i = 0; i < init.length; i++) {
                for (int j = i; j < line.length; j += n) {
                    if (init[i] != line[j]) {
                        b = false;
                        n++;
                        break f1;
                    } else {
                        patternno = init.length;
                    }
                }
            }
        }
        return patternno;
    }
}
