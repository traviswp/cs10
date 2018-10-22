---
layout: page
title: "Short Assignment 9 &mdash; Due: Wednesday, February 25"
---

Recall that chapter 14 in our textbook is dedicated to Graphs &mdash; you'll probably
find section 14.1 to be helpful in general.

## Exercises ##

Write a directed graph class <code>DirectedAdjListMap</code> that extends
<code>AdjacencyListGraphMap</code>. In particular, we've given you the structure
of the class to get you started and you will implement the methods in the provided file:
<a href="resources/DirectedAdjListMap.java">DirectedAdjListMap.java</a>.
Note that, as we did with <code>AdjacencyListMap</code>, you should also implement
overloaded versions of the last methods that take a vertex identifier of type
<code>V</code> instead of a vertex of type <code>Vertex&lt;V&gt;</code>. Each of
these should have a one-line body that calls a version of a method that has one
or more <code>Vertex&lt;V&gt;</code> parameters instead of a <code>V</code>
parameters.

Your graph will actually be a *mixed* graph. Some edges will be labeled as directed
while others will not. Directed edges only go from *source* to *destination*. They are created
by a call to <code>insertDirectedEdge</code>. However, your class inherits a method
<code>insertEdge</code> that inserts a undirected edge. Such an edge should be
considered equivalent to having two directed edges, one in each direction.
Therefore it is treated as both an incoming edge and an outgoing edge for each
of its incident vertices, and it should contribute to both the in-degree and
out-degree of an incident vertex.

Note that your class extends the <code>AdjacencyListGraph</code>, and thus cannot
change how edges are represented within that class. How can we tell which edges
are directed? We use the [**Decorator pattern**](https://en.wikipedia.org/wiki/Decorator_pattern)
and the fact that <code>MyEdge</code> implements the <code>DecorablePosition</code>
inteface (via extending <code>MyPosition</code>). That means that there is a small
map associated with each edge, and that map can be used to save additional properties
for that edge. In particular you can create a property object <code>EDGE_TYPE</code>
and a value object <code>DIRECTED</code> and call <code>put(EDGE_TYPE, DIRECTED)</code>
on an edge that you wish to mark as directed. You can then use <code>get(EDGE_TYPE)</code>
to determine if an edge is directed. (You could also have an object <code>UNDIRECTED</code>,
but it requires less code to simply assume that an edge that is not marked <code>DIRECTED</code>
is undirected.)

You should test your program with the main method in the provided file
<a href="resources/DirectedAdjListMap.java">DirectedAdjListMap.java</a>.

## Submission Instructions ##

Turn in your completed code and the output from the test run.
