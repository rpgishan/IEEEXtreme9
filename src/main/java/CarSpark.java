/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeextreme9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Gishan-mac
 */
public class CarSpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        int[] noofbookings = new int[testcases];
        for (int i = 0; i < testcases; i++) {
            noofbookings[i] = Integer.parseInt(br.readLine());
            int booking[][] = new int[noofbookings[i]][3];
            int reserve[][]=new int[noofbookings[i]][2];
            int tot[]=new int[noofbookings[i]];
            StringTokenizer strtkn = new StringTokenizer(" ");
            for (int j = 0; j < noofbookings[i]; j++) {
                if (!strtkn.hasMoreTokens()) {
                    strtkn = new StringTokenizer(br.readLine());
                }
                for (int k = 0; k < 3; k++) {
                    booking[j][k] = Integer.parseInt(strtkn.nextToken());
                }
                
            }
            
             for (int j = 0; j < noofbookings[i]; j++) {
                for (int k = 0; k < noofbookings[i]&&(j!=k); k++) {
                    if((booking[j][0]>=booking[k][0])||(booking[j][1]<=booking[k][1])){
                        tot[i]=booking[j][2]+booking[k][2];
                    }
//                    for (int l = 0; l <noofbookings[i]&&(l!=j); l++) {
//                        for (int m = 0; m < 2; m++) {
//                            if(booking[j][k])
//                        }
//                    }
                }
            }
            
            
//            for (int j = 0; j < noofbookings[i]; j++) {
//                for (int k = 0; k < 3; k++) {
//                    System.out.print(booking[j][k]+" ");
//                }
//                System.out.println();
//            }
        }
    }
}
