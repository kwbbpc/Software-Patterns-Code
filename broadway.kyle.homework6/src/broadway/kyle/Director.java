package broadway.kyle;

import java.io.PrintStream;

public interface Director
{

    public Builder getBuilder();

    public void setBuilder(Builder builder);

    public void build(PrintStream printStream);

}
