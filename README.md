# OOP-Project-3

This is also included in the zip file but I sometimes do not see READMEs appearing in eclipse so I decided to include it

Because that is how I built and ran that project and would reccomend running it - open it up in Eclipse or another IDE and run the Main file in course.oop.application

I will now go through the rubric and explaion how everything is implemented:

In the first screen you enter the number of players and timeout. If you enter anything other than 1 or 2 players, it will not progress. If you do not enter an integer for the timeout, it will not progress. A negative timeout is really just a 10,000 second one.

The next screen will show one or two places to enter in players depending on your selction in the previous screen, as well as a list of all players that have played and their records. If you want to use one, type their name and marker in. You must type in something for their marker, but if you type it wrong it will use the one on record. Leaving any field blank will cause the page to not go to the next screen until you have put something in.

From there, it is pretty straight foward. You play tictactoe and a clapping sound is played when the game is over.

A note on timeout: I was having trouble getting the timer to not block the UI. It simply checks when you select an option if the timer since your last action has expired. If it has, it switches to the other players turn. So if you play the computer in a low timeout and wait a while - nothing happens until you click and then it will say you took too long so your move was forfeited and the computer will move.

From my research, emojis can be very difficult to implement on macs. I went ahead and added the code to hopefully get it working on windows - embedding a font that supports them and using them as a test. Being on a mac I could not see if that is correct but I hope it works out.

Quitting will close the window. 