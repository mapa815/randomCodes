/*
PROBLEM STATEMENT

You are given a tree with n nodes numbered from 0 to n - 1 in the form of a parent array parent where parent[i] is the parent of the ith node. 
The root of the tree is node 0, so parent[0] = -1 since it has no parent. You want to design a data structure that allows users to lock, unlock, and upgrade nodes in the tree.

The data structure should support the following functions:

Lock: Locks the given node for the given user and prevents other users from locking the same node. You may only lock a node if the node is unlocked.
Unlock: Unlocks the given node for the given user. You may only unlock a node if it is currently locked by the same user.
Upgrade: Locks the given node for the given user and unlocks all of its descendants. You may only upgrade a node if all 3 conditions are true:
The node is unlocked,
It has at least one locked descendant (by any user), and
It does not have any locked ancestors.
Implement the LockingTree class:

LockingTree(int[] parent) initializes the data structure with the parent array.
lock(int num, int user) returns true if it is possible for the user with id user to lock the node num, or false otherwise. 
If it is possible, the node num will become locked by the user with id user.
unlock(int num, int user) returns true if it is possible for the user with id user to unlock the node num, or false otherwise. 
If it is possible, the node num will become unlocked.
upgrade(int num, int user) returns true if it is possible for the user with id user to upgrade the node num, or false otherwise. 
If it is possible, the node num will be upgraded.
*/
class LockingTree {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] parent;
    public LockingTree(int[] parent) {
        this.parent = parent;
    }
    
    public boolean lock(int num, int user) {
        if(map.containsKey(num)) return false;
        map.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!map.containsKey(num)) return false;
        if(map.get(num) == user) {
            map.remove(num);
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
		// first condition: check if node is already locked
        if(map.containsKey(num)) 
            return false;
		// second condition: check if any of the node's ancestors are already locked
        int par = parent[num];
        while(par != -1) {
            if(map.containsKey(par)) 
                return false;
            par = parent[par];
        }
		// third condition: check if a node has any locked descendants
        boolean found = false;
        List<Integer> descendants = new ArrayList<>();
		// loop through all locked nodes
        for(int key: map.keySet()) {
            found = false;
            int p = parent[key];
            List<Integer> l = new ArrayList<>();
            l.add(key);
			// move up the tree using parent array
            while(p != -1) {
				// keep adding nodes along the path in case this path ends up containing locked descendant
                l.add(p);
				// if you reach the current node it means that this current path contains a descendant
                if(p == num) {
                    found = true;
                    break;
                }
                p = parent[p];
            }
			// if you found a descendant add all nodes along the path into a descendants list
            if(found) 
                descendants.addAll(l);
        }
		// if we found any descendants remove them from the map and return true
        if(descendants.size() > 0) {
            for(int n: descendants)
                map.remove(n);
            map.put(num, user);
            return true;
        }
        return false;
    }
}
