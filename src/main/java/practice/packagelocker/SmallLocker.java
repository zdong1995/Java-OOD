package practice.packagelocker;

public class SmallLocker extends Locker {
    public SmallLocker(String id) {
        super(id);
        this.size = PkgSize.SMALL;
    }
}
