# HTML java framework
Description:
This is a java program for creating html files, with selectors inspired by JavScript. Not quite there for all the methods yet though.

How to use:
Start by creating a new HtmlDocument. This will contain a doctype and an html-tag
HtmlTags store HtmlElement objects. HtmlElement is an interface for HtmlTag and HtmlString.
HtmlString is basically a String wrapper class that enables some functionality
(indentation relative to parent for example) and storing the elements in the same ArrayList.

Elements can be accessed using these methods:

For HtmlDocument objects:
- HtmlDocument.getElementsByTagName(String tagName): HtmlTag[]
- HtmlDocument.getElementsByClassName(String className): HtmlTag[]
- HtmlDocument.getElementById(String id): HtmlTag
- HtmlDocument.getAllChildren(String id): HtmlElement[]

For HtmlTag objects:
- HtmlTag.getParent()
- HtmlTag.getChildren()

Elements can be appended to an element or the document using these methods:
- HtmlTag.addElement(HtmlElement/HtmlTag e): void
- HtmlDocument.addElement(HtmlElement e): void
- HtmlTag.addElement(HtmlElement e): void

