# Objective

## To Automate online transactions of digital Game

### Problem Statement ### 

### DigitalCom is a leading retailer of game selling. 
Their Current Business need is to leverage opportunities in online trade across north and south zone. Develop a portal  

Following are the broader task

Part 1
1.	Register new user and authenticate 
2.	Provide search option based on criteria

Part 2
3.	Store details in personalized basket
4.	Retrieve  various reports

##### Main Menu with the below options

** Register

** Login


** List all Games   --- menu related to user

** Search using Game name  -- user menu

** Search using Author -- user menu

** View Basket -- user menu



** Reports – To be accessed only by admin

** Exit


#### Classes & Interfaces
 
User class: 


** Interface Inter_validate , with below Methods

** Static boolean IsAuthenticated(String userid,String password,String usertype) –to check credentials 

** default log method , to log as soon as the user/admin access menus



Interface inter_data  . Declare a Constant array with the below value

Gamelist 

**  Array {{"Tubix","Danny",300},{"FreshFood","Ram",450},{"Batman","Kate",400},{"Pacman","Steeve",600}, {"YammyTommy","Narayan",350}};



**  Order : arraylist








## Transaction ##

#### Register & Login ####

** Class : User 

**  Attirbutes : userid , password, usertype (Usertype should be user or admin) Admin user, password to be finalized as PASSWORD


** addUser(String userid,String password,String usertype) -> to get the values and initialize user.


** Login() – to use IsAuthenticated method of interface and validate


** On successful login,  Menu related to user to be displayed


### String displayMenu(char num) 

** This Method should get the choice and call the transactions accordingly
** Example : displayMenu(1) – should call authorSearch() method
** Display INVALID CHOICE, if the choice is not mapping.



### viewAll() 

** should return all gamenames and author name 


### String authorSearch(String sear) 

** Method should get the authorname and returns the Gamename
** Example 
** authorSearch(“Ram”) Should return FreshFood
** Display NOT FOUND, if the given author name doesn’t exist
** userid,gamename and author should be added as a list element in Order List

### String gameSearch(String bk) 

** Method should Get the gamename and returns the authorname
** Example
** gameSearch(“Tubix”) should return Danny
** Display NOT FOUND , if the given gamename name doesn’t exist
** userid,gamename and author should be added as a list element in Order List


### ViewBasket
** To display the list of games



