package com.zangsheng;

public class AlgorithmUtil {
    public AlgorithmUtil(){

    }

    /**
     * 数组元素交换
     * @param arr 数组
     * @param indexOne 元素1下标
     * @param indexTwo 元素2下标
     * @return 交换是否成功
     */
    public static boolean swap(int []arr,int indexOne,int indexTwo){
        //数组为空交换失败
        if (arr == null || arr.length == 0){
            return false;
        }
        //下标小于0交换失败
        if (indexOne<0||indexTwo<0){
            return false;
        }
        //下表超过数组长度交换失败
        if (arr.length-1<indexOne||arr.length-1<indexTwo){
            return false;
        }
        //元素交换
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
        return true;
    }
    public static boolean swap(char []arr,int indexOne,int indexTwo){
        //数组为空交换失败
        if (arr == null || arr.length == 0){
            return false;
        }
        //下标小于0交换失败
        if (indexOne<0||indexTwo<0){
            return false;
        }
        //下表超过数组长度交换失败
        if (arr.length-1<indexOne||arr.length-1<indexTwo){
            return false;
        }
        //元素交换
        char temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
        return true;
    }
}
