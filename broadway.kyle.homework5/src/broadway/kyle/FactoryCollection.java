package broadway.kyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FactoryCollection
{

    public static <t1> ArrayList<t1> createArraylist()
    {
        return new ArrayList<t1>();
    }

    public static <t1, t2> Map<t1, t2> createMap()
    {
        return new HashMap<t1, t2>();
    }

    public static <t1, t2> Map<t1, t2> createMap(Map<t1, t2> map)
    {
        return new HashMap<t1, t2>(map);
    }

    public static Integer createInteger(int value)
    {
        return new Integer(value);
    }

    public static <t1> ArrayList<t1> createArraylist(Set<t1> keySet)
    {
        return new ArrayList<t1>(keySet);
    }

    public static <t1> Stack<t1> createStack()
    {
        return new Stack<t1>();
    }

}
