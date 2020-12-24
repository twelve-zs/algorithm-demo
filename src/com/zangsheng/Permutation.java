package com.zangsheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    /**
     * 全排列数量
     */
    private int count = 0;
    /**
     * 全排列各种组合
     */
    private List<String> listPermutation;


    /**
     * 获取包含重复的排列
     * @param arr 待排列数组
     * @return 排列集合
     */
    public List<String> repeatPermutation(int []arr){
        this.count = 0;
        this.listPermutation =  new ArrayList<>();
        repeatPermutation(arr,0);
        return this.listPermutation;
    }
    /**
     * 获取不包含重复的排列
     * @param arr 待排列数组
     * @return 排列集合
     */
    public List<String> noRepeatPermutation(int []arr){
        this.count = 0;
        this.listPermutation =  new ArrayList<>();
        noRepeatPermutation(arr,0);
        return this.listPermutation;
    }


    private void repeatPermutation(int []arr,int index){
        if (index==arr.length){
            listPermutation.add(Arrays.toString(arr));
            count++;
        }
        for(int i = index;i<arr.length;++i){
            //交换元素
            AlgorithmUtil.swap(arr,index,i);
            //递归
            repeatPermutation(arr,index+1);
            //回复原排列顺序
            AlgorithmUtil.swap(arr,index,i);
        }
    }
    private void noRepeatPermutation(int []arr,int index){
        if (index==arr.length){
            listPermutation.add(Arrays.toString(arr));
            count++;
        }
        for(int i = index;i<arr.length;++i){
            if (i==index||arr[i]!=arr[index]){
                //交换元素
                AlgorithmUtil.swap(arr,index,i);
                //递归
                noRepeatPermutation(arr,index+1);
                //回复原排列顺序
                AlgorithmUtil.swap(arr,index,i);
            }
        }
    }
    /**
     * 获取排列组合的个数
     * @return
     */
    public int getCount() {
        return count;
    }

}
