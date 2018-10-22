---
layout: page
title: "Short Assignment 6 &mdash; Due: Monday, February 2"
---

## Exercises

Write and demonstrate the following two methods:

#### public BinaryTree<E> copyToDepth(int d)

> This produces a "shallow" copy of a tree, down to the given depth. By "shallow",
> I mean that the tree structure is copied, but the same data elements are used
> (not copies of them). By "down to the given depth", I mean that nodes deeper
> than the value are chopped out. For depth 0, only the node itself is kept;
> its children are null. For depth 1, the children are kept but their children
> are null.
>
> Add this method to BinaryTree.java.

#### public static ArrayList<Node> getElementsWithTag(Node n, String tag)

> This produces a list of element nodes of the given tag. So, for example, we
> could extract all the paragraphs (\<p\>) from an HTML document "d" by
> getElementsWithTag(d, "p").
>
> Add this method to ExampleXML.java.

## Submission Instructions ##

Turn in your completed Java code (insert the methods into the files from class)
and results from a test case (added to the main()).
