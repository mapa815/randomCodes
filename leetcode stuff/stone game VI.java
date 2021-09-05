/*
PROBLEM STATEMENT

Alice and Bob take turns playing a game, with Alice starting first.
There are n stones in a pile. On each player's turn, they can remove a stone from the pile and receive points based on the stone's value. 
Alice and Bob may value the stones differently.

You are given two integer arrays of length n, aliceValues and bobValues. 
Each aliceValues[i] and bobValues[i] represents how Alice and Bob, respectively, value the ith stone.

The winner is the person with the most points after all the stones are chosen. If both players have the same amount of points, the game results in a draw. 
Both players will play optimally. Both players know the other's values.

Determine the result of the game, and:

If Alice wins, return 1.
If Bob wins, return -1.
If the game results in a draw, return 0.
 

Example 1:
Input: aliceValues = [1,3], bobValues = [2,1]
Output: 1
Explanation:
If Alice takes stone 1 (0-indexed) first, Alice will receive 3 points.
Bob can only choose stone 0, and will only receive 2 points.
Alice wins.

Example 2:
Input: aliceValues = [1,2], bobValues = [3,1]
Output: 0
Explanation:
If Alice takes stone 0, and Bob takes stone 1, they will both have 1 point.
Draw.

Example 3:
Input: aliceValues = [2,4,3], bobValues = [1,6,7]
Output: -1
Explanation:
Regardless of how Alice plays, Bob will be able to have more points than Alice.
For example, if Alice takes stone 1, Bob can take stone 2, and Alice takes stone 0, Alice will have 6 points to Bob's 7.
Bob wins.
*/
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        //the max of aliceValues[i] + bobValues[i] is the most optimal move 
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<Integer> a;
        //here score is aliceValues[i] + bobValues[i]. Score as key and index as value. Put them
        //into tree map
        int score = 0;
        for (int i=0; i<aliceValues.length; i++) {
            score = aliceValues[i]  + bobValues[i];
           
            if (map.containsKey(score)) {
                a = map.get(score);
               
            } else {
                a = new ArrayList<>();
            }
            a.add(i);
            map.put(score, a);
        }
        //use turn to decide if it is alice's move
        int turn = 0;
        int aScore = 0;
        int bScore = 0;

        for (int k: map.descendingKeySet()) {
            a = map.get(k);
            
            for (int i=0; i<a.size(); i++) {
                turn++;
                
                if (turn%2 !=0) {
                    //alice turn
                    aScore = aScore + aliceValues[a.get(i)];
                } else {
                    //bob turn
                    bScore = bScore + bobValues[a.get(i)];
                }
            }
        }
        return aScore==bScore ? 0 : (aScore > bScore ? 1: -1);
    }
}
