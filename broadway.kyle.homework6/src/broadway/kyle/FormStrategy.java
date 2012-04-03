package broadway.kyle;

import broadway.kyle.compositeHtmlRendering.Renderer;

public interface FormStrategy
{

    public <T> Renderer build(T parameter);

}
