package com.broadway.tms;

public class SumWalker extends Walker
{

    private int sum = 0;

    public int getSum()
    {
        return sum;
    }

    @Override
    protected void doSomething(BinaryTreeNode node)
    {
        sum += node.getData();

    }

}
