VehicleFilter-Parsing
=====================

As a web developer, I often deal with large amounts of data that needs to be formatted in a certain way. For a particular client, he had a text file containing data of vehicle parts that needed to be imported through a filtering plugin, but the filtering plugin did not accept range of values for years.

For example, here is the first line in his text file:
```
7500	2003-2006	Chevrolet	Silverardo 1500/2500/3500 Crew Cab front captain seat with armrest, power driver seat, manual passenger seat
```

The range of years years needed to be broken down into individual lines, while keeping all other information the same:
```
7500	2003	Chevrolet	Silverardo 1500/2500/3500 Crew Cab front captain seat with armrest, power driver seat, manual passenger seat
7500	2004	Chevrolet	Silverardo 1500/2500/3500 Crew Cab front captain seat with armrest, power driver seat, manual passenger seat
7500	2005	Chevrolet	Silverardo 1500/2500/3500 Crew Cab front captain seat with armrest, power driver seat, manual passenger seat
7500	2006	Chevrolet	Silverardo 1500/2500/3500 Crew Cab front captain seat with armrest, power driver seat, manual passenger seat
```

As you can see, this would be very tedious and time consuming to do manually. Here is another different case of the data needing to be formatted.

```
7005	2006+	Dodge	Magnum Base/SXT 
```

Turned into this:
```
7005	2006	Dodge	Magnum Base/SXT 
7005	2007	Dodge	Magnum Base/SXT 
7005	2008	Dodge	Magnum Base/SXT 
7005	2009	Dodge	Magnum Base/SXT 
7005	2010	Dodge	Magnum Base/SXT 
7005	2011	Dodge	Magnum Base/SXT 
7005	2012	Dodge	Magnum Base/SXT 
7005	2013	Dodge	Magnum Base/SXT 
7005	2014	Dodge	Magnum Base/SXT 
7005	2015	Dodge	Magnum Base/SXT
```

In order to solve the problem in an efficient and systematic way, I created a lightweight Java program to automatically identify all formatting problems and correct them.

Here it is :)
