﻿# EvilPumpkins
Q3 (6/20)

Winnie the Witch loves pumpkins. She spends the Halloween season carving pumpkins and putting a magic spell on them to make them evil. It takes her one hour to carve a pumpkin. She then places the pumpkin in her cellar to allow the spell to take effect, which takes 13 hours. However, there are rats in the cellar that eat the pumpkins. Rats randomly select a pumpkin that has not become evil yet. As soon as they bite a pumpkin, the spell is broken and the pumpkin no longer becomes evil. Each rat eats one pumpkin per day. 
Implement a solution to the Evil Pumpkins problem using Java Monitors. Define a monitor class that records the state of the cellar. Define Java threads for Winnie and for the rats that invoke the appropriate methods on the monitor. Make the number of rat threads easily configurable. 
Copy-paste your tested Java code into the document submitted to TurnItIn. Please use a pretty-printer for the markup.
Project Code
There is a total of 6 classes within the Evil Pumpkins project:

1.	EvilPumpkins – The main class which holds the main method:
2.	TimeKeeper – Due to the time constraints, this method allows easy synchronisation of how long an hour is in milliseconds across the project.
3.	Winnie – The Witch thread. A cellar is created on initialisation and Winnie will carve pumpkins for the cellar.
4.	Pumpkin – The pumpkin class that holds the time created and can be queried to see if it is evil.
5.	Rat – The rat thread that belongs to a cellar. The rat eats a pumpkin every 24 hours.
6.	Cellar – The cellar class that contains the monitor to hold interactions between threads. When initialised, a number of rats are passed in as an argument.
