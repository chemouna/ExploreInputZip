package com.mounacheikhna.exploreinputzip;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipFile;

public class ZipLister {

    public static void main(String[] args) {
        try {
            ZipFile zf = new ZipFile(new File("resources/test.zip"));
            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                System.out.println(e.nextElement());
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
