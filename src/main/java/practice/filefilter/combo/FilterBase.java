package practice.filefilter.combo;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

public abstract class FilterBase {
    protected FilterParam filterParam;

    public FilterBase(FilterParam fp) {
        this.filterParam = fp;
    }

    abstract boolean filter(File file);
}

/*
Use case:
1. input: List<File>, Args (Filter parameters)
2. output: List<File>

API:
- filterBySize():
- filterByName():
- filterByModifedDate():
- ....

Abstraction:
- Filter -> Abstract Class/Interface
- FilterParam -> Wrapper for all kinds of Filter args
- File -> Class
- Controller/FilterSystem -> Class -> take List<File> and Filter as input, to output List<File>
- FilterSytaxTreeNode

Abstract Class FilterBase {
    FilterParam fp;

    abstract boolean filter(File file);
}

TreeNode {
    String relationOperator; // AND, OR
    FilterBase filter;
}

Sytax Tree
           AND -> Filter class
          /   \
         OR    OR
       /  \   /   \
      F1  F2  F3  F4

Primitive:

for loop: check size > arg ...
 */
