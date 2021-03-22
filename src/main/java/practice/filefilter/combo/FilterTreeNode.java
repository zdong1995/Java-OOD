package practice.filefilter.combo;

import practice.filefilter.File;

public class FilterTreeNode {
    public FilterTreeNode left;
    public FilterTreeNode right;
    private final FilterBase filter;
    private final String relationOptr;

    public FilterTreeNode(FilterBase filter) {
        this.filter = filter;
        this.relationOptr = null;
    }

    public FilterTreeNode(String relationOptr) {
        this.filter = null;
        this.relationOptr = relationOptr;
    }

    /**
     * Determine whether one node is Filter or Relation Operator
     */
    public boolean isFilter() {
        return this.filter != null;
    }

    public boolean eval(File file) {
        // base case
        if (this.isFilter()) { // leaf node will be filter
            return this.filter.filter(file);
        }
        // recursion to eval left and right subtree
        boolean left = this.left.eval(file);
        boolean right = this.right.eval(file);
        // determine relation result
        if (this.relationOptr.equals("AND")) {
            return left && right;
        } else if (this.relationOptr.equals("OR")) {
            return left || right;
        } else {
            throw new IllegalArgumentException("Invalid relation operator");
        }
    }
}
