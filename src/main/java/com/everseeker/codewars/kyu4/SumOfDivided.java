package com.everseeker.codewars.kyu4;

import java.util.*;

/**
 * Created by everseeker on 2017/2/20.
 */
public class SumOfDivided {
    public static String sumOfDivided(int[] l) {
        if (l.length < 1)
            return null;

        int max = Math.abs(l[0]);
        for (int i = 1; i < l.length; i++) {
            max = (Math.abs(l[i]) > max) ? Math.abs(l[i]) : max;
        }

        List<Integer> primes = getPrimes(max);

        Map<Integer, Long> map = new TreeMap<Integer, Long>();
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < primes.size(); j++) {
                Integer prime = primes.get(j);
                if (prime > l[i])
                    break;
                if (l[i] % prime == 0) {
                    if (map.containsKey(prime))
                        map.put(prime, map.get(prime) + l[i]);
                    else
                        map.put(prime, Long.valueOf(l[i]));
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            sb.append("(" + entry.getKey() + " " + entry.getValue() + ")");
        }

        return sb.toString();
    }

    /**
     * 返回所有小于max的质数
     * @param max
     * @return
     */
    public static List<Integer> getPrimes(int max) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        for (int prime = 3; prime <= max; prime++) {
            Iterator<Integer> iter =  list.listIterator();
            int i = 0;
            for (; i < list.size(); i++) {
                if (prime % list.get(i) == 0)
                    break;
            }
            if (i == list.size())   //说明prime为质数
                list.add(prime);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.print(sumOfDivided(new int[]{12, 15, 7}));
    }
}
