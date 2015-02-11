class Doctype implements HtmlElement {
    private String doctypeString;
    private HtmlTag parent = null;
    private int indentationLevel = 0;

    public Doctype() {
        // Assume html5
        doctypeString = "<!DOCTYPE html>\n";
    }

    // Misc. public methods

    public String compile() { return doctypeString; }
    
    // Getters
    
    /**
     * @return Returns the number of parent elements
     */
    public int getIndentationLevel() {
        return indentationLevel;
    }

    public String getName() {
        return "doctype";
    }

    public HtmlElement getParent() {
        return parent;
    
    }
    
    public HtmlElement[] getAllChildren() {
        return null;
    }

    public HtmlElement[] getChildren() {
        return null;
    }

    // Setters
    
    /**
     * Sets the indentation level of this element to one more than that of its parent element
     */
    public void setIndentationLevel() {
        if (parent != null) indentationLevel = parent.getIndentationLevel() + 1;
    }
    
    /**
     * If a doctype is at the top of an iframe or similar, it will need a parent
     */
    public void setParent(HtmlTag parent) {
        this.parent = parent;
    }

}
