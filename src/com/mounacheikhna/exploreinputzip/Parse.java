package com.mounacheikhna.exploreinputzip;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Parse {

    public static void main(String[] args) {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile("resources/test.zip");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while(entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();
                System.out.println("has entry of name : "+ entry.getName());
                //InputStream stream = zipFile.getInputStream(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
