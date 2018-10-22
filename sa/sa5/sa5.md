---
layout: page
title: "Short Assignment 5 &mdash; Due: Monday, January 26"
---

In light of our recent lecture on synchronization, and more specifically our time
spent looking at the Dining Philosophers problem, for this short assignment we want
you to ponder a few things (outlined below), maybe eat some food, think about it some
more, write up your solution, think about it *a little more*... and then submit your assignment.

In class we discussed a few approaches to preventing deadlock in the dining philosophers
problem. The last approach we looked at, **MonitoredDiningPhilosophers**, fixed the
issue of deadlock by making the "hold and wait" condition impossible. Specifically,
our synchronization required philosophers to "request" (through a monitor) to pick
up both forks at once. If one or neither of the forks is available, a philosopher
must wait; otherwise, the philosopher can pick up both forks and eat.

While this fixes the problem of deadlock, we hinted at the fact that this approach
still has some drawbacks &mdash; namely, that a philosopher could "starve"
if at least one of their neighbors always has a fork.

## Exercises ##

1. Propose an idea that adapts the solution provided in MonitoredDiningPhilosophers
to ensure that no philosopher will starve. You **do not** have to implement your proposed
solution, but you should provide sufficient explanation for why you believe your
proposed solution will in fact keep philosophers from starving. I suggest you make
sure you understand what is happening in the MonitoredDiningPhilosophers code, but
then take a step back and try to consider this problem/solution in real life. By doing
this, you should be able to think of at least one way that you would solve this
problem in real life.

## Submission Instructions ##

Turn in a document with your answers to the questions; feel free to use words, pictures,
etc., to describe your solution, but note that you must submit your solution
electronically (via Canvas, of course).
