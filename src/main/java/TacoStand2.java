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
public class TacoStand2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), x, y = 0, z, tacos = 0;
        long l;
        int[][] ing = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                ing[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int temp = 0;
            x = min(ing[i][1], ing[i][2]);
            x = min(x, ing[i][3]);

            z = max(ing[i][1], ing[i][2]);
            z = max(z, ing[i][3]);

            for (int j = 1; j < 4; j++) {
                if (x < ing[i][j] && z > ing[i][j]) {
                    y = ing[i][j];
                    break;
                } else if (x == ing[i][j]) {
                    temp++;
                    y = (temp == 2) ? x : z;
                }
            }

            if (z > x + y) {
                tacos = min(ing[i][0], (x + y));
            } else {
                int xx = x;
                for (int j = 0; j <= xx && z > y && j <= ing[i][0]; j++) {
                    z--;
                    x--;
                    tacos++;
                }
                if (x == 2) {
                    x -= 2;
                    y--;
                    z--;
                    tacos += 2;
                }else if(x<2){
                    tacos+=y;
                }
            }
            tacos = min(ing[i][0], tacos);
            System.out.println(tacos);
        }

    }
    
    static int min(int a,int b){
        return (a<b)?a:b;
    }
    
    static int min(long a,long b){
        long temp= (a<b)?a:b;
        return (int)temp;
    }
    
    static int max(int a,int b){
        return (a>b)?a:b;
    }

}
