package edu.mum.CS435.Lab02;

import java.util.*;

/**
 * Created by hungduong on 11/3/16.
 */
public class PowerSetClass {
    public static List<Set<String>> PowerSet(List<String> X) {
        List<Set<String>> P = new ArrayList<>();
        Set<String> S = new TreeSet<>();

        P.add(S);

        Set<String> T;

        while(!X.isEmpty()) {
            String c = X.remove(0);

            int size = P.size();
            for(int index=0; index<size; index++) {
                T = new TreeSet<>();

                T.addAll(P.get(index));

                T.add(c);
                P.add(T);
            }
        }

        return P;
    }

    public static void main(String[] args) {
        List<String> X = new ArrayList<>();
        X.add("a");
        X.add("b");
        X.add("c");

        List<Set<String>> cb = PowerSetClass.PowerSet(X);

        for(int index=0; index<cb.size(); index++) {
            System.out.println(cb.get(index).toString());
        }
    }
}
