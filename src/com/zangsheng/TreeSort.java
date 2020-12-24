package com.zangsheng;

public class TreeSort {
    private int ascIndex;//升序下标
    private int desIndex;//降序下标
    private  int[] array;//排序数组
    private  Tree mRoot;//根节点

    /**
     * 升序排序
     * @param arr 待排序数组
     * @return 排序完成的数组
     */
    public int[] getAscArr(int[] arr) {
        sort(arr);
        ascErgodic(mRoot, array);
        return array;
    }

    /**
     * 降序排序
     * @param arr 待排序数组
     * @return 排序完成的数组
     */
    public int[] getDesArr(int[] arr) {
        sort(arr);
        desErgodic(mRoot, array);
        return array;
    }
    private void sort(int[] arr){
        ascIndex = -1;
        desIndex = -1;
        this.array = new int[arr.length];
        mRoot = new Tree(arr[0], null, null);
        for (int i = 1; i < arr.length; ++i) {
            creatTree(mRoot, arr,i);
        }
    }

    /**
     * 创建排序树
     * 大于等于roo插入右边
     * 小于root插入左边
     * 10 8 60 70 40 9 0
     *              10
     * ---------------------------
     *              10
     *         8
     * ---------------------------
     *               10
     *         8            60
     * ---------------------------
     *               10
     *         8            60
     *                              70
     * ---------------------------
     *                   10
     *         8                   60
     *                        40       70
     * ---------------------------
     *                    10
     *         8                    60
     *            9             40      70
     * ---------------------------
     *                    10
     *         8                    60
     *      0     9             40      70
     * @param root 根节点
     * @param index 需要插入的数组下标
     */
    private void creatTree(Tree root, int []arr,int index) {
        if (arr[index] >= root.getData()) {
            if (root.getRightChildren() != null) {
                creatTree(root.getRightChildren(), arr,index);
            } else {
                Tree tree = new Tree(arr[index], null, null);
                root.setRightChildren(tree);
            }
        } else {
            if (root.getLeftChildren() != null) {
                creatTree(root.getLeftChildren(),arr, index);
            } else {
                Tree tree = new Tree(arr[index], null, null);
                root.setLeftChildren(tree);
            }
        }
    }
    /**
     * 升序排序 读取二叉树
     * @param root 根节点
     * @param arr 排序结果装入此数组
     */
    private void ascErgodic(Tree root, int[] arr) {
        if (root.getLeftChildren() != null) {
            ascErgodic(root.getLeftChildren(), arr);
        }
        arr[++ascIndex] = root.getData();
        if (root.getRightChildren() != null) {
            ascErgodic(root.getRightChildren(), arr);
        }
    }
    /**
     * 降序排序 读取二叉树
     * @param root 根节点
     * @param arr 排序结果装入此数组
     */
    private void desErgodic(Tree root, int[] arr) {
        if (root.getRightChildren() != null) {
            desErgodic(root.getRightChildren(), arr);
        }
        arr[++desIndex] = root.getData();
        if (root.getLeftChildren() != null) {
            desErgodic(root.getLeftChildren(), arr);
        }
    }
}
