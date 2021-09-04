/*
PROBLEM STATEMENT

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. 
Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
*/
class Solution {
public:
    void gameOfLife(vector<vector<int>>& grid) 
    {
     vector<pair<int, int>>dis ={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
     int i,j,k, cd, ca;
     int m = grid.size();
     int n = grid[0].size();

     for(int i = 0; i <m;i++)
     {
       for(int j = 0; j <n;j++)
       {
           cd = 0;
           ca = 0;
          for(k=0;k<dis.size();k++)
          {
            int u = dis[k].first;
            int v = dis[k].second;

            int ni = i+u;
            int nj = j+v;
             
            if(ni<0 || nj<0 || ni>=m || nj>=n)
              continue;

              if(grid[ni][nj]&1) 
                  ca++;              
          }
           if( (grid[i][j]&1)  && ca < 2) // under-population
                 grid[i][j] = 1; // 1 => (0 1)
             
             else if( (grid[i][j]&1) && ca > 3) // over-population
             grid[i][j] = 1;    // 1 => (0 1)
			 
             else if( (grid[i][j]&1) && (ca == 2 || ca == 3))  // live next generation
             grid[i][j] = 3;   // 3 (1 1) 
			 
			 else if( !(grid[i][j]&1)  && ca == 3) //  reproduction
             grid[i][j] = 2;  // 2 => (1 0)
    
   }

  }
        
      for(int i = 0; i<m;i++)
     {
       for(int j = 0; j<n;j++)
       {
           grid[i][j] = grid[i][j] >> 1;
       }
      }
}
};
