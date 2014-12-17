#OO Design Problems

1.  Design a Card Game: Design the data structures for a generic deck of cards. Explain how you would sub-class it to implement 
    particular card games: *package cardgame*
    
        Basic Objects: Suit, Card, Deck, Hand, Game, GameAutomator. 
        BlackJackGame: BlackJackCard, BlackJackHand, BlackJackGameAutomator
    
2.  Imagine you have a call center with three levels of employees: Respondent, Manager and Director.
    An incoming telephone call must be allocated to a fresher who is free can’t handle the call, he or she must escalate 
    the call to technical lead not free or not able to handle it, then the call should be escalated to PM. 
    Design classes and data structures for this problem. *package callcenter* 
    
        Basic Objects: Rank, Call, Caller, Employee(Respondent, Manager, Director), CallHandler.
         
3.  Design a musical juke box using object oriented principles. *package jukebox*

        Basic Objects: Song, CD, Playlist, AudioPlayer, Display, JukeBox, User. 

4.  Design a parking lot using OOD. *package parkinglot*

        Basic Objects: VehicleSize, Vehicle(Motorcycle, Car, Bus), ParkingShot, Level, ParkingLot, ParkingSimulator
         
5.  Design the data structures for an online book reader system. *package onlinereader*

        Basic Objects: Book, Library, User, UserManager, Display, OnlineReaderSystem. 
        
6.  Explain how you would design a chat server In particular, provide details about the various backend components, 
    classes, and methods.  What would be the hardest problems to solve? *package onlinechatting*
    
        Basic Objects: User UserStatus/UserStatusType, UserManager, Message, Conversation(GroupChat, PrivateChat), 
        AddRequest/RequestStatus, System
    
7.  Explain the data structures and algorithms that you would use to design an in-memory file system Illustrate 
    with an example in code where possible. *package filesystem*
    
        Basic Objects: Entry(File, Directory), FileSystem

8.  Othello is played as follows:
 
        Each Othello piece is white on one side and black on the other When a piece is surrounded by its opponents on 
        both the left and right sides, or both the top and bottom, it is said to be captured and its color is flipped.
        On your turn, you must capture at least one of your opponent’s pieces The game ends when either user has no more valid moves, 
        and the win is assigned to the person with the most pieces.
        
    Implement the object oriented design for Othello. *package othellogame*
    
        Basic Objects: Color, Piece, Board, Location, Direction, Player, Automator, Game.
        
9.  Design and implement a hash table which uses chaining (linked list) to handle collisions. *package hashtable*

        Basic Objects: Cell<Key/Value>, Hash(LinkedList<Cell<K, V>>[])
        
10. Design a blocking list: Producer put message in the list when list is not full, if full, block producer. 
    Consumer get message from the list when list is not empty, if empty, block consumer.
    
    *HINT: use synchronize and wait/notify, or Lock/Condition, await/signal.*
    
11. Implement CircularArray, having a rotate(int offset) which rotate array to left given offset, for example, [1,2,3,4].rotate(1) = 
    [2,3,4,1], also need have get/set and could visit using for(Item item : array) (which need return a Iterator when call iterator())

    *HINT: rotate using 3-way reverse.*
    
12. Implement BitMap

13. Implement Hanoi Game.

14. Implement LRU Cache.
    
    *HINT: double linked list to maintain the visit sequence, and HashMap to enable O(1) searching.*
    
15. Design a data structure to achieve operation insert, delete, search and random access all in O(1).

    *HINT: Array can insert, random access in O(1), could use to store element. HashMap can insert, delete, search in O(1), 
    could use as index <value, offset>. Logic for delete: get the offset of the value, and put the last element to that offset.
    remember to update the index hashmap.*
    
16. Design a data structure that can implements the following 2 search method in O(lgN)

        1. public V get(K key), return the value which key is key
        2. public List<V> getRange(K key1, K key2) return all the values which key is between key1 and key2
        
    *HINT: BST have good performance to do range search.*
   
17. Implements Multi-Thread of Producer Consumer Problem. 

18. Implements DiningPhilosopher Problem.

        The dinning philosophers problem, a bunch of philosophers are sitting around a circular table with one chopstick 
        between each of them. 
        A philosophers needs both chopsticks to eat, and always picks up the left chopstick before the right one. 
        A deadlock could potentially occur if all the philosophers reached for the left chopstick at the same time. 
        Using threads and locks, implement a simulation of the dining philosopher problem that prevents deadlocks.
    
19. Given a timer time() with nanosecond accuracy and given the interface
            
        interface RealTimeCounter:
            void increment()
            int getCountInLastSecond()
            int getCountInLastMinute()
            int getCountInLastHour()
            int getCountInLastDay()
    
    Implement the interface. The getCountInLastX functions should return the number of times increment was called in the last X.
    
    *HINT: use cyclic buffer persistent the count in every second, and implements get(int distanceFromEnd), 
    so countInLastSecond = buffer.get(0) - buffer.get(1), countInLastMinute = buffer.get(0) - buffer.get(60).
    This data structure could use to do RateLimit for certain period of time.*
    
20. We have a Foo class, it have 3 method, first(), second() and third(), the same instance of Foo will be passed to three 
    different threads. 
    Design a mechanism to ensure that first it called before second and second is called before third.
    
    *HINT: use Semaphore sem = new Semaphore(1), sem.acquire() and sem.release().
    
21-N. Write code to implement a 6 faces Rubik's cube game.


#Design Pattern


