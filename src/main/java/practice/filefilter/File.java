package practice.filefilter;

import java.util.Date;

public class File {
    private final int id;
    private final String name;
    private Date lastModify;
    private final long size;

    public File(int id, String name, long size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public Date getLastModify() {
        return lastModify;
    }

    @Override
    public String toString() {
        return "{File" + id + ": " + name + ", size=" + size + "}";
    }
}
