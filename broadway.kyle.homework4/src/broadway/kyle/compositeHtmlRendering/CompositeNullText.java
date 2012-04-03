package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class CompositeNullText extends CompositeText
{

    public CompositeNullText()
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
