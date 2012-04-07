package com.broadway.tms;

public class AverageWalker extends SumWalker
{

    private int count = 0;

    @Override
    protected void doSomething(BinaryTreeNode node)
    {
        super.doSomething(node);
        count++;
    }

    public double getAverage()
    {
        return getSum() / count;
    }

}
