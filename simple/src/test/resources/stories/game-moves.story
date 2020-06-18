 Game Moves


Narrative:
As a gamer
I want to change game parameters
So that I can control the game outcome

Scenario: Forest food gathering at game start

Given a new game
And <gatherers> humans are allocated to forest food gathering
When end turn
Then current population is <population> humans
And population growth rate per turn is <rate> humans/turn

Examples:
| gatherers | population | rate |
|         0 |        7.6 | -0.4
|         1 |        7.7 | -0.3
|         2 |        7.8 | -0.2
|         3 |        7.9 |  0.0
|         4 |        8.0 |  0.0
