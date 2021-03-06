package com.mounacheikhna.exploreinputzip;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Parse {

    public static void main(String[] args) {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile("resources/test.zip");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

/*
            int BUFFER = 4096;
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                System.out.println("has entry of name : " + entry.getName());

                if (entry.getName().contains("image") && entry.isDirectory()) {
                    //Path path = Paths.get(entry.getName());
                    //InputStream inputStream = zipFile.getInputStream(entry);

                    File destFile = new File(newPath, currentEntry);

                    if (!entry.isDirectory()) {
                        BufferedInputStream is = new BufferedInputStream(
                                zipFile.getInputStream(entry));
                        int currentByte;
                        // establish buffer for writing file
                        byte data[] = new byte[BUFFER];

                        // write the current file to disk
                        FileOutputStream fos = new FileOutputStream(destFile);
                        BufferedOutputStream dest = new BufferedOutputStream(fos,
                                BUFFER);

                        // read and write until last byte is encountered
                        while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                            dest.write(data, 0, currentByte);
                        }
                        dest.flush();
                        dest.close();
                        is.close();
                    }


                }

                //InputStream stream = zipFile.getInputStream(entry);
            }
*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unzipImage(String zipFile, String extractFolder) {
        try {
            //CreateDir();
            int BUFFER = 4096;
            File file = new File(zipFile);

            ZipFile zip = new ZipFile(file);
            String newPath = extractFolder;

            new File(newPath).mkdir();
            Enumeration zipFileEntries = zip.entries();

            // Process each entry
            while (zipFileEntries.hasMoreElements()) {
                // grab a zip file entry

                ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
                String currentEntry = entry.getName();

                currentEntry = currentEntry.replace('\\', '/');
                File destFile = new File(newPath, currentEntry);
                // destFile = new File(newPath, destFile.getName());
                File destinationParent = destFile.getParentFile();

                // create the parent directory structure if needed
                destinationParent.mkdirs();

                if (!entry.isDirectory()) {
                    BufferedInputStream is = new BufferedInputStream(
                            zip.getInputStream(entry));
                    int currentByte;
                    // establish buffer for writing file
                    byte data[] = new byte[BUFFER];

                    // write the current file to disk
                    FileOutputStream fos = new FileOutputStream(destFile);
                    BufferedOutputStream dest = new BufferedOutputStream(fos,
                            BUFFER);

                    // read and write until last byte is encountered
                    while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                        dest.write(data, 0, currentByte);
                    }
                    dest.flush();
                    dest.close();
                    is.close();
                }
                zip.close();
            }
        } catch (Exception e) {
        }
    }


}
