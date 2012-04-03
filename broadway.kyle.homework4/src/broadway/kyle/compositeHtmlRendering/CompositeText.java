package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class CompositeText implements Renderer
{
    private String text = "";

    public CompositeText(String text)
    {
        if (text != null)
        {
            this.text = text;
        }
        else
        {
            this.text = "";
        }
    }

    @Override
    public void render(PrintStream stream)
    {
        stream.print(text);
    }

}
