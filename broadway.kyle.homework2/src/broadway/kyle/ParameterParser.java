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

    public static final String itemId = "id";
    public static final String quantity = "quantity";

    public static final String id = "id";
    public static final String name = "name";
    public static final String street = "street";
    public static final String city = "city";
    public static final String zip = "zip";
    public static final String phone = "phone";
    public static final String password = "password";

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
    public static String find(String paramToFind, Map<String, String[]> params)
    {
        if (params != null)
        {
            String[] values = params.get(paramToFind);

            if (values.length >= 1)
                return values[0];
            else
                return "";
        }

        return null;
    }

}
