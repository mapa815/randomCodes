/*
PROBLEM STATEMENT

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
*/
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(small.isEmpty() && large.isEmpty()){
            small.add(num);
            findMedian();
            return;
        }
        
        if(small.size() > large.size()){
            if(num > small.peek()){
                large.add(num);
            }else{
                large.add(small.poll());
                small.add(num);
            }
        }else{
            if(num < large.peek()){
                small.add(num);
            }else{
                small.add(large.poll());
                large.add(num);
            }
        }
        
        findMedian();
    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            return (small.peek() + large.peek())/2.0;
        }else{
            return small.peek();
        }
    }
}
