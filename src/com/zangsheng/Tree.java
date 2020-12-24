package com.zangsheng;

public class Tree {

    private int data; //数据
    private Tree leftChildren; //左孩子
    private Tree rightChildren;//右孩子

    public Tree() {

    }
    public Tree(int data, Tree leftChildren, Tree rightChildren) {
        this.data = data;
        this.leftChildren = leftChildren;
        this.rightChildren = rightChildren;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Tree getLeftChildren() {
        return leftChildren;
    }

    public void setLeftChildren(Tree leftChildren) {
        this.leftChildren = leftChildren;
    }

    public Tree getRightChildren() {
        return rightChildren;
    }

    public void setRightChildren(Tree rightChildren) {
        this.rightChildren = rightChildren;
    }
}
