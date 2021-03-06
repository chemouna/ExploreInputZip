package com.mounacheikhna.exploreinputzip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Copier {

    public static void copy(InputStream in, OutputStream out)
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
