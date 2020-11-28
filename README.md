# Airline-Ticket-Reservation-System
This is a Airline Ticket Reservation System written using Java Swing and Object-Oriented Programming Concepts.

DESCRIPTION:
  1. Design and implement an airplane ticket reservation system for NewBorn Airline. The NewBorn Airline has two airplanes that fly between Greensboro and Queens every day. One departures at 10:00 Am and arrive Queens at 11:30 AM. Another departures at 2:00 PM and arrives Queens at 3:30PM. Each airplane provides three types of airplane tickets. Economy class allows a passenger to select a window or aisle seat. Business class allows a passenger to select a window or an aisle seat, and select a snack. The snack can be cookies or nuts. First class provides all services Business class provided; pluses a passenger can have a bottle wine. This system should allow an agent to input a customer name, starting city and destination, flight number, class selected, departure date and time. It will display all information on the screen. Use single inheritance to implement this system.

1)	An interface should be developed to allow an agent to input required information. 
2)	A constructor sets the number of seats.
3)	A person reserves a ticket via ReserveTicket method. This method returns related seat information. If a customer tries to reserve a seat but all seats are sold out an error message should be displayed.
4)	If a customer reserved a seat the person’s name, departure date, flight number and total charge should be displayed. 
5)	Single inheritance must be used to demonstrate the concept of inheritance. 

  2. Design and implement a TC Airplane Ticket Purchase System for Test Company. This company operates two airplanes on daily basis. The airplane TC 200 departs from Greensboro at 10:00 AM and arrives Newark at 11:30 AM. The airplane TC 400 departures from Newark at 4:00 PM and arrive Greensboro at 5:30 PM. An airplane has a finite number of seats. A person must purchase a ticket before taking the airplane. The ticket should include a person’s name, flight number, travel date and time. The TC Airplane Ticket Purchase System must satisfy the following requirements:

1)	A constructor sets the number of seats.
2)	A method TCAirplanefull to check if there are any seats available.
3)	A person purchases a ticket via PurchaseTicket method. This method returns an integer indicating the row number and a character indicating the seat that could be A, B or C. If a customer tries to buy a ticket but all tickets are sold out an TCAirplaneFull exception will be thrown.
4)	 TCAirplaneFull must have an exception handler that should display “The airplane is full!”.
5)	If a customer bought a ticket the person’s name, flight number, travel date, time and seat number should be displayed, 
6)	If a customer returned a ticket this seat will be available. 

  

KEY CONCEPTS
  1. This Airline Ticket Reservation GUI displays inheritance between the types of airline classes such as First Class, Business Class, and Economy Class. One will inherit the inevitably inherit a characteristic from the other in a hierarchical type of way.
