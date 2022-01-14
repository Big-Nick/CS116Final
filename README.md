# Object Oriented Programming Final Project

## Example final project for a Java class I both took and was a teaching assistant for

![A really bad, but pretty standard example of a project diagram.](https://github.com/Big-Nick/CS116Final/blob/master/Diagram%20tree.jpg?raw=true "Why are there no arrows? \n Hint, main is in LotterySimulator")

### Requirements

- Multiple examples of inheritance
- At least two enumeration classes
- An abstract superclass with two subclasses
- At least one interface with at least two abstract methods
- Must implement polymorphism
- Must implement overriding a superclass
- At least one class should extend Serializable
- Create an Exception class that provides a restriction
- Event numbers should be sensible and realistic, following a gaussian distribution
- Data for the dealerships, customers, and vehicles must be objects which are recorded into .ser files.
- Main method must read the files to return a data structure
- At least one of each must be used.Array, Vector, and ArrayList
- Proper output must be recorded as output.txt

### CODING INSTRUCTIONS

The class LotterySimulator that has the main method should be in  package : folder1
All  other classes and interfaces should be packaged in folder: folder1.folder2
Make sure that your program generates the required input data (serialized) files.Create separate classes that handle this task.
Inheritance should be used between classes where feasible.

- Polymorphism should be used in the implementation of the draw (method for lotteries) since there are different draw methods depending on the probability used.
- You should have at least one abstract class.The method draw is defined in that abstract class but it gets implemented in 3 different ways , one for each probability type, in 3 corresponding subclasses.
- Make sure that in its implementation it throws the MatchNotFoundException.It goes without saying that this method has a list of valid lottery numbers (numbers have actually been issued to customers) .
- The method keeps track of valid lottery numbers issued so that it does not return a duplicate number again.If a duplicate number comes up the method throws  a RepeatNumberException.
- The number of times each exception is caught is being counted and saved so that it can be written in the output file at the end of the game.
- The draw methods will be invoked using polymorphism in the class with the main method.Notice that  this implementation makes the job of the main method easier because all it has to do is sense that an exception was caught in order to decide that the lottery process needs to be repeated.

To test your program for correct output try first by limiting the lottery events to one event.If the result seems correct, increase the lottery events to allow two cars to be awarded.If that seems correct proceed by allowing 3 or 4 cars to be awarded and check the results.

### PROJECT INSTRUCTIONS

This project is a game based on a lottery used by the vehicle manufacturer (GM) and its car dealerships, that awards free cars to customers as a marketing technique.
There are 5 GM dealerships that have issued lottery tickets to a total of 25 prospective customers.
GM has made available 10 vehicles to be awarded by the dealerships to those customers.
 The customers have been awarded lottery ticket numbers in advance of the lottery process.
 The ticket numbers have been selected by the dealerships and are recorded as part of the customer information.
 The customers have been categorized by the dealerships in various customer types.The process of giving a vehicle to a customer is as follows:
First GM has to assign the vehicle to a dealership.
GM uses a lottery system to award the vehicles to one of the 5 dealerships based on a uniform probability in selecting one of the 5 dealerships each time a car is to be awarded.
The limits of the distribution should be 1 to 5 (int types), where the number 1 represents  dealership Glen Ellyn Chevrolet , the number 2 represents South Suburbs Pontiac, the number 3 represents Chicago Buick, the number 4 represents Schaumburg Cadillac, and the number 5 represents Saturn Of North Chicago.
The selected dealership is given one of the 10 cars from the file Vehicle.ser (this file is explained further down).
The vehicle selected randomly using uniform probability, from the available pool of 10 cars and subtracted from the available list until the list is of zero size.Note: DO NOT AWARD THE CARS SEQUENCIALLY !
 Every time a dealership is selected by GM, the dealership decides on the awarding of the car it received (one of the 10 vehicles is given to that dealership) to a customer.
Notice that the dealership IS NOT restricting the lottery numbers to its own customers only.Any customer (even from another dealership has a chance).
Each dealership, however, uses a lottery probability of their choice to favor or disfavor a certain type of customers (explained under Dealerships below).The dealership draws a number based on certain probability (probabilities are described further down in this document) and tries to match the drawn number to a customers lottery ticket number.If a match is found the customer wins the car.If no match is found :
A MatchNotFoundException occurs (the exception class must be implemented and caught properly in order to receive credit for this functionality).
The process is repeated starting with the GM selecting a new dealership when this exception is thrown.
Count how many times this exception was thrown.
There is only one car to be awarded per customer, therefore the possibility of  coming up with the same winning number more than once exists, in which case the process is also repeated starting with GM selecting a new dealership.
A selection of  a duplicate number causes a RepeatNumber Exception (must implement an exception class and caught it when it happens in order to receive credit for this fumctionality).
The process is repeated starting with the GM selecting a new dealership when this exception is thrown.
Count how many times this exception was thrown.

Generating the Input data
The customers participating in the game are recorded by the program as serializable objects in a file Customer.ser for security reasons (cant be read by a human).Therefore, the customer objects are prepared programmatically and are recorded in a serializable format in the file Customer.ser.The Customer objects can be read off the file Customer.ser when needed and transferred to a data structure of your choice (array, ArrayList or Vector).
The vehicles to be awarded are also recorded by the program as serializable objects in a file Vehicle.ser and read off that file when needed and transferred to a data structure of your choice.
The car dealerships are also recorded as serializable objects in a file Dealership.ser and can be read off that file when needed and transferred to a data structure of your choice.
Therefore you must have the proper classes and methods somewhere that allow you to create these .ser files (besides having the proper serializable service classes).

Vehicles Information:
VehicleTypes are:  FOUR_DOOR_SEDAN, TWO_DOOR_COUPE,  TRUCK, SUV, SPORT, VAN, MINI_VAN, NO_VEHICLE_AWARDED.They are represented by an enumeration.
A vehicle object can have attributes VehicleType, acceleration, velocity, distance, time and other attributes as you determine.
The class must be able to calculate and set the velocity, the distance and the time by having the appropriate methods.Two vehicle objects are equal if  they have the same currentID value.The non default constructor of the class should accept as arguments the VehicleType, the acceleration, the time, the initial velocity and the initial distance of a vehicle.
Each vehicle must have a price associated with it, therefore a price attribute is needed.The actual value of the price will be set in the simulator class when a specific vehicle is drawn.Set the prices as follows (where dnm is the dealership name from the proper enumeration and veh is an object of the service class that represents a Vehicle object ):

'''
if(dnm.equals("Glen Ellyn Chevrolet"))
veh.setPrice(16000);
else if(dnm.equals("South Suburbs Pontiac"))
 veh.setPrice(19000);
  else if(dnm.equals("Chicago Buick"))
veh.setPrice(20000);
else if(dnm.equals("Schaumburg Cadillac"))
veh.setPrice(35000);
else if(dnm.equals("Saturn of North Chicago"))
veh.setPrice(23000);
'''

Vehicles must have their own unique id numbers.
The following vehicles information is used to create Vehicle objects which are then recorded in serializable format in the Vehicles.ser file in the order given (matching the sequence of arguments in the constructor):
FOUR_DOOR_SEDAN, 1, 1, 0, 0
FOUR_DOOR_SEDAN, 2, 1, 0, 0
TWO_DOOR_COUPE, 3, 1, 0, 0
TWO_DOOR_COUPE, 4, 1, 0, 0
TRUCK, 5, 1, 0, 0
TRUCK, 6, 1, 0, 0
SUV, 7, 1, 0, 0
SPORT, 8, 1, 0, 0
SPORT, 8, 1, 0, 0
MINI_VAN, 10, 1, 0, 0
The first information is the VehicleType, the second is the acceleration of the vehicle, the third is the time run (for the purpose of calculating velocity and distance if requested) , the fourth is the initial velocity and the last number is the initial distance.
Notice that the class VehicleA and an extra enum class called ShapeTypes are provided on eth web site, therfor eyou dont have to produce your own code for those two classes.
Customer Information:
Customer Types are: A, B, C, D, E.and they are enumerated in an enumeration class.
A customer object should have the first name, the last name, and the lottery number held by the customer as attributes as a minimum besides other attributes that you may want to include.
These types of customers are classified according to the likely hood of purchasing a vehicle in the future, based on information obtained from a survey:

- A  : means extremely likely to buy a car.
- B  : means somewhat likely to buy a car.
- C  : means neutral as far as buying a car.
- D  : means less likely to buy a car.
- E   : mean unlikely to buy a car.

The lottery numbers are given to the customers as follows:
The first 10 customer objects get the lottery tickets numbers 1 through 10.
 Customer objects 11 through 15 get the lottery tickets 20-24.
Customer objects 16 through 25 get lottery tickets 36 -45.
Every time you create a Customer object and before you write it to the serailizable customer objects file, make sure that you set its CustomerType.
Set the first five customers to type A,
the next 5 to type B,
the next 5 to type C ,
the next 5 to type D
 and the last 5 to type E.
The following information is used to create Customer objects which are then recorded in serializable format in the Customer.ser file in the order given (matching the sequence of arguments in the constructor, first_name, last_name, lottery_num):

- "John1", "Dow1", 1
- "John2", "Dow2", 2
- "John3", "Dow3", 3
- "John4","Dow4", 4
- "John5", "Dow5", 5
- "John6","Dow6", 6
- "John7", "Dow7",7
- "John8","Dow8", 8
- "John9", "Dow9", 9
- "John10","Dow10", 10
- John11, Dow11, 20
- John12,  Dow12, 21
- John13,  Dow13, 22
- John14,  Dow14, 23
- John15,  Dow15, 24
- John16,  Dow16, 36
- John17,  Dow17, 37
- John18, Dow18", 38
- "John19", "Dow19", 39
- "John20","Dow20", 40
- "John21","Dow21", 41
- "John22", "Dow22",42
- "John23", "Dow23", 43
- "John24", "Dow24", 44
- "John25","Dow25", 45
  
Dealership Information:
Dealership Types are (GM products): CHEVROLET, PONTIAC, BUICK, CADILLAC, SATURN and they are also enumerated in an enumeration class.
You can decide on the attributes of a Dealership but the constructor should take as arguments the name of the dealership and the DealershipType.The dealership names can have attain values like Chicago Buick, Glen Ellyn Chevrolet etc (see below).
Each dealership draws a lottery number according to the following probabilities and sets the ticket number accordingly.The probability functions will have to be set with the proper limits based on the descriptions below.Since a non winning number could come up (in other words that number has not been assigned to a customer as a lottery ticket) GM repeats the lottery process by choosing a dealership:
Dealership Chicago Buick uses uniform probability to draw a lottery ticket number.The range is 1 to 40.Therefore there are more numbers than people and vehicles and some numbers are loosing numbers.
Glen Ellyn Chevrolet uses exponential probability.The average is set to favor customers in categories A and B.Remember the position of the customer objects and their types in file People.ser.and their lottery tickets numbers that have been given to them.
Saturn of North Chicago uses Gaussian (normal) probability and the average and the standard deviation is set to favor people of type D and E.
South Suburbs Pontiac uses uniform probability to draw numbers out of a pool of 20 numbers (1-20).
Schaumburg Cadillac uses Gaussian (normal) probability.The average and standard deviation are set to favor customer type A.
The following information is used to create Dealership objects which are then recorded in serializable format in the Dealership.ser file in the order given (name of dealership and the manufacturer of the vehicle that it sells):
Glen Ellyn Chevrolet,    CHEVROLET
South Suburbs Pontiac,   PONTIAC
Chicago Buick,   BUICK
Schaumburg Cadillac,  CADILLAC
Saturn of North Chicago,  SATURN
Note that in the program you can use numbers to represent the dealerships.Thus,
1 is Glen Ellyn Chevrolet
2 is South Suburbs Buick
3 is Chicago Buick
4 is Schaumburg Cadillac
5 is Saturn of North Chicago.
Simulation
There is a class that starts the entire program as a simulator of events.This class has the main method for the program.For uniformity reasons let us all name this class LotterySimulator.This is the class that has the main method.It is important that you follow this name since we are going to try to run your program using the command:
 >java  folder1.LotterySimulator (possibly in an automated way for all submissions).
In general, a simulation consists of a program that keeps track of time.When an event occurs we mark the time the event occurred.Usually the event time is unpredictable.A simulation also has a maximum time for running the simulation program
Our simulator keeps track of time via a counter.Every time there is a drawing that matches the ticket number of a customer we call that a WINNING_EVENT.We store the time (in terms of counts) for that event.Each tick (count) of the counter corresponds to one minute (or any time frame that one wants to associate it with).A lottery ticket is drawn at random times.The sequence of events is as follows:
A time for the lottery event is chosen using uniform probability at random.The time is chosen based on a uniform probability between 1 and 100  time units each lottery with respect to the current time.In other words there is a lottery process once every current-time to current_time+100  time intervals,the actual time chosen with a uniform probability between those two limits.
Suppose that the uniform probability came up with 60 as the time for the first lottery (called EVENT1).The time has to progress, therefore the next time a lottery (for EVENT2) can take place is somewhere between the present time of 61 and the next limit of 61+100=161 time units.Therefore the uniform probability function for the second event will have the limits 61 to 161 and it will give us a number between those limits.If the new number is 150 then that is the time for the second lottery.The third lottery will occur somewhere between 151 and 251 time units, and so on for the rest (in other words the next event always occurs somewhere between 0 and100 time units from the previous event+1).
Lets us call timecount the variable that holds the counter time ticks at the time of the last lottert event +1.
Let us call newtimecount the time that we want the new lottery process to start.
Then the upper limit for the un iform probability function is = timecount+100 and the lower limit is timecount (now).
Therefore we determine the  time for the new lottery event:
newtimecount=(int)(timecount+Math.random()*(100));
Our structure then for allowing the event to occur would be:
if(timecount==newtimecount) {.}
timecount will keep counting the event will take place when the count of timecount reaches the expected event time newtimecount.Notice that we assume that the event (lottery process) happens in zero time.
Up to 10 lottery times can be issued (for the 10 cars) provided that there were no loosing numbers and no duplicated numbers issued.The lottery process is repeated until all 10 cars have been given away.Again, remember that because a customer cant win more than once and also because non winning numbers can be chosen (there are 45 possible ticket numbers but only 25 have been issued), it is very possible that the number of EVENTS can be greater than 10 (extremely unlikely that the events will be exactly 10).
Therefore the lottery process gets repeated when:
There is no customer that holds the particular ticket number.
The ticket number was issued earlier and a car was awarded (no customer can win more than once).

Output
There are two outputs that the user of the program can observe.One is output on the DOS pane and the other is an output text file (name it output.txt).
Besides those two outputs there are 3 .ser files created by the project.One is the Customer.ser, the other is the Dealership.ser and the third is the Vehicles.ser.
In the DOS pane we output:
The EVENT number (drawing event) and the time it took place.
i.e.EVENT1 is taking place at time 4 for car #1
The car type, the price and the vehicle id to be awarded in this EVENT.
The selected dealership by GM for this event.
The type of probability that the selected dealership is going to use to draw a winning ticket.
The lottery ticket number drawn.
Indicate if the number is a winning number or if it is a losing number.If the number has been awarded previously then it is not a winning number.
If it is a winning number indicate the winning customers information i.e.first name , last name etc.
The total price of all cars awarded thus far if the ticket is a winning ticket.
  In a text file called Output.txt:
The output should be written as shown below:
The id of vehicle awarded.
The time and the EVENT #  when  the vehicle was awarded.
The id of the customer that received the vehicle.
The dealership that awarded the vehicle.
Use one line for each set of the above data by creating a table using tabs (/t).
At the bottom of the file write also:
The exception: MatchNotFoundException was thrown _____  times (list the number of tiems the exception was thrown in the blank)

The exception: RepeatNumberException was thrown _____  times (list the number of times the exception was thrown in the blank)

### GRADING INSTRUCTIONS

In order to receive a full grade for the design and the coding of this project youmust follow the guidelines below in designing the project:
1.Must have 3 enumerations and 2 exceptions classes.
2.Must have 3 service classes each representing one of the 3 major categories described in the specification document.These classes must have inherited the proper library class!
3.You must have3 separate classes (one for each category  in item 2 above) whose job is to provide the functionality :

- Create and save the corresponding categorys object in the .ser file.
- Reads the .ser file for that category.
  
4.The project requires implementation of multiple inheritance using the technique described in TASK 1 of Lab 6.Therefore 2 Interfaces are needed for the 3 classes described in item 3 above.The interfaces have methods similar to the methods in item 3 that get implemented by the corresponding Impl classes.
5.Two Impl classes that implement the methods of the 2 interfaces described in item 4.Notice that these 2 classes need to also inherit the 2 out of the 3 classes in item 3 above.
6.An abstract class that directly inherits the 3 rd class out of the 3 described in item 3 above, and also implements the two interfaces described in item 4 above using the corresponding Impl classes objects.This class must have an abstract method called draw !
7.The abstract method draw must implemented by 3 separate classes.Each representing each of the probabilities and using the exception classes as needed.
8.A class that has the name method under the name LotterySimulator.This is the class that brings the entire project together.It should do that by using only objects of the 3 classes described in item 7 above! No other objects are allowed, other than library classes objects.This is a test of the inheritances described in the previous steps !
9.Proper packaging of classes required
