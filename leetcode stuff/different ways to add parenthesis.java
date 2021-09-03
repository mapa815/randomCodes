/*
PROBLEM STATEMENT

Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. 
You may return the answer in any order.

Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/
class Solution {
    /**
     divide around operands!
     Dont use substrings to create left and right substrings, use indexes! This will not create strings
     add combination of leftList + rightList to finalList
     memoize(0, n)
     
     if finalList size is empty then the expression is a number
    **/
    public List<Integer> diffWaysToCompute(String expression) {
        HashMap<Pair<Integer, Integer>, List<Integer>> mem = new HashMap();
        return diffHelper(expression, 0, expression.length() - 1, mem);
    }
    
    private List<Integer> diffHelper(String s, int start, int end, HashMap<Pair<Integer, Integer>, List<Integer>> mem) {
        Pair<Integer, Integer> key = new Pair(start, end);
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
    
        List<Integer> result = new ArrayList();
        // split around the operand!
        for (int i = start; i <= end; i++) {
            Character curr = s.charAt(i);
            if (curr == '+' || curr == '-' || curr == '*') {
                List<Integer> leftList = diffHelper(s, start, i-1, mem);
                List<Integer> rightList = diffHelper(s, i+1, end, mem);
                
                for (Integer left: leftList) {
                    for (Integer right: rightList) {
                        int total = 0;
                        if (curr == '+') {
                            total = left + right;
                        }
                        else if (curr == '-') {
                            total = left - right;
                        }
                        else if (curr == '*') {
                            total = left * right;
                        }
                        result.add(total);
                    }
                }
            }
        }
        
        // Means no operands present and only a number!
        if (result.size() == 0) {
            Integer num = Integer.parseInt(s.substring(start, end + 1));
            result.add(num);
        }
        
        mem.put(key, result);
        return result;
    }
}
