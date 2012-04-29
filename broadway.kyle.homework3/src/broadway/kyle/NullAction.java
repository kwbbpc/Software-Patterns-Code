package broadway.kyle;

import java.util.Map;

public class NullAction implements ActionStrategy
{

    @Override
    public String go(Map<String, String[]> parameters)
    {
        return "Ok";
    }

}
