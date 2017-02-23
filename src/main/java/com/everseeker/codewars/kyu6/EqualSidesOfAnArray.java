package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/15.
 */
public class EqualSidesOfAnArray {
    public static int findEvenIndex(int[] arr) {
        int left = arr[0];
        int right = 0;
        int arrLength = arr.length;
        for (int i = 2; i < arrLength; i++) {
            right += arr[i];
        }
        int N = 1;
        do {
            if (left == right) {
                return N;
            } else {
                left += arr[N];
                right -= arr[++N];
            }
        } while (N < arrLength - 1);

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4};
        System.out.print(EqualSidesOfAnArray.findEvenIndex(arr));
    }
}
