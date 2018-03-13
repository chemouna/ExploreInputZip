package com.mounacheikhna.exploreinputzip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileValidator {

    public boolean validate(String filePath) throws IllegalArgumentException {
        final FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
            return true;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Model file " + filePath + " not found");
        }
    }

}
