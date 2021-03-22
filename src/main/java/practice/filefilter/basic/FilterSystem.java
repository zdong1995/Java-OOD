package practice.filefilter.basic;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

import java.util.ArrayList;
import java.util.List;

public class FilterSystem {

    public List<File> filter(List<File> files, Filter filter, FilterParam fp) {
        List<File> res = new ArrayList<>();
        for (File file : files) {
            if (filter.filter(file, fp)) {
                res.add(file);
            }
        }
        return res;
    }
}
