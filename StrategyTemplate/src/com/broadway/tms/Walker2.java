package com.broadway.tms;

public class Walker2
{

    //TEMPLATE METHOD                            //Function pointer (do somethign)
    public final void inOrder(BinaryTreeNode node, SomethingDoer doer)
    {
        if (node.getLeft() != null)
            inOrder(node.getLeft(), doer);
        doer.doSomething(node);
        if (node.getRight() != null)
            inOrder(node.getRight(), doer);
    }

    private static final SomethingDoer NULL_DOER = new NullDoer();
    private SomethingDoer doer = NULL_DOER;

    public void setDoer(SomethingDoer doer)
    {
        if (doer == null)

            this.doer = NULL_DOER;

        else

            this.doer = doer;
    }

    public final void inOrder2(BinaryTreeNode node)
    {
        if (node.getLeft() != null)
            inOrder(node.getLeft(), doer);
        doer.doSomething(node);
        if (node.getRight() != null)
            inOrder(node.getRight(), doer);
    }

}
