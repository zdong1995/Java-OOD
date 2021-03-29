package practice.packagelocker;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        LockerManager lockerManager = new LockerManager(5, 2, 3);
        // create a list of packages
        List<Package> smallPkgs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            smallPkgs.add(new Package("S" + i, PkgSize.SMALL));
        }
        List<Package> mediumPkgs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mediumPkgs.add(new Package("M" + i, PkgSize.MEDIUM));
        }
        List<Package> largePkgs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            smallPkgs.add(new Package("L" + i, PkgSize.LARGE));
        }
        // deliver pkg into lockers
        for (int i = 0; i < 3; i++) {
            lockerManager.delivery(smallPkgs.get(i));
        }
        System.out.println("Deliver 3 Small Packages:");
        System.out.println(lockerManager);
        for (int i = 0; i < 2; i++) {
            lockerManager.delivery(mediumPkgs.get(i));
        }
        System.out.println("Deliver 2 Small Packages:");
        System.out.println(lockerManager);
        for (int i = 3; i < 7; i++) {
            lockerManager.delivery(smallPkgs.get(i));
        }
        System.out.println("Deliver 4 more Small Packages:");
        System.out.println(lockerManager);
        System.out.println("Pick up the package at L-1 Locker:");

        System.out.println(lockerManager.pickUp("L-1"));
        System.out.println(lockerManager);
    }
}
