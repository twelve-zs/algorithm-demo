package com.zangsheng;

import java.util.Arrays;

/**
 * 堆排序是一种选择排序，其时间复杂度为O(nlogn)。
 */
public class HeapSort {
    private String isAscOrDes;

    /**
     * 升序排序
     *
     * @param arr 待排序数组
     */
    public void Asc(int[] arr) {
        //升序建立大顶堆（父节点分别大于等于左右孩子节点）
        isAscOrDes = "isAsc";
        creatHeap(arr, isAscOrDes);
        sort(arr, isAscOrDes);
    }

    /**
     * 降序排序
     *
     * @param arr 待排序数组
     */
    public void Des(int[] arr) {
        //降序建立小顶堆(父节点分别小于等于左右孩子节点)
        isAscOrDes = "isDes";
        creatHeap(arr, isAscOrDes);
        sort(arr, isAscOrDes);
    }

    /**
     * 排序
     *
     * @param arr        待排序数组
     * @param isAscOrDes 升序还是降序
     */
    private void sort(int[] arr, String isAscOrDes) {
        //第一个和最后一个元素互换 重新调整堆
        //第一个和倒数第二个元素互换 重新调整堆
        //.......
        for (int i = arr.length - 1; i > 0; --i) {
            AlgorithmUtil.swap(arr, 0, i);
            adjustHeap(arr, 0, i - 1, isAscOrDes);
        }
    }

    /**
     * 8 5 1 3 4 7 6
     * 8
     * 5            1
     * 3     4      7      6
     * ---------------------------
     * 6与父节点1交换
     * 8
     * 5            6
     * 3     4      7      1
     * ---------------------------
     * 7与父节点6交换
     * 8
     * 5            7
     * 3     4      6      1
     * ---------------------------
     * 4与父节点5不用交换
     * 3与父节点5不用交换
     * 7与父节点8不用交换
     * 5与父节点8不用交换
     * 最后大根堆为： [8, 5, 7, 3, 4, 6, 1]
     * <p>
     * 从下到上构建大根堆
     *
     * @param arr 待排序数组
     */
    private void creatHeap(int[] arr, String isAscOrDes) {
        for (int i = arr.length - 1; i > 0; --i) {
            //孩子节点 arr[i]
            //父节点arr[(i-1)/2]
            int parentNode = (i - 1) / 2;
            //构造大根堆
            if (isAscOrDes.equals("isAsc")) {

                if (arr[i] > arr[parentNode]) {
                    AlgorithmUtil.swap(arr, i, parentNode);
                    //交换以后判断是否对子元素产生了影响
                    adjustHeap(arr, i, arr.length - 1, isAscOrDes);
                }
            }
            //构造小根堆
            if (isAscOrDes.equals("isDes")) {

                if (arr[i] < arr[parentNode]) {
                    AlgorithmUtil.swap(arr, i, parentNode);
                    adjustHeap(arr, i, arr.length - 1, isAscOrDes);
                }
            }

        }
    }

    /**
     * 调整堆
     *
     * @param arr        数组
     * @param parent     父节点
     * @param len        数组的下标长度
     * @param isAscOrDes 升序or降序
     */
    private void adjustHeap(int[] arr, int parent, int len, String isAscOrDes) {
        int rightChildren = 2 * parent + 2;
        int leftChildren = 2 * parent + 1;
        //是否存在右孩子
        if (rightChildren <= len) {
            //遍历右孩子节点
            if (isAscOrDes.equals("isAsc")) {
                if (arr[parent] < arr[rightChildren]) {
                    AlgorithmUtil.swap(arr, parent, rightChildren);
                    adjustHeap(arr, rightChildren, len, isAscOrDes);
                }
            }
            if (isAscOrDes.equals("isDes")) {
                if (arr[parent] > arr[rightChildren]) {
                    AlgorithmUtil.swap(arr, parent, rightChildren);
                    adjustHeap(arr, rightChildren, len, isAscOrDes);
                }
            }
        }
        //是否存在左孩子
        if (leftChildren <= len) {
            //遍历左孩子节点
            if (isAscOrDes.equals("isAsc")) {
                if (arr[parent] < arr[leftChildren]) {
                    AlgorithmUtil.swap(arr, parent, leftChildren);
                    adjustHeap(arr, leftChildren, len, isAscOrDes);
                }
            }
            if (isAscOrDes.equals("isDes")) {
                if (arr[parent] > arr[leftChildren]) {
                    AlgorithmUtil.swap(arr, parent, leftChildren);
                    adjustHeap(arr, leftChildren, len, isAscOrDes);
                }
            }
        }

    }

}
