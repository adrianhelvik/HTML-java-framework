/* TO DO:
 * - Add void attributes
 */

import java.util.HashMap;
import java.util.ArrayList;

/**
 * An html tag identifier is case insensitive
 *
 */
public class HtmlTag implements HtmlElement{
    
    // Private properties
    private String name;
    private HashMap<String, String> attributes = new HashMap<>();
    private boolean voidTag = false;
    private String innerText;
    private HtmlTag parent;
    private ArrayList<HtmlElement> children = new ArrayList<>();
    private int indentationLevel = 0;
    
    // Static properties
    private static String[] listOfVoidTags = {
        "area", "base", "br", "col", "command", "embed", "hr", "img", "input",
        "keygen", "link", "meta", "param", "source", "track", "wbr" };
    private static String indentString = "    ";

    // Constructors
    public HtmlTag(String name) {
        this.name = name;
        for (String s : listOfVoidTags) {
            if (name == s) voidTag = true;
        }
    }
    
    // Public methods 
    public void addAttribute(String key, String value) {
        // If attribute exists, append the value
        if (attributes.containsKey(key)) value = attributes.get(key) + " " + value;

        attributes.put(key, value);
    }

    public void addAttribute(String attr) {

        // Void attributes have no value
        String value = null;

        attributes.put(attr, value);
    }

    public void addClass(String className) {
        addAttribute("class", className);
    }

    public void addId(String idName) {
        addAttribute("id", idName);
    }

    public String compile() {
        String result = "";
        
        // Add indentation
        result = getIndentation();
        
        // Start opening tag
        result += "<" + name.toLowerCase();
        
        // Add attributes
        for (String attrName : attributes.keySet()) {
            result += " " + attrName;

            // If not a void attribute, add attribute value
            if (attributes.get(attrName) != null) result +="=\"" + attributes.get(attrName) + "\"";
        }
        
        // Close opening tag
        result += ">\n";
        
        // Content and end tag only added if it is a void tag
        if (isVoidTag() == false) {

            // Add all content
            for (HtmlElement elem : children) {
                result += elem.compile();
            }

            // Create closing tag
            result += getIndentation() + "</" + name + ">\n";
        }

        return result;
    }
    
    public void addElement(HtmlTag tag) {
        HtmlElement elem = tag;
        addElement(elem);
    }

    public void addElement(HtmlElement elem) {
        elem.setIndentationLevel();
        elem.setParent(this);
        children.add(elem);
    }

    public void setIndentationLevel() {
        if (parent != null) indentationLevel = parent.getIndentationLevel() + 1;
    }
    
    // TODO: Test this
    public String[] getAttributeValues(String attribute) {
        for (String key : attributes.keySet()) {
            if (key.equals(attribute)) return attributes.get(key).split(" ");
        }

        // Has no attributes (or value for key?)
        return new String[0];
    }

    // Getters
    public int getIndentationLevel() {
        setIndentationLevel();
        return indentationLevel;
    }

    public String getName() {
        return name;
    }

    public HtmlElement getParent() {
        return parent;
    }

    public HtmlElement[] getChildren() {
        HtmlElement[] result = new HtmlElement[children.size()];
        children.toArray(result);

        return result;
    }
    
    public HtmlElement[] getAllChildren() {
        HtmlElement[] children = this.getChildren();
        ArrayList<HtmlElement> matches = new ArrayList<>();
        
        // Add all immediate children
        for (HtmlElement e : children) {
            matches.add(e);

            // Results of e.getAllChildren() is null for some elements
            if (e.getAllChildren() != null) {
                
                // And recursively add their children
                for (HtmlElement e2 : e.getAllChildren()) {
                    matches.add(e2);
                }
            }
        }

        HtmlElement[] result = new HtmlElement[matches.size()];
        matches.toArray(result);
        return result;
    }

    public boolean isVoidTag() {
        return voidTag;
    }

    // Setters
    public void setParent(HtmlTag t) {
        this.parent = t;
    }

    // Private methods
    private String getIndentation() {
        String indentation = "";
        int indLevel = getIndentationLevel();

        for (int i = 0; i < indLevel; i++) indentation += indentString;
        return indentation;
    }
}
