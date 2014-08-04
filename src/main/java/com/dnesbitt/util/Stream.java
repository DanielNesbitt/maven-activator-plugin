package com.dnesbitt.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Daniel Nesbitt
 */
public final class Stream {

    private static final byte[] BUFFER = new byte[1024 * 10];

    private Stream() { }

    public static void copy(InputStream is, OutputStream os) throws IOException {
        copy(is, os, BUFFER);
    }

    public static void copy(InputStream is, OutputStream os, byte[] buffer) throws IOException {
        while (true) {
            int read = is.read(buffer, 0, buffer.length);
            if (read < 0) {
                os.flush();
                return;
            }
            os.write(buffer, 0, read);
        }
    }

}
