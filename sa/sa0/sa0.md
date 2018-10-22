---
layout: page
title: "Short Assignment 0 &mdash; Due: Wednesday, January 7"
---

This short assignment is a bit wordier than will be typical.  It also
has a lot of technical detail about installing the Eclipse software
and using it.  It is to get you started off.  Future assignments will
be more creative and will require less following of picky
instructions.

## Good things to do to get started

1. Get the textbook from either [the
   publisher](http://www.wiley.com/WileyCDA/WileyTitle/productCd-EHEP002900.html)
   or
   [Amazon](http://www.amazon.com/Data-Structures-Algorithms-Michael-Goodrich/dp/1118771338/ref=sr_1_2?ie=UTF8&qid=1394580262&sr=8-2&keywords=goodrich+tamassia+java).

2. Familiarize yourself with the layout of the CS 10 web site.  All
   materials for the course, other than the textbook, will reside on
   the website, [http://www.cs.dartmouth.edu/~traviswp/cs10/](http://www.cs.dartmouth.edu/~traviswp/cs10/)
   or on the course [Canvas](https://canvas.dartmouth.edu/) site.

## Reading ##

Your textbook, *Data Structures and Algorithms in Java*, 6th edition,
by Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser,
contains a lot of good reading.  Some of it is background information
that you will read very lightly.  Some is more important.  Spend a
little time now to see how the book is laid out.

Remember that the [schedule](../../schedule.html) page tells you what
reading to do before each lecture.

For today and Wednesday, you should read Chapter 1 of the text book which covers
a lot of helpful and interesting details about the Java programming language.

## Exercises ##

Here's what you should do for Wednesday.  Remember that short
assignments are due at 10:00 am.

1. Fill out [this questionnaire](http://goo.gl/forms/44cMMdVUTT) if you haven't already.

2. Fill out both of these forms:

    * [section sign-up](http://tinyurl.com/pe7ot7s)
    * [availability form](http://goo.gl/forms/Gn48uauePC)

    so that we can get you into a recitation section. I know it is weird to fill out two
    forms for this but the second form will help us in the event that our current scheduled
    recitation section offerings (the first form) causes too many issues for people.

    Keep in mind that this sort of runs as first-come-first-serve to don't wait around until
    the last minute to do this!

3. Follow instructions on the [course software page](../../software.html) to Install
   Java 7 and Eclipse on your computer, and get JavaCV.

     Pay careful attention to the instructions.  *Follow them exactly. Do not skip steps.*
     From here on, we'll assume that you have installed the course software correctly.

4. Create a new class called "SA0" that does (at least) two things:

    * Prints out a message with something interesting about you.
    * Displays a relevant image.

     Take a screen shot of your program in action.

## Part 4 Walk-through ##

Here's a step by step guide to problem 4. Just this once! If you're still stuck, post on Piazza.

**NOTE:** My screenshots below show extra projects -- just key in on the actions I take
with regards to the items in the browser pane that are highlighted.

1. Create the SA0 class (this can be in any project you want, but it would make sense
  to put in a "cs10" project or "sa0" project. I create new projects for each of my
  short assignments and labs for organizational purposes. Feel free to do what works best
  for you. Select menu "File" — "New" — "Class". In the dialog, name
  the class "SA0". Leave/make the package blank. (It's indicated as "(default)";
  Eclipse might want you to put it in a "cs10" package, but delete that and ignore
  the warning for now.) Since we want it to have a main() method, check the box for
  that stub. [[screenshot]](resources/1.png)

2. Document the class with your name, term, etc. at the top. Delete the "auto-generated"
  comment, since you'll be filling that in. [[screenshot]](resources/2.png)

3. Use ```System.out.println()``` to print your personal statement. (Let Eclipse
  save you some typing — it'll do everything except the message.)

4. Create a folder, within the main cs10 folder, for storing pictures. Click on "cs10"
  and then select Menu "File" — "New" — "Folder"; make sure the parent folder is "cs10";
  name the new folder "pictures". [[screenshot]](resources/3.png)

5. Drag your chosen picture into that folder. Click on the link for "Configure Drag
  and Drop Settings...". In the panel, for "Drag and drop items on folder or project",
  select the "Copy" radio button, and hit "OK". Eclipse will now make copies of
  imported files. Your file should now be within the "pictures" folder within "cs10".
  (Click on the triangles to expand the folders, and make sure it's there. Also be
  sure you know exactly it's name, capitalization and all.) [[screenshot]](resources/4.png)

6. Similarly, drag into the "src" folder the file "DrawingFrame.java" from the first
  lecture (as an intermediate step, save it in your Downloads or on your Desktop or wherever).

7. Paste into your main() method, below your message, the following bit from the
  main() method in the first class, but edited to have an appropriate picture title
  and the filename you used.

    ```java
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        DrawingFrame gui = new DrawingFrame("UnIcYcLe!", "pictures/unicycle.png");
      }
    });
    ```

    A red "x" error message will show up, until you go up to the very top line of the file and put

    ```java
    import javax.swing.*;
    ```

    (Note that clicking on the "x" will actually present you with a solution — Eclipse can be very helpful.)

8. Run the finished product! To do this, click on "SA0.java". Then go to the Run menu.
  One of the choices is "Run as." The only choice in the continuation menu should be
  "1 Java Application." Select it, which will cause your program to compile (translate
  the Java to an internal form called Java byte code), to link (join up with needed
  libraries), and to run.

9. Take a screenshot. On Mac, you can do that with Preview,
  under the "File" menu. On Windows, the PrntScrn button does that. [[screenshot]](resources/5.png)

## Submission Instructions ##

On Canvas, submit your SA0.java file, your image file, and the screenshot of your program in action.
