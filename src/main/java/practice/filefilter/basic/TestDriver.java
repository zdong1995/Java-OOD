package practice.filefilter.basic;

import practice.filefilter.File;
import practice.filefilter.FilterParam;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        FilterSystem fs = new FilterSystem();
        List<File> files = new ArrayList<>();
        files.add(new File(1, "Algorithm", 1000));
        files.add(new File(2, "AllFiles", 1000000));
        files.add(new File(3, "Tasks", 10));
        files.add(new File(4, "ObjectOriented", 10000));
        System.out.println("Input files: " + files);

        SizeFilter sizeFilter = new SizeFilter();
        SuffixFilter suffixFilter = new SuffixFilter();

        List<File> sizeFilteredFile1 = fs.filter(files, sizeFilter, new FilterParam(1000));
        System.out.println("Files with size > 1000 : " + sizeFilteredFile1);

        List<File> sizeFilteredFile2 = fs.filter(files, sizeFilter, new FilterParam(10000));
        System.out.println("Files with size > 10000 : " + sizeFilteredFile2);

        List<File> suffixFilteredFile1 = fs.filter(files, suffixFilter, new FilterParam("Al"));
        System.out.println("Files with suffix = Al : " + suffixFilteredFile1);

        List<File> suffixFilteredFile2 = fs.filter(files, suffixFilter, new FilterParam("All"));
        System.out.println("Files with suffix = All : " + suffixFilteredFile2);
    }
}
