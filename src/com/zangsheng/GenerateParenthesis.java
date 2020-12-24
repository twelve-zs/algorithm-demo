package com.zangsheng;

import java.util.ArrayList;
/**
 *
 *         给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 *         例如，给出n=3，解集为：
 *         "((()))", "(()())", "(())()", "()()()", "()(())",
 *         解题思路
 *         递归添加括号
 */

public class GenerateParenthesis {
    public ArrayList<String> list =new ArrayList<>();
    public  ArrayList<String> generateParenthesis(int n){
        char []arr = new char[2*n];
        arr[0] = '(';
        fun(arr,n,1,0,1);
        return list;
    }

    /**
     *
     * @param arr 括号数组
     * @param n 多少对括号
     * @param left （ 括号数量
     * @param right ） 括号数量
     * @param index 当前下表
     */
    private  void fun(char []arr,int n,int left,int right,int index){

        if (left ==right&&left==n){
            list.add(String.valueOf(arr));
            return;
        }
        for (int i=index;i<2*n;++i){
            arr[i]='(';
            left++;

            fun(arr,n,left,right,i+1);

            left--;
            right++;
            arr[i]=')';
            if (right<=left){
                fun(arr,n,left,right,i+1);
            }
            right --;
        }

    }
}
