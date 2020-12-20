package com.notcat.patching;

import com.notcat.helpers.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("ConstantConditions")
public class JarWriter {

    private final FileSystem fileSystem;
    public Exception lastException;

    public JarWriter(Path archivePath) throws IOException {
        this.fileSystem = FileSystems.newFileSystem(archivePath, null);
    }

    public boolean write(String rawPath, InputStream stream) {
        try {

            Path path = fileSystem.getPath(rawPath);

            if(Files.exists(path))
                Files.delete(path);

            Files.createDirectories(path.getParent());
            Files.write(path, StreamUtils.bytesFromStream(stream));

            return true;
        } catch (IOException exp) {
            lastException = exp;
            return false;
        }
    }

    public boolean close() {
        try {
            fileSystem.close();
            return true;
        } catch (IOException exp) {
            lastException = exp;
            return false;
        }
    }

}
