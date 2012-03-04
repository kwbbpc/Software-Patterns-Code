package com.broadway.tms;

public class SumDoer implements SomethingDoer
{

    private int sum = 0;

    @Override
    public void doSomething(BinaryTreeNode binaryTreeNode)
    {
        sum += binaryTreeNode.getData();

    }

    public int getSum()
    {
        return sum;
    }

}
