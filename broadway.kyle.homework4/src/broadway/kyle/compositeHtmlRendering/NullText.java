package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class NullText extends Text
{

    public NullText()
    {
        super("");
    }

    @Override
    public void render(PrintStream stream)
    {
        //Attempt to print out null text
        assert (false);
        System.out.println("");
    }

}
