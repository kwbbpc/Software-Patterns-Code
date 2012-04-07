package com.broadway.tms;

public class App
{

    public static void main(String[] args)
    {
        BinaryTreeNode root = new BinaryTreeNode(42);
        root.insert(10);
        root.insert(100);
        root.insert(76);
        root.insert(406);
        root.insert(33);
        root.insert(12);
        root.insert(1024);

        SumWalker sumWalker = new SumWalker();

        sumWalker.inOrder(root);
        System.out.println(sumWalker.getSum());
        System.out.println(sumWalker.getSum());

        AverageWalker averageWalker = new AverageWalker();

        averageWalker.inOrder(root);
        System.out.println(averageWalker.getAverage());
        System.out.println(averageWalker.getAverage());

        SumDoer sumDoer = new SumDoer();
        AverageDoer averageDoer = new AverageDoer();
        Walker2 walker2 = new Walker2();
        walker2.inOrder(root, sumDoer);
        System.out.println(sumDoer.getSum());

        walker2.inOrder(root, averageDoer);
        System.out.println(averageDoer.getAverage());

        NullDoer nullDoer = new NullDoer();
        walker2.setDoer(nullDoer);
        walker2.inOrder2(root);

    }

}
