package com.zangsheng;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int []arr = new int[]{1,1};
        Permutation perm = new Permutation();
        List<String> ints = perm.noRepeatPermutation(arr);
        for (String array:ints) {
            System.out.println(array);
        }
        System.out.println(perm.getCount());
        int []arr2 = new int[]{1,1,3,4,5,6};
        List<String> intss = perm.noRepeatPermutation(arr2);
        for (String array:intss) {
            System.out.println(array);
        }
        System.out.println(perm.getCount());
    }
}
