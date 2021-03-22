package practice.filefilter.basic;

import practice.filefilter.*;

public interface Filter {
    abstract boolean filter(File file, FilterParam fp);
}
