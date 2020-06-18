 Game Moves


Narrative:
As a gamer
I want to change game parameters
So that I can control the game outcome

Scenario: Forest food gathering at game start

Given a new game
And 4 humans are allocated to forest food gathering
When end turn
Then current population is 8 humans
And maximum population is 12 humans
And population growth rate per turn is 0.0 humans/turn
