package practice.filefilter.basic;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

public class SuffixFilter implements Filter {
    @Override
    public boolean filter(File file, FilterParam fp) {
        if (file == null || file.getName() == null || fp == null || fp.getSuffix() == null) {
            return false;
        }
        String fileName = file.getName();
        String suffix = fp.getSuffix();
        if (fileName.length() < suffix.length()) {
            return false;
        }
        for (int i = 0; i < suffix.length(); i++) {
            if (fileName.charAt(i) != suffix.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
