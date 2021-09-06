/*
PROBLEM STATEMENT

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
*/
class Solution {
public:
    void backTrack(vector<int>& candidates, int start, int remain,
                   vector<int> combination, vector<vector<int>>& res) {
        if (remain == 0) {
            res.push_back(combination);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            if (remain < candidates[i]) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            combination.push_back(candidates[i]);
            backTrack(candidates, i + 1, remain - candidates[i], combination, res);
            combination.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        backTrack(candidates,0, target, {}, res);
        return res;
    }
};
