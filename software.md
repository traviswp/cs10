---
layout: page
title: "Course Software: Java 7, Eclipse, and JavaCV"
---

## Instructions for installing Java and Eclipse

* [Mac installation instructions](mac_install/mac_install.html)

* [Windows installation instructions](windows_install/windows_install.html)

## (**NEW!**) JavaCV for Mac OSX 10.10.

Note that there is an issue getting the JavaCV software to run on
Macs if you updated to OS X 10.10. If you have updated to Mac OS X 10.10 please
note the following changes to the instructions below:

* Download this zip file: [javacv-0.10-bin.zip](javacv/osx1010/javacv-0.10-bin.zip)

* Unzip the "bin" directory that you downloaded (above), and add the following
  jars to your project (as described  in the JavaCV instructions below): **javacpp.jar**,
  **javacv.jar**, **ffmpeg-[sys].jar**, **opencv-[sys].jar**, and **opencv.jar**

* To test the webcam, save the file [WebcamTest.java](javacv/osx1010/WebcamTest.java)
  (which is different from the version linked below) and drag it to the "src" folder
  in the "cs10" package. If there are red 'x'es, there's an installation problem. Else,
  click the green "go" button to run it, and cross your fingers. As mentioned below,
  if you have any problems, give a should on Piazza.

## JavaCV

*Only proceed with setting JavaCV up if you have installed Java and Eclipse.*

The "video processing" lecture, and a portion of Lab 1, make use of [JavaCV](https://code.google.com/p/javacv/).
It is installed on Sudikoff Lab machines, but you might want to install it on your
machine too. If you have problems, look/post on Piazza, and use the lab machines
until it gets straightened out.

**NOTE:** a newer version of JavaCV is out, but it has not been tested as well as
the version we've used in the past. I've linked to the files you can download below.
If you have trouble with these files, download the most recent files from the
[JavaCV](https://code.google.com/p/javacv/) site and try again. If you still have
problems, see Travis, the graduate TA, or any of the section leaders.

* Download and open / extract the files from these two zip files:
[javacv-0.6-bin.zip](https://code.google.com/p/javacv/downloads/detail?name=javacv-0.6-bin.zip) and
[javacv-0.6-cppjars.zip](https://code.google.com/p/javacv/downloads/detail?name=javacv-0.6-cppjars.zip).

* Go ahead and set up a project named "cs10" to hold the files for this class (if
  you haven't already). Menu "File" — "New..." — "Java Project". Give it a name
  (cs10) and accept the defaults for the other options, and hit the "Finish" button.

* In Eclipse, open up the "cs10" project you created above. Go to menu
  "Project" — "Properties" — "Java Build Path" and select tab "Libraries". [\[screenshot\]](javacv/javacv-jars.png)

* In that panel, click button "Add External JARs..." and add four total JARs
  from the zipfiles. From the "bin" one, add: **javacpp.jar**, **javacv.jar**,
  and **javacv-[sys].jar** (macos, windows, or linux, as appropriate). From the
  "cppjars" one, add: **opencv-[sys].jar** (macos, windows, or linux, as approprate).

* To test the webcam, save the file [WebcamTest.java](javacv/WebcamTest.java) and
  drag it to the "src" folder in the "cs10" package. If there are red 'x'es, there's
  an installation problem. Else, click the green "go" button to run it, and cross
  your fingers. Give a shout on Piazza with problems (after seeing if your questions
  have been answered for someone else).

*NOTE:* If the camera doesn't initialize, just try again -- sometimes it has a hard time getting going. :)
