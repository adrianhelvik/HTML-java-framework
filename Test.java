class Test {
    public static void main(String[] args) {
        testGetElementById();
    }

    private static void testGetElementById() {
        String testId = "lolwtf";

        // Create basic document
        HtmlDocument d = BasicHtmlGenerator.createBasicDocument();

        // Add misc. html nodes
        d.getElementsByTagName("body")[0].addElement(new HtmlTag("div"));
        d.getElementsByTagName("body")[0].addElement(new HtmlTag("div"));
        d.getElementsByTagName("body")[0].addElement(new HtmlTag("div"));
        d.getElementsByTagName("div")[0].setId(testId);
        d.getElementsByTagName("div")[0].setId(testId);
        
        // Print compiled document
        sopl(d.compile());

        // Print test id
        sopl(
                "Searching for html node with id: \"" + testId + "\"",
                "Found: " + d.getElementById(testId).compile()
        );

    }

    public static void sopl(Object... args) {
        if (args.length == 0) System.out.println();
        for (Object o : args) System.out.println(o);
    }
    
    public static void sop(Object... args) {
        for (Object o : args) System.out.print(o);
    }

}
