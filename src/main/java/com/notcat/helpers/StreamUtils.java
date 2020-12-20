package com.notcat.helpers;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamUtils {

    public static byte[] bytesFromStream(InputStream stream) {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {

            byte[] data = new byte[16384];

            int read;
            while ((read = stream.read(data, 0, data.length)) != -1)
                buffer.write(data, 0, read);

            return buffer.toByteArray();
        } catch (Exception exp) {
            return null;
        }

    }

}
