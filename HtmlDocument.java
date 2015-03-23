import java.util.ArrayList;

/**
 * Stores an Html document
 */
public class HtmlDocument {
    private HtmlElement doctype = new Doctype();
    private HtmlTag html = new HtmlTag("html");

    public HtmlDocument() {
    }

    public String compile() {
        return doctype.compile() + html.compile();
    } 

    public void addElement(HtmlElement elem) {
        html.addElement(elem);
    }

    /**
     * STUB
     *
     * Fetch an HTML element using css selectors
     *
     * Cases:
     * Tag name             ex: div
     * Class name           ex: .someClass
     * Id                   ex: #someId
     * Attribute            ex: TODO!!!!
     * Descendant           ex: div .someClass
     * Direct child         ex: div > .someClass
     * pseudoselectors      ex: .someclass:first-child,
     *                          .someclass:nth-child(expression[3+2, 3, 5], some other shaite see css-tricks),
     *                          .someclass:last-child
    */
    /*
    public HtmlElement[] querySelectorAll(String query) {
        HtmlTag currentTag;
        ArrayList<HtmlTag> matches = new ArrayList<>();

        // Separate by spaces
        String[] queries = query.split(" ");
        
        // Go to last in query chain
        for (String currentQuery : queries) {

            // Class name not associated with a specific html tag
            if (currentQuery.charAt(0) == '.') {
                String className = currentQuery.substring(1, currentQuery.length - 1);
                System.out.println(className);
                
                //
                // @issue: Will currently fetch global matches
                //
                
                // Get those
                HtmlElement tmpMatches = document.getElementsByClassName(className);

                for (HtmlElement e : tmpMatches
            }
        }

        return null;
    }
    */
    
    // Seemingly ok
    public HtmlTag[] getElementsByTagName(String tagName) {
        ArrayList<HtmlTag> matches = new ArrayList<>();

        HtmlElement[] allChildren = getAllChildren();
        
        for (HtmlElement e : allChildren) {
            if (e instanceof HtmlTag) {
                if (e.getName().equals(tagName)) matches.add((HtmlTag) e);
            }
        }

        HtmlTag[] result = new HtmlTag[matches.size()];
        matches.toArray(result);
        return result;
    }
    
    // Seemingly ok
    public HtmlTag getElementById(String id) {
        HtmlElement[] children = getAllChildren();
        for (HtmlElement e : children) {

            // If element is an html tag
            if (e instanceof HtmlTag && e != null) {
                // Set t to html tag
                HtmlTag t = (HtmlTag) e;

                // Fetch ids for tag
                String[] ids = t.getAttributeValues("id");
                
                // Figure out if the tag has this id
                for (String tagId : ids) {

                    // If id is found, return element
                    if (id.equals(tagId)) return t;
                }
            }
        }
        
        // No matches found
        return null;
    }
    
    // Seemingly ok
    public HtmlElement[] getElementsByClassName(String className) {
        HtmlElement[] children = getAllChildren();
        ArrayList<HtmlElement> matches = new ArrayList<>();

        for (HtmlElement e : children) {

            // If element is an html tag
            if (e instanceof HtmlTag && e != null) {

                // Set t to html tag
                HtmlTag t = (HtmlTag) e;

                // Fetch classes for tag
                String[] classes = t.getAttributeValues("class");
                
                // Figure out if the tag has this class
                for (String tagClass : classes) {

                    // If id is found, return element
                    if (className.equals(tagClass)) matches.add(e);
                }
            }
        }

        // Convert ArrayList to array
        HtmlElement[] result = new HtmlElement[matches.size()];
        matches.toArray(result);
        
        // Return result
        return result;
    }

    public HtmlElement[] getAllChildren() {

        // Get children of html
        HtmlElement[] htmlChildren = html.getAllChildren();
    
        // Add elements (including html) to array
        HtmlElement[] children = new HtmlElement[htmlChildren.length + 1];
        children[children.length - 1] = html; // Test this
        for (int i = 0; i < htmlChildren.length; i++) {
            children[i] = htmlChildren[i];
        }

        return children;
    }
    
    public HtmlElement[] getChildren() {
        // Avoid null pointer
        return new HtmlTag[0];
    }

    public String getName() {
        return "doctype";
    }
}
