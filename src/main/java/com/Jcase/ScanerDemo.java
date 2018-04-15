package com.Jcase;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 类比C的scanf
 */
public class ScanerDemo {
    public static void main(String[] args) {
        Scaner s = new Scaner();
        s.Test();
    }
}

class Scaner {
    public void Test() {
        int[] iArray = new int[5];
        int len = iArray.length;
        int total = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("输入" + len +"个整数, 以空格分割:");

        for (int i=0; i<len; i++) {
            iArray[i] = sc.nextInt();
        }

        for (int i=0; i<len; i++) {
            total += iArray[i];
        }

        System.out.println("所有元素是:" + Arrays.toString(iArray));
        System.out.println("所有元素和是:" + total);
    }
}

