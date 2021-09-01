/*
PROBLEM STATEMENT

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]
*/
class Solution {
public:
    /* this is the driver function of this algorithm, just put the ball roaling and 
    starts the algorithm, uploading the first elements on the next function on the pype */
    vector<vector<int>> permute(vector<int>& nums);
    
    /* this function makes the calculation of the several permutations that must be calculated,
    when there is no more elements in inputNextLevel to be processed then it just returns */
    void permuteRecursive(vector<vector<int>> &v, vector<int> &inputNextLevel, vector<int> &output);
   
};
/*****************************************************************************************************/
vector<vector<int>> Solution::permute(vector<int>& nums) {
    /* this is the driver function of this algorithm, just put the ball roaling and 
    starts the algorithm, uploading the first elements on the next function on the pype */
    /* elements initialization for the next level */
    vector<vector<int>> v;
    vector<int> output;
    /* recursive call for v fulling */
    permuteRecursive(v, nums, output);
    /* return answer */
    return v;
}
/*****************************************************************************************************/
void Solution::permuteRecursive(vector<vector<int>> &v, vector<int> &inputNextLevel, vector<int> &output) {
/* this function makes the calculation of the several permutations that must be calculated,
when there is no more elements in inputNextLevel to be processed then it just returns */
    /* input test */
    size_t size = inputNextLevel.size();
    int numberProcessed{};
    vector<int>::iterator itInput{inputNextLevel.begin()};
    for (size_t i=0; i < size; ++i) {
        /* read number to be processed */
        numberProcessed = inputNextLevel.at(i);
        /* add the number to the vector output */
        output.push_back(numberProcessed);
        /* discard the number recently read from inputNextLevel */
        inputNextLevel.erase(itInput+i);
        /* pick next decision to make */ 
        if (inputNextLevel.size() > 0) {
            /* go one step deeper on the answer stack */
            permuteRecursive(v, inputNextLevel, output);
        } else {
            /* if here then we have no more input to process */
            v.push_back(output);
        }
        /* retrieve the number from the vector output */
        output.pop_back();
        /* insert back the number read on the input vector array */
        inputNextLevel.insert(itInput+i, numberProcessed);
    }
    return; 
}
