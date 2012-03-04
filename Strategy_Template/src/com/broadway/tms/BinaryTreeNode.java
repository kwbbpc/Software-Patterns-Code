package com.broadway.tms;

public class BinaryTreeNode
{

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data)
    {
        this.data = data;
    }

    public void insert(int data)
    {
        if (data < this.data)
        {
            if (left == null)
                left = new BinaryTreeNode(data);
            else
                left.insert(data);
        }
        else
        {
            if (right == null)
                right = new BinaryTreeNode(data);
            else
                right.insert(data);

        }
    }

    public int getData()
    {
        return data;
    }

    public BinaryTreeNode getRight()
    {
        return right;
    }

    public BinaryTreeNode getLeft()
    {
        return left;
    }

}
