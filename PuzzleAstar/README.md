8_puzzle_Astar
==============

This is an Eclipse Project. To import the project:  

File->Import->Existing Projects into Workspace->Browse->Finish 


This is a JAVA implementation for the 8 puzzle problem using the A* algorithm. 
It was developed as part of an Artificial Intelligence course. It supports a 
GUI making it easy for users to enter the problem they want to solve. 
Furthermore, a simple animation demonstrates the solution of the puzzle.

The A* Algorithm utilizes the following heuristics:

a) Misplaced Tiles. This heuristics counts the number of misplaced tiles
   comparing the current puzzle state with the final state (solution)
   
b) Euclidean Distance is the distance between two tiles that one would 
   measure with a ruler, and is given by the Pythagorean formula.
   
c) The distance between two tiles in a grid based on a strictly horizontal 
   and/or vertical path (that is, along the grid lines), as opposed to the 
   diagonal or "as the crow flies" distance. 
   
d) Linear Conflict Tiles Definition: Two tiles tj and tk are in a linear 
   conflict if tj and tk are in the same line, the goal positions of tj 
   and tk are both in that line, tj is to the right of tk and goal position 
   of tj is to the left of the goal position of tk.
   
e) Tiles out of row and column:h = This heuristics counts the number of 
   tiles out of row + number of tiles out of column.
   
An excellent survey on Heuristics for the N-Puzzle problem can be found
at:
http://heuristicswiki.wikispaces.com/N+-+Puzzle
