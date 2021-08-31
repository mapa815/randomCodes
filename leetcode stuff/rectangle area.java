/*
PROBLEM STATEMENT

Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

Example 1:
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45
Example 2:
Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16
*/
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = Math.abs((ax2-ax1)*(ay2-ay1)) + Math.abs((bx2-bx1)*(by2-by1));
        int ix1=0,ix2=0,iy1=0,iy2=0;
        if(ax1 >= bx1 && ax1 < bx2){                //A has right shift to B and intersects B
            ix1 = ax1;
            ix2 = Math.min(ax2,bx2);
        }else if(bx1 >= ax1 && bx1 < ax2){     //B has right shift to A and intersects A
            ix1 = bx1;
            ix2 = Math.min(ax2,bx2);
        }
        if(ay1 >= by1 && ay1 < by2){               //A has upper shift to B and intersects B
            iy1 = ay1;
            iy2 = Math.min(ay2,by2);
        }else if(by1 >= ay1 && by1 < ay2){     //B has upper shift to A and intersects A
            iy1 = by1;
            iy2 = Math.min(ay2,by2);
        }   
		//if there is no intersection then iX*iY product is zero
        return area - Math.abs((ix2-ix1)*(iy2-iy1));
    }
}
