package com.broadway.tms;

public abstract class Walker
{

    //TEMPLATE METHOD
    public final void inOrder(BinaryTreeNode node)
    {
        if (node.getLeft() != null)
            inOrder(node.getLeft());
        doSomething(node);
        if (node.getRight() != null)
            inOrder(node.getRight());
    }

    //HOOK METHOD
    protected abstract void doSomething(BinaryTreeNode node);

}
