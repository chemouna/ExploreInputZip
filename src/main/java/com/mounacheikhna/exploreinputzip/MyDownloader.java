package com.mounacheikhna.exploreinputzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyDownloader {

    // just downloads a zip file and passes it to a reader
    public void download() {
        String url = "https://drive.google.com/file/d/1LvWvl3O-Q8uUBrvcouXIFl2zAvdJj-MZ/view?usp=sharing";

        // once downloaded we have a file
        File downloadedFile = null;

        MyValidator validator = new MyValidator();
        try {
            validator.validate(new FileInputStream(downloadedFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
