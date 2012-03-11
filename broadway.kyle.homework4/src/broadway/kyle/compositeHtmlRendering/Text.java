package broadway.kyle.compositeHtmlRendering;

import java.io.PrintStream;

public class Text implements Renderer
{
    private String text = "";

    public Text(String text)
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
