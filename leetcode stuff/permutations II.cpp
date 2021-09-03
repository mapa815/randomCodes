/*
PROBLEM STATEMENT


*/
class Solution {
public:
    /* this is the driver function of this algorithm, just put the ball rolling and 
    starts the algorithm, uploading the first elements on the next function on the pipe */
    vector<vector<int>> permuteUnique(vector<int>& nums);
    
    /* this function makes the calculation of the several permutations that must be calculated,
    when there is no more elements in inputNextLevel to be processed then it just returns */
    void permuteRecursive(vector<vector<int>> &v, vector<int> &inputNextLevel, vector<int> &output);
   
    /* this function returns the next index from the vector inputNextLevel that contains an element
    that is different from the element stored at position i */
    size_t getNextIndex(vector<int> &inputNextLevel, size_t &i, size_t &size);
};
/*****************************************************************************************************/
vector<vector<int>> Solution::permuteUnique(vector<int>& nums) {
    /* this is the driver function of this algorithm, just put the ball rolling and 
    starts the algorithm, uploading the first elements on the next function on the pipe */
    /* elements initialization for the next level */
    vector<vector<int>> v;
    vector<int> output;
    /* sort input array */
    sort(nums.begin(), nums.end());
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
    for (size_t i=0; i < size; i=getNextIndex(inputNextLevel, i, size)) {
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
/*****************************************************************************************************/
size_t Solution::getNextIndex(vector<int> &inputNextLevel, size_t &i, size_t &size) {
    /* this function returns the next index from the vector inputNextLevel that contains an element
    that is different from the element stored at position i */
    int val{inputNextLevel.at(i)};
    for (size_t k = i+1; k < size; ++k) {
        if (inputNextLevel.at(k) != val) {
            return k;
        }
    }
    /* if it reaches here then it was not found another different value, starting at i+1, agains the value at i position */
    return size; 
}
