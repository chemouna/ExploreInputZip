package com.mounacheikhna.exploreinputzip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzipper {

    public static void main(String[] args) {
        try {
            ZipFile zf = new ZipFile("resources/simple.zip");
            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze = (ZipEntry) e.nextElement();
                System.out.println("Unzipping " + ze.getName());

                if(ze.getName().endsWith(".txt")) {
                    FileOutputStream fout = new FileOutputStream(ze.getName());
                    InputStream in = zf.getInputStream(ze);
                    copy(in, fout);
                    in.close();
                    fout.close();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    private static void copy(InputStream in, OutputStream out)
            throws IOException {
        // Do not allow other threads to read from the input
        // or write to the output while copying is taking place
        synchronized (in) {
            synchronized (out) {
                byte[] buffer = new byte[256];
                while (true) {
                    int bytesRead = in.read(buffer);
                    if (bytesRead == -1) break;
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }

}
