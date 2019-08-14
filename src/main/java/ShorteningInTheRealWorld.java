/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ieeextreme9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Gishan-mac
 */
public class ShorteningInTheRealWorld {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine(), base1 = base;
        int n = Integer.parseInt(br.readLine());
        String[] urls = new String[n];
        boolean b = true;
        if (n >= 1 && n <= 1000) {
            for (int i = 0; i < urls.length; i++) {
                urls[i] = br.readLine();
                
            }
            for (int l = 0; l < urls.length; l++) {
                if(urls[l].length()<8){
                    continue;
                }
                if (urls[l].length() < base.length()) {
                    base = base.substring(0, urls[l].length());
                } else {
                    base = baseurl(base1, urls[l], 1);
                }
                String hexbase = DatatypeConverter.printHexBinary(base.getBytes("UTF-8"));
                String hexss = DatatypeConverter.printHexBinary(urls[l].getBytes("UTF-8"));
                String[] shar = new String[hexbase.length() / 2];
                String[] shar2 = new String[hexss.length() / 2];
                String[] shar3 = new String[shar.length];
                int elno = 0, elno2 = 0;
                for (int i = 0; i < shar.length; i++) {
                    shar[i] = hexbase.substring(elno, elno + 2);
                    elno += 2;
                }
                for (int i = 0; i < shar2.length; i++) {
                    shar2[i] = hexss.substring(elno2, elno2 + 2);
                    elno2 += 2;
                }
                for (int i = 0; i < shar3.length; i++) {
                    shar3[i] = xorHex(shar[i], shar2[i]);
                }

                String srturl = "";
                for (int i = 0; i < 8; i++) {
                    srturl += shar3[i + (shar3.length - 8)];
                }
                long value = Long.parseLong(srturl, 16);
                System.out.println(base1 + "/" + base62(value));

            }
        }
    }

    static String baseurl(String base, String url, int n) {
        if ((n * base.length() - url.length()) < 0) {
            String part;
////            if(n==1){
////                return baseurl(base, url, n+1);
////            }else
            part = baseurl(base, url, n + 1);

            return base + part;
        } else {
            String part;
            while (n == 1) {
                //   base+=base;
                return base;
            }
            part = base.substring(0, url.length() - (n - 1) * base.length());
            return part;
        }
    }

    static String base62(long no) {
        if (no == 0) {
            return "";
        } else {
            long q = no / 62;
            return base62(q) + stringvalbase62(no % 62) + "";
        }
    }

    static String stringvalbase62(long no) {
        if (no >= 0 && no <= 9) {
            return no + "";
        } else if (no >= 10 && no <= 35) {
            return Character.toString((char) (no + 87));
        } else if (no >= 36 && no <= 61) {
            return Character.toString((char) (no + 29));
        }
        return "";
    }

    public static String xorHex(String a, String b) {
        // TODO: Validation
        char[] chars = new char[a.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.toLowerCase(toHex(fromHex(a.charAt(i)) ^ fromHex(b.charAt(i))));
        }
        return new String(chars);
    }

    private static int fromHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        throw new IllegalArgumentException();
    }

    private static char toHex(int nybble) {
        if (nybble < 0 || nybble > 15) {
            throw new IllegalArgumentException();
        }
        return "0123456789ABCDEF".charAt(nybble);
    }
}
