/*
PROBLEM STATEMENT

You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.
You are asked to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed.
Return the coordinates of trees that are exactly located on the fence perimeter.

Example 1:
Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]

Example 2:
Input: points = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
*/

/*
SOLUTION EXPLAINED

The idea of Jarvis’s Algorithm is simple,
We start from the leftmost point (or point with minimum x coordinate value) and we keep wrapping points in counterclockwise direction.
The big question is, given a point p as current point, how to find the next point in output?

The idea is to use cross-product here. Next point is selected as the point that beats all other points at clockwise orientation, i.e., 
next point is q if q is the rightmost point from our current point's perspective.

In this problem, we are trying to draw a boundary around all points such that all points are covered & boundary is minimum.
We start with the leftmost point as the boundary has to go through it and declare it as the starting point. The starting point will be our current tree for first iteration.
Now, we have to find the next rightmost tree with respect to our current tree. Rightmost tree can be understood from the below image.

Here Tree 1 is our current tree and then Tree 2 will be the rightmost tree with respect to Tree 1 (PROBLEM GRAPH)

Topview of trees
For finding which trees are to the right or left we use cross product.

For the current tree, we iterate till we find the rightmost tree.

In some cases, we may get more than one tree. In that situation, the trees will be collinear and the farthest tree is used as our next point. 
This is done by calculating the distance between the collinear points.

Time Complexity: O(n*h), Where n = Total number of points, h = total number of points on boundary
*/
