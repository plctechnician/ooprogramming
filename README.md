# Object Oriented Programming (DIEF, UNIMORE)

## Software, Tutorials, Exercises

### Java
* [Java SE Development Kit](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Java SE Tutorial](https://docs.oracle.com/javase/tutorial/), [Java SE API](https://docs.oracle.com/en/java/javase/15/docs/api/index.html) 
* [IntelliJ IDEA](https://www.jetbrains.com/idea/), [IntelliJ IDEA Resources](https://www.jetbrains.com/idea/resources/)

### Python
* [Python Development Kit](https://www.python.org/downloads/)
* [Python Tutorial](https://docs.python.org/3/tutorial/), [Python API](https://docs.python.org/3/library/)
* [PyCharm](https://www.jetbrains.com/pycharm/), [PyCharm Resources](https://www.jetbrains.com/pycharm/learn/)
* [Anaconda](https://www.anaconda.com/products/individual)

### Misc
* https://www.w3resource.com/
* https://www.programiz.com/
* https://exercism.io/
* https://www.baeldung.com/
* http://www.pythontutor.com/
* https://pynative.com/
* https://github.com/mtdvio/every-programmer-should-know
* https://github.com/charlax/professional-programming
* https://github.com/sindresorhus/awesome

## Books
* Head First Java; Sierra, Bates; O'Reilly (intermediate)
* Effective Java; Bloch; O'Reilly (advanced)
* Head First Python; Barry; O'Reilly (intermediate)
* Fluent Python; Ramalho; O'Reilly (advanced)

## Videos
* [YouTube OOP Java](https://www.youtube.com/watch?v=y3H3xwI0prM&list=PLhlcRDRHVUzTruZmXalUSJAK26pouP8ST)
* [YouTube OOP Python](https://www.youtube.com/watch?v=14aWn1OZQzQ&list=PLhlcRDRHVUzR2WHN9VTPZrawqRYHz5ALF)
* [YouTube IntelliJ](https://www.youtube.com/c/intellijidea/videos)
* [YouTube PyCharm](https://www.youtube.com/c/PyCharmIDE/videos)

## Microsoft Teams
Please use Microsoft Teams instead of emails for asking questions and discuss ideas, exercises, and home projects.

## Slides, code examples
Slides, and code examples can be found here and downloaded using git:

> $ git clone https://github.com/nbicocchi/ooprogramming.git

Both slides and code examples might be updated or bug-fixed during the course. At any time, for downloading the latest version, go the course material directory (on your pc) and use:

> $ git pull (in case of errors: git reset --hard; git pull)

## Java Modules
[M1] From Functions to Objects

* Evolution of programming languages
* Limits of procedural programming
* Modularization, reuse of code, and object-oriented programming
* Object-oriented programming key features

[M2] Basics

* Primitive types, variables, constants
* Functions, parameter passing
* Flow control statements
* Strings, arrays, random numbers, terminal i/o 

[M3] Object Oriented Programming

* Classes, objects, packages
* Attributes, methods, visibility
* Constructors, getters/setters, toString()
* Wrapper types
* Inheritance, upcasting, downcasting
* Polymorphism, method overloading/overriding 
* Abstract methods, abstract classes, interfaces
* UML class diagrams

[M4] Data Structures (Collections Framework)

* Collection (Set, Queue, List) interface and its implementations
* Map interface and its implementations
* Iterator and ListIterator (definition and use)
* Sorting and searching

[M5] Generic Data Structures (Generics)

* Array sub-typing
* Object sub-typing
* Collection sub-typing
* Bounded wildcards types

[M6] Functional Interfaces

* Anonymous classes
* Lambda expressions
* Functional interfaces
* Method references

[M7] Exceptions

* Exceptions (checked and unchecked) and Errors
* Catching Exceptions (try/catch/finally)
* Throwing Exceptions (throw)
* Delegation models (complete, partial, no delegation) (throws)

[M8] Multi-threading

* Thread states
* Race conditions
* Basic synchronisation (synchronised/sleep/yield/join)
* Advanced synchronisation (wait/notify)

[M9] Swing Framework

* Structure of Java Swing (interfaces and abstract classes)
* Containers and Components
* Layout management
* Event delegation model

[M10] Data Access (JDBC)

* Database connection architecture
* Connection, Statement and Resultset classes
* Scrollable, Updateable Resultsets
* Connection Metadata

[M11] Data Access (REST)

* Motivations and basic concepts
* Resources, Operations, Representations (JSON, XML)
* GET/POST/PUT/DELETE requests
* Design of a client/server staleless application

[M12] Data Access (I/O Framework)

* InputStream/OutputStream interfaces (binary files)
* Reader/Writer interfaces (text files)
* Tokenizers (Scanner/StringTokeniser classes)
* Filesystem manipulation (File/Files classes)

## Python Modules
[M1] Basics

* The Python environment
* Variables, constants
* Numeric, strings, boolean literals
* Flow control statements
* Functions, parameter passing
* Decorators
* Exceptions
* I/O Basics

[M2] Data Structures

* Iterable, Iterator, Generator
* List, Tuple, Set, Dictionary
* Generator, List, Dictionary Comprehension
* Itertools

[M3] Object Oriented Programming

* Classes, objects
* Getters, setters, properties, decorators
* Encapsulation, inheritance, polymorphism 
* Informal interfaces
* Sorting objects
* Modules and packages

## Exam
During the final exam students are expected:

* to discuss the structure and engineering choices of the home project. It is worth noticing that the project is not supposed to be developed alone without supervision, but mostly during the course. The whole development process and discussions with Dr. Bicocchi will be evaluated.

* to pass an oral examination about Java and Python. Quizzes and short written exercises will be also used for assessing programming skills. 

## FAQ
Should I carefully read and understand this FAQ?
> Yes!

Developing a project at home is the goal of the course?
> **No! The goal is not developing a home project! The goal of the course is learning how to code in Java and Python**. Developing a project is only a (hopefully fun) way to do it.

Can we develop the project in groups of 1 or 3 people?
> No, groups must be composed of 2 people. There are no exceptions. The use of Github for sharing code is mandatory. People unable to find a teammate should post a message on Teams (*Ricerca compagni* channel). Groups should be composed of teammates with comparable coding skills. Exceptions to this rule will be negatively evaluated.

Can we use JavaScript, TypeScript, Kotlin, Dart, Swift, C++, C#?
> No! Only Java and Python are allowed. If you learn properly Java and Python, you will be able to switch to any modern object-oriented language pretty quickly. 

Which kind of project can we do?
> You can code a video game, a managing software, an Android app. See examples in the repository as a reference.

Which IDE should I use for developing an Android app?
> Android Studio is perfect. It is a version of IntelliJ specifically tuned for Android development.

Can we use external libraries?
> Sure! The object oriented paradigm has been initially proposed for promoting the reuse of existing code and building large projects! For example, for developing game [LibGDX](https://libgdx.com/), [Slick2D](https://slick.ninjacave.com/), or [Tiled](https://www.mapeditor.org/) are useful. Conversely, for a managing software use can use [JavaFX](https://openjfx.io/), [Spark](https://sparkjava.com/), [Spring](https://spring.io/).

Can we use a GUI designer?
> Yes, of course! During the course we discussed GUIs in terms of source code only for understanding how they work internally.

How big the project has to be?
> A project comprised of 1000-3000 source lines of code (excluding GUI XML if present) is enough to get the feeling of what developing software means. Projects bigger than 5000 lines (excluding GUI XML if present) are not advised.

What is the best moment for starting the project?
> The first half of the course concerns basic topics that must be assimilated before starting. My personal suggestion is to start the project around midterm and use the second part of the course to sketch out the main design.

While developing I get strange errors. What should I do?
> The first thing to do is copy and paste the error string on Google and check for eventual answers on StackOverflow. The vast majority of common errors has a dedicated page.

If I need help, should I write an email to book an appointment?
> Yes, I will be available every Wednesday morning for chatting.

How does the exam is evaluated?
> The final grade is a subjectively-weighted (Dr. Bicocchi is the subject) average between the home project and the oral examination. 
> The oral examination is composed of theoretical questions about Java and Python and simple quizzes and exercises that anyone that developed a 2000 lines software project is quickly able to solve. The websites reported above, in particular https://www.w3resource.com/ and https://exercism.io/ provide plenty of examples.

Can I get extra bonuses for good behaviours during the course?
> Yes! Even though this repository is maintained mostly by Dr. Bicocchi, it embeds ideas and suggestions that came from students over the years. The best way to propose a change is a **pull request**. 1 accepted **pull request** is worth 0.5 points. No more than 3 points can be accumulated in this way.

Can I get punishments for bad behaviours during the course?
> Of course! The best way to generate suspects on your integrity is showing up at the exam with a nice home project while being unable to answer basic questions about the studied languages! Asking questions which are listed above is not advised as well.
