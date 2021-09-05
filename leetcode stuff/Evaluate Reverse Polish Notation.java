/*
PROBLEM STATEMENT

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. 
That means the expression would always evaluate to a result, and there will not be any division by zero operation.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
*/
// Stack Solution
// Time Complexity O(n)
// Space Complexity O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        
        int toPush, second;
        Stack<Integer> numStack = new Stack<Integer>();
        
        for (int i=0; i<tokens.length; i++) 
        {    
            switch (tokens[i]) {
                case "+": toPush = numStack.pop() + numStack.pop();
                    break;
                case "*": toPush = numStack.pop() * numStack.pop();
                    break;
                case "-":
                    second = numStack.pop();
                    toPush = numStack.pop() - second;
                    break;
                case "/": 
                    second = numStack.pop();
                    toPush = numStack.pop() / second;
                    break;
                default:  toPush = Integer.parseInt(tokens[i]);
            }
            numStack.push(toPush);
        }
        return numStack.pop();
    }
}
