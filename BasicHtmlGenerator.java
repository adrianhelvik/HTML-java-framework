import java.util.HashMap;
import java.util.Scanner;

public class BasicHtmlGenerator {

    private static Scanner input = new Scanner(System.in);
    
    // MAIN
    public static void main(String[] args) {
        HtmlDocument document = createBasicDocument();
        String ans;
        
        sop("Provide a location to store the files: ");
        ans = input.nextLine();

        sopl("Storing files in directory \"" + ans + "\"");

        sopl(document.compile());
    }

    // Testing
    private static void checkIndent(HtmlElement elem, int desired) {
        String message = (elem.getIndentationLevel() == desired) ? "OK. " : "ERROR. ";
        message += "Indentation level of " + elem.getName() + ": " + elem.getIndentationLevel() + ". Should be 2";

        sopl(message);
    }
    
    /**
     * Create a basic Html Document
     */
    public static HtmlDocument createBasicDocument() {

        // Create document
        HtmlDocument document = new HtmlDocument();

        // Create and append html elements
        document.addElement(new HtmlTag("head"));
        document.addElement(new HtmlTag("body"));

        document.getElementsByTagName("head")[0].addElement(new HtmlTag("meta"));
        document.getElementsByTagName("head")[0].addElement(new HtmlTag("link"));
        document.getElementsByTagName("body")[0].addElement(new HtmlTag("script"));

        document.getElementsByTagName("link")[0].addAttribute("rel", "stylesheet");
        document.getElementsByTagName("link")[0].addAttribute("href", "STYLESHEET-NAME");
        document.getElementsByTagName("meta")[0].addAttribute("charset", "utf-8");
        document.getElementsByTagName("script")[0].addAttribute("src", "SCRIPT-NAME");

        return document;
    }

    // Static methods
    private static void sopl(Object... args) {
        if (args.length == 0) System.out.println();
        for (Object o : args) System.out.println(o);
    }
    
    private static void sop(Object... args) {
        for (Object o : args) System.out.print(o);
    }
}

