/**
 * A wrapper for Html Strings
 */
public class HtmlString implements HtmlElement {
    private String contents;
    private HtmlTag parent;
    private int indentationLevel = 0;
    private String indentString = "    ";

    public HtmlString(String contents) {
        this.contents = contents;
    }

    public String compile() {
        String compiled;

        // Replace all multiples of spaces and new lines with one space
        compiled = contents.replaceAll("[\\s]+", " ");
        compiled += "\n";

        compiled = getIndentation() + compiled;

        return compiled;
    }

    public String getName() {
        String result = "string";
        String excerpt = "";
        if (contents.length() < 10) excerpt = contents;
        else excerpt = contents.substring(0, 10) + "...";

        result += "[" + excerpt + "]";
        return result;
    }

    // Getters
    public HtmlTag getParent() {
        return parent; 
    }

    /**
     * Update indentation level and return it
     */
    public int getIndentationLevel() {
        indentationLevel = getParent().getIndentationLevel() + 1;
        return indentationLevel;
    }

    public HtmlElement[] getChildren() {
        return null;
    }
    
    public HtmlElement[] getAllChildren() {
        return null;
    }

    // Setters
    public void setParent(HtmlTag parent) {
        this.parent = parent;
    }

    public void setIndentationLevel() {
        if (getParent() != null) indentationLevel = parent.getIndentationLevel() + 1;
    }
    
    // Private methods
    
    private String getIndentation() {
        String indentation = "";
        int indLevel = getIndentationLevel();

        for (int i = 0; i < indLevel; i++) indentation += indentString;
        return indentation;
    }
}
