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

    public static final String itemId = "itemId";
    public static final String quantity = "quantity";

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
            {
                if (values.length >= 1)
                    return values[0];
                else
                    return "";

            }

            else if (paramToFind.equals(quantity))
            {
                try
                {
                    return new Integer(Integer.parseInt(values[0]));
                }
                catch (NumberFormatException e)
                {
                    return 0;
                }

            }

        }

        return null;
    }

}
