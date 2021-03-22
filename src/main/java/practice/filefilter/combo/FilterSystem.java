package practice.filefilter.combo;

import practice.filefilter.File;

import java.util.ArrayList;
import java.util.List;

public class FilterSystem {
    public List<File> filter(List<File> files, FilterTreeNode root) {
        List<File> res = new ArrayList<>();
        for (File file : files) {
            if (root.eval(file)) {
                res.add(file);
            }
        }
        return res;
    }
}
