# HTML-parser
Description:
Java program for parsing html files, with selectors inspired by JavScript.

How to use:
Start by creating a new HtmlDocument. This will contain a doctype and an html-tag
HtmlElements is an interface for HtmlTag and HtmlString.

Elements can be accessed using these methods: (when document is an instance of HtmlDocument)
- document.getElementsByTagName(String tagName): HtmlTag[]
- document.getElementsByClassName(String className): HtmlTag[]
- document.getElementById(String id): HtmlTag
- document.getAllChildren(String id): HtmlElements
- - Returns an HtmlElement-array

An element can be appended to an HtmlTag object: (when tag is an instance of HtmlTag)
  tag.addElement(HtmlElement e)
