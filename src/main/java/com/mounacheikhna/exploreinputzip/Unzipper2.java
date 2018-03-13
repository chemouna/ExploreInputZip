package com.mounacheikhna.exploreinputzip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzipper2 {

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("resources/simple.zip");
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry ze;
            while ((ze = zin.getNextEntry()) != null) {


                System.out.println("Unzipping " + ze.getName());
                FileOutputStream fout = new FileOutputStream(ze.getName());
                Copier.copy(zin, fout);
                zin.closeEntry();
                fout.close();
            }
            zin.close();
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

}
