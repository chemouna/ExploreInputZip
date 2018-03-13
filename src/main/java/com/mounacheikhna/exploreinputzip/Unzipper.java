package com.mounacheikhna.exploreinputzip;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzipper {

    public static void main(String[] args) {
        try {
            ZipFile zf = new ZipFile("resources/simple.zip");
            new File("simple").mkdir();

            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze = (ZipEntry) e.nextElement();
                System.out.println("Unzipping " + ze.getName());

                if(ze.getName().endsWith(".txt")) {
                    FileOutputStream fout = new FileOutputStream(ze.getName());
                    InputStream in = zf.getInputStream(ze);
                    Copier.copy(in, fout);
                    in.close();
                    fout.close();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

}
