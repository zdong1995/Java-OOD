package practice.packagelocker;

public class MediumLocker extends Locker {
    public MediumLocker(String id) {
        super(id);
        this.size = PkgSize.MEDIUM;
    }
}
