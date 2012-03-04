package com.broadway.tms;

public class AverageDoer extends SumDoer
{

    private int count = 0;

    @Override
    public void doSomething(BinaryTreeNode binaryTreeNode)
    {
        super.doSomething(binaryTreeNode);
        count++;

    }

    public double getAverage()
    {
        return getSum() / count;
    }
}
