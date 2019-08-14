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
public class SumItUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n,q,x,f=0;
        n = s.nextInt();
        int [] ar=new int[n];
        int [] ar1=new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i]=s.nextInt();
        }
        q=s.nextInt();
        for (int i = 0; i < q; i++) {
            x=s.nextInt();
            for (int j = 0; j < ar.length; j++) {
            int t=(j-x)<0?ar.length-x:j-x;
            ar1[j]=ar[j]+ar[t];
            }
          //  for (int j = 0; j < ar1.length; j++) {
                ar=ar1;
        //    }
        }
        
        
        for (int i = 0; i < ar.length; i++) {
            f+=ar[i];
        }
      //  f=f%((10^9)+7);
        f%=1000000007;
        System.out.println(f);
    }
}
