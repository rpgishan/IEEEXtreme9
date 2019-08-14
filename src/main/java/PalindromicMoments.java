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
public class PalindromicMoments {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input=s.next();
//        int[] ar=new int [input.length()+10];
        int year=Integer.parseInt(input),month=1,day=1,hour=0,minute=0,second=0;
        System.out.println(palindrome(s.next()));
    }
    static boolean palindrome(String x){
        char car[]=x.toCharArray();
        boolean b = true;
        for (int i = 0,j=car.length-1; i < car.length&&j>=0; i++,j--) {
            if (car[i]!=car[j]){
                b=false;
                break;
            }
        }
         return b;
    }
}
