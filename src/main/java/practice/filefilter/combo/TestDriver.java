package practice.filefilter.combo;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        FilterSystem fs = new FilterSystem();
        List<File> files = new ArrayList<>();
        files.add(new File(1, "Algorithm", 1000));
        files.add(new File(2, "AllFiles", 1000000));
        files.add(new File(3, "Tasks", 10));
        files.add(new File(4, "ObjectOriented", 10000));
        System.out.println("Input files: " + files);

        SizeLowFilter sizeLowFilter = new SizeLowFilter(new FilterParam(100)); // filter size > 100
        SizeHighFilter sizeHighFilter = new SizeHighFilter(new FilterParam(10000)); // filter size < 10000
        SuffixFilter suffixFilter = new SuffixFilter(new FilterParam("Al"));

        /* Suffix = "Al" && 100 < size < 1000000
         * Syntax Tree
         *     AND
         *    /   \
         *  SF    AND
         * "Al"  /   \
         *      LF    HF
         *     100    10000
         */
        FilterTreeNode root = new FilterTreeNode("AND");
        root.left = new FilterTreeNode(suffixFilter);
        FilterTreeNode node1 = new FilterTreeNode("AND");
        root.right = node1;
        node1.left = new FilterTreeNode(sizeLowFilter);
        node1.right = new FilterTreeNode(sizeHighFilter);

        List<File> res = fs.filter(files, root);
        System.out.println("Files with suffix = Al and 100 < size < 10000: " + res);
    }
}
