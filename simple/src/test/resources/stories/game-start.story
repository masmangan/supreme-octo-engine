 Game Start


Narrative:
As a gamer
I want to check start game parameters
So that I can play my first move

Scenario: Population at game start

Given a new game
Then current population is 8 humans
And maximum population is 12 humans
And population growth rate per turn is -0.4 humans/turn


Scenario: Food at game start

Given a new game
Then every 20 food units adds 1 human
And food growth per turn is -8 food units/turn
And food consumed per turn is 8 food units/turn
And food from forests per worker is 2.4 food units/gatherer
And food from savanna per worker is 0 food units/hunter
And food from rivers per fisherman is 0 food units/fisherman
And food from fields per farmer is 0 food units/farmer

Scenario: Production at game start
	
Given a new game
Then production growth per turn is 1.6 production units/turn
And production total points is 0
And passive production points per turn is 1.6
And production from mountains per turn is 0 

Scenario: Culture at game start
	
Given a new game	
Then culture growth per turn is 1.6
And total culture is 0
And culture needed for next level is 5
And technology level is 1
And passive culture per turn is 1.6
And culture from worshipping per turn is 0
	
Scenario: Date at game start

Given a new game
Then current turn is 1
And date is -4000000
And age is Antiquity

Scenario: Strength at game start

Given a new game
Then strength level is 8
And chance of invasion is 0 %
And strength bonus is 0 %