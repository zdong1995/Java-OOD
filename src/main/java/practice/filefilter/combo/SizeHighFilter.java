package practice.filefilter.combo;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

public class SizeHighFilter extends FilterBase {
    public SizeHighFilter(FilterParam fp) {
        super(fp);
    }

    @Override
    boolean filter(File file) {
        return file.getSize() < this.filterParam.getSize();
    }
}
