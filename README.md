# BringgHW
Bringg homework from Stas

# Overview
HW contains two tasks as follows:
1) Selenium task.
2) Java OOP/logic task.

# Prerequisites
It's a Maven project.
    In case of an older version of IntelliJ is used, Apache Maven plugin should be downloaded and placed under the "c:\\" drive (not higher than version 3.4).
    IntelliJ might not recognise it right away, so it needs to be pointed out to, by selecting a correct version and directory under the File=>Settings=>maven=>"maven home page" section.
    If relatively new version of IntelliJ is used, it might take care of the Maven setup by itself.
    In case it does not, go to the File=>Settings=>maven=>"maven home page" and point it out to the relevant Apache plugin, if it's not there, download it and then point it out, as described above.
    In case some of library's imports are coloured in RED, reload the Maven.

To use selenium chrome driver, it must be downloaded and placed under "C:\\" drive.
    Selenium driver's version must match the Chrome Browser version used by the host machine.
    You can find <chromedriver.exe> version 96 under "BringgHW\src\main\resources" of the project.
    Please take it and place under your "C:\\" drive.
    In case you use an older version of Chrome browser, either update it to the 96 version or download relevant <devicedriver.exe> and place it as described above.

As an INPUT for both selenium and java Tasks first Test (with displayName "Preconditions") is used. 
    Please, update it to check different input cases. (if needed)
    
# Test Classes to execute/run test flows are located under the /src/test/java package 



# Tasks related comments
* Selenium Task
  There are few improvements to be made in this section.
    1) Each Web Element Type (text field, button, dropdown, table switch button etc.) should better have its own class implementation.
       This class would include all relevant methods.
       It could be instantiated by different types of selectors and only then used by handler methods.
    2) There are a few improvements to selenium related driver usage:
       e.g.  A support for a multiply browsers.
       It surely could be located/implemented in a separate repo and brought in as a Maven artifact.
  
* Java Task
  The C section in the <Java Question> requires to "mandatory use section B", while there is nothing in its context suggesting on section B usage.
  Here is the C section question as it appears in the original DOC:
  C. Write down a method that gets a linked list of all the groups, the name of the largest group
  must be printed for each site, it is mandatory to use section B.
  It says that method gets "a linked list of all the groups".
  It does not say that it should get "all groups ready to book a site, in terms of capacity".
  So, there was no need to use section B in the solution of section C.
  If there would be, I would just send filtered groups list to the method in section C :)) and it would also work.

And NO, I was not able to solve the B section by myself, in terms of logical solution.
I’ve found some solution of a similar type on the internet and adapted it to my needs.

# testNG
There are many testNG related improvements for sure (I’ve never used it before).
I’ve just used it to run test flows currently.
The better idea would be to represent each step by one specific action and not by the entire flow(set of actions).

P.S. in case any questions regarding solutions(or any others) arise, 
    please feel free to contact me @052-8802095 (Stas)
