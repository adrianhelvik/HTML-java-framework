# HTML-parser
Description:
Java program for parsing html files, with selectors inspired by JavScript.

How to use:
Start by creating a new HtmlDocument. This will contain a doctype and an html-tag

Elements can be accessed using these methods: (when document is an instance of HtmlDocument)
  document.getElementsByTagName(String tagName)
    Returns an HtmlTag-array
  document.getElementsByClassName(String className)
    Returns an HtmlTag-array
  document.getElementById(String id)
    Returns an HtmlElement... Note to self: Should return an HtmlTag
  document.getAllChildren(String id)

An element can be appended to an HtmlTag object: (when tag is an instance of HtmlTag)
  tag.addElement(HtmlElement e)
