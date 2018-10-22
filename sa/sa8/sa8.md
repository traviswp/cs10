---
layout: page
title: "Short Assignment 8 &mdash; Due: Friday, February 13."
---

This assignment will give you practice with sets and maps. The program
<a href="resources/StatesAndCities.java">StatesAndCities.java</a>
is the skeleton of a program that allows you to add (state, city) pairs to a
database of such pairs. They are stored in a <code>Map</code> keyed on state
names. The corresponding value is a <code>Set</code> of city names that are
within the state. I have replaced method bodies by the comment,
<code>// TODO: Your Code Here</code>.

A sample run of the finished program is:

```
Command (q, a, i, P, ?): a
Enter state: NH
Enter city in the state: Concord
Command (q, a, i, P, ?): a
Enter state: NH
Enter city in the state: Hanover
Command (q, a, i, P, ?): a
Enter state: MA
Enter city in the state: Concord
Command (q, a, i, P, ?): a
Enter state: MA
Enter city in the state: Boston
Command (q, a, i, P, ?): a
Enter state: VT
Enter city in the state: Burlington
Command (q, a, i, P, ?): i
Enter state: NH
Enter city that might be in the state: Concord
Concord is in  NH
Command (q, a, i, P, ?): i
Enter state: VT
Enter city that might be in the state: Concord
Concord is not listed as being in VT
Command (q, a, i, P, ?): P
MA: Boston  Concord
NH: Concord  Hanover
VT: Burlington

Command (q, a, i, P, ?): q
Bye
```

## Aside: Iterators ##

> In a recent lecture we briefly discussed "iterators" &mdash; I want to provide some
> details about iterators because it can be useful in this assignment (for iterating
> over, say, a Map :), so I've linked some notes [\[here\]](../../lectures/15/15.html).
> I'd recommend focusing on *SampleIterator.java*, *SimileIList.java*, *IterTest.java*, and
> *ISinglyLinked.java* (the other files offer more examples but are just their to reinforce
> the idea behind iterators and how they work in practice).

> Iterators will **not** be on the exam. I want to emphasize that this info is being
> provided to aid you in this short assignment, as well as in your general knowledge
> about programming.

## Exercises ##

1. Complete the method bodies to make this program work correctly.
2. Devise a set of test cases to demonstrate that it is working correctly.

## Submission Instructions ##

Turn in your completed code and your test cases.
