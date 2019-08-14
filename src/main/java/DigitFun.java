/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeextreme9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gishan-mac
 */
public class DigitFun {

    public static void main(String[] args)throws Exception {
        Scanner s = new Scanner(System.in);
        String input=s.nextLine();
        ArrayList arl = new ArrayList();
        int el=0;
        while(!input.equals("END")){
        arl.add(dig(Long.parseLong(input)));
        el++;
        input=s.nextLine();
        }
        String F = arl.toString().substring(1, arl.toString().length()-1);
        String [] W = F.split(", ");
        for(int i=0 ; i<W.length ; i++) {
           System.out.println(W[i]);
        }
    }
        
    

    static int dig(long digit) {
//        Scanner s = new Scanner(System.in);
//        long digit = s.nextLong();
        int noofdigits = 1, count = 1;
        boolean b = noofdigits == digit;
        while ((!b) && (digit != 1)) {
            count++;
            noofdigits = 1;
            while ((digit / 10) != 0) {
                noofdigits++;
                digit /= 10;
            }
            b = (noofdigits == digit);
            if (!b) {
                digit = noofdigits;
            }
        }
        return count;
    }
}
