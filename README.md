
Fast Prezi
===================


Provides APIs to get and search presentations.

----------
How to use?
-------------
 **Step 1**- Clone this package in your workspace.

 **Step 2**- Run ```./gradlew run```

 **Step 3**- Open swagger to view the APIs at http://localhost:8080/swagger.
 
 **Step 4**- You can also directly hit the following APIs :-
 
 http://localhost:8080/presentations
 
 http://localhost:8080/presentations/search?title=min
 
 **Step 5**- You can optionally add query parameters like sort=true, page_size and page_number in URL. Default page_size is 20 and page_number starts from 0.