package practice.packagelocker;

public abstract class Locker {
    protected PkgSize size;
    private final String lockerId;
    private Package curPkg;

    public Locker(String id) {
        this.lockerId = id;
    }

    public String getId() {
        return this.lockerId;
    }

    public boolean isEmpty() {
        return curPkg == null;
    }

    public boolean deliver(Package pkg) {
        if (this.curPkg != null) {
            return false;
        }
        this.curPkg = pkg;
        return true;
    }

    public Package pickUp() {
        Package res = null;
        if (this.curPkg != null) {
            res = this.curPkg;
            this.curPkg = null;
        }
        return res;
    }

    @Override
    public String toString() {
        return this.lockerId + "[" + this.curPkg + "]";
    }
}
