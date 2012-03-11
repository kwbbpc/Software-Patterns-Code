package broadway.kyle;

import java.util.Map;

/**
 * @author KBroadway
 *
 *  This static class handles the parsing of the parameter map from a 
 *  request.
 *
 */
public class ParameterParser
{

    private static final String itemId = "itemId";
    private static final String quantity = "quantity";

    /**
     * Parses through the given map of parameters and returns the value
     * corresponding to the paramToFind.
     * 
     * @param paramToFind
     * The particular parameter you're interested in
     * @param params
     * The parameters map from a request
     * @return
     * The value corresponding to paramToFind
     */
    public static Object find(String paramToFind, Map<String, String[]> params)
    {
        if (params != null)
        {
            String[] values = params.get(paramToFind);

            if (paramToFind.equals(itemId))
                return values[0];
            else if (paramToFind.equals(quantity))
                return new Integer(Integer.parseInt(values[0]));
        }

        return null;
    }

}
