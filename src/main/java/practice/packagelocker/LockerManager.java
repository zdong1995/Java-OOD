package practice.packagelocker;

import java.util.*;

public class LockerManager {
    private final int SIZE = 3; // for extension
    private List<List<Locker>> lockerLists;

    public LockerManager(int smallNum, int mediumNum, int largeNum) {
        lockerLists = new ArrayList<>(SIZE);
        // build small, medium, and large respectively
        List<Locker> smallLockers = new ArrayList<>();
        for (int i = 0; i < smallNum; i++) {
            smallLockers.add(new SmallLocker("S-" + i));
        }
        lockerLists.add(smallLockers);

        List<Locker> mediumLockers = new ArrayList<>();
        for (int i = 0; i < mediumNum; i++) {
            mediumLockers.add(new MediumLocker("M-" + i));
        }
        lockerLists.add(mediumLockers);

        List<Locker> largeLockers = new ArrayList<>();
        for (int i = 0; i < largeNum; i++) {
            largeLockers.add(new LargeLocker("L-" + i));
        }
        lockerLists.add(largeLockers);
    }


    /**
     * return locker id of appropriate locker based on input package
     */
    public String findByPkg(Package pkg) {
        // small: search S -> M -> L
        // medium: search M -> L
        for (int size = pkg.getSize().getValue(); size < SIZE; size++) {
            List<Locker> lockers = lockerLists.get(size);
            for (Locker locker : lockers) {
                if (locker.isEmpty()) {
                    return locker.getId();
                }
            }
        }
        return null;
    }

    public boolean delivery(Package pkg) {
        if (pkg == null) {
            return false;
        }
        return delivery(pkg, findByPkg(pkg)); // corner case been handled in helper function
    }

    public boolean delivery(Package pkg, String lockerId) {
        if (lockerId == null || pkg == null) {
            return false;
        }
        Locker locker = findLockerById(lockerId);
        return locker.deliver(pkg);
    }

    public Package pickUp(String lockerId) {
        if (lockerId == null) {
            return null;
        }
        Locker locker = findLockerById(lockerId);
        return locker.pickUp();
    }

    private Locker findLockerById(String lockerId) {
        if (lockerId == null) {
            return null;
        }
        String[] strs = lockerId.split("-");
        int lockerIdx = Integer.parseInt(strs[1]);
        if (strs[0].equals("S") && lockerIdx < lockerLists.get(0).size()) {
            return lockerLists.get(0).get(lockerIdx);
        } else if (strs[0].equals("M") && lockerIdx < lockerLists.get(1).size()) {
            return lockerLists.get(1).get(lockerIdx);
        } else if (strs[0].equals("L") && lockerIdx < lockerLists.get(2).size()) {
            return lockerLists.get(2).get(lockerIdx);
        } else { // invalid locker id
            return null;
        }
    }

    @Override
    public String toString() {
        return lockerLists.toString();
    }
}
