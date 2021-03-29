package practice.packagelocker;

public class Package {
    private String id;
    private PkgSize size;

    public Package(String id, PkgSize size) {
        this.id = id;
        this.size = size;
    }

    public PkgSize getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
