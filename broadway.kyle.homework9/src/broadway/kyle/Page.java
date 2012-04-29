package broadway.kyle;


/**
 * @author KBroadway
 *
 * Holds the page name and the map of transitions, keyed by event name
 *
 */
public interface Page
{

    String getPageName();

    void setPageName(String pageName);

    void setTransition(Transition transition);

    Transition getTransition();

}
