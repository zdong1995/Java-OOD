package practice.filefilter.basic;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

public class SizeFilter implements Filter{
    @Override
    public boolean filter(File file, FilterParam fp) {
        return file.getSize() > fp.getSize();
    }
}
