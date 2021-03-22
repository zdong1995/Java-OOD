package practice.filefilter;

import java.util.Date;

public class FilterParam {
    private String suffix;
    private Date update;
    private long size;

    public FilterParam() {
    }

    public FilterParam(String suffix) {
        this.suffix = suffix;
    }

    public FilterParam(Date update) {
        this.update = update;
    }

    public FilterParam(long size) {
        this.size = size;
    }

    public String getSuffix() {
        return suffix;
    }

    public Date getUpdate() {
        return update;
    }

    public long getSize() {
        return size;
    }
}
