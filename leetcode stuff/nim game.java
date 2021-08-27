/*
PROBLEM STATEMENT

You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.

Example 1:
Input: n = 4
Output: false
Explanation: These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.
Example 2:
Input: n = 1
Output: true
Example 3:
Input: n = 2
Output: true
*/
public boolean canWinNim(int n) {
    return !(n%4 == 0);
    // *HOW TO FIND THE PATTERN*
    // Notice, if I can send my opponent to a 'losing' position
    // then I can win. A 'losing' position is defined 
    // as a poition where any move I make results in a 'winning' position for the opponent
    
    // 1 ->    win ( i can take 1 and win)
    // 2 ->    win ( i can take 2 and win)
    // 3 ->    win ( i can take 3 and win)
    // 4 ->    lose (i can only send the second player to a winning position 1,2 or 3)
    // 5 ->    win (i can take 1 and send my opponent to 4, a losing position)
    // 6 ->    win (i can take 2 and send my opponent to 4, a losing position)
    // 7 ->    win ( i can take 3 and send my opponent to 4, a losing position)
    // 8 ->    lose ( if i take 1, 2 or 3, my opponent moves to a winning position)
    //          ....apply the above logic till we see a pattern....
    // 9 ->    win
    // 10 ->   win
    // 11  ->  win
    // 12  ->  lose
    // ....etc. etc. it looks like if n is a multiple of 4 we lose
}
