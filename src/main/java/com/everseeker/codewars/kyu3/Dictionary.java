package com.everseeker.codewars.kyu3;

/**
 * Created by everseeker on 2017/2/20.
 */
public class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        if (words.length == 0)
            return null;

        String result = words[0];
        int min = calStringDistance(to, words[0]);
        for (int i = 1; i < words.length; i++) {
            int tmp = calStringDistance(to, words[i]);
            if (tmp == 0)
                return words[i];
            if (tmp < min) {
                min = tmp;
                result = words[i];
            }
        }

        return result;
    }

    public static int calStringDistance(String strA, String strB) {
        int lenA = strA.length() + 1;
        int lenB = strB.length() + 1;
        int[][] dist = new int[lenA][lenB];
        for (int i = 1; i < lenA; i++)
            dist[i][0] = i;
        for (int j = 1; j < lenB; j++)
            dist[0][j] = j;
        dist[0][0] = 0;

        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                if (strA.charAt(i-1) == strB.charAt(j-1))
                    dist[i][j] = dist[i-1][j-1];
                else
                    dist[i][j] = Math.min(Math.min(dist[i-1][j], dist[i][j-1]), dist[i-1][j-1]) + 1;
            }
        }

        return dist[lenA-1][lenB-1];
    }

    public static void main(String[] args) {
        System.out.print(calStringDistance("ppap", "ppap"));
    }
}
