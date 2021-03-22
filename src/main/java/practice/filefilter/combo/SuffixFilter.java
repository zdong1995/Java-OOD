package practice.filefilter.combo;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

public class SuffixFilter extends FilterBase {
    public SuffixFilter(FilterParam fp) {
        super(fp);
    }

    @Override
    public boolean filter(File file) {
        if (file == null || file.getName() == null) {
            return false;
        }
        String fileName = file.getName();
        String suffix = this.filterParam.getSuffix();
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
