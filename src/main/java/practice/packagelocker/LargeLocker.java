package practice.packagelocker;

public class LargeLocker extends Locker {
    public LargeLocker(String id) {
        super(id);
        this.size = PkgSize.LARGE;
    }
}
