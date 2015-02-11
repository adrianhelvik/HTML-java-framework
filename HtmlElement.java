/**
 * Interface for Html Elements (tags and strings)
 */
public interface HtmlElement {
    /**
     * Compiles Html element to a string
     */
    public String compile();

    public String getName();
    public HtmlElement getParent();
    
    public void setParent(HtmlTag parent);
    public void setIndentationLevel();
    
    public int getIndentationLevel();
    public HtmlElement[] getChildren();
    public HtmlElement[] getAllChildren();
    // public String[] getAttributeValues(String attribute); // TODO
}
