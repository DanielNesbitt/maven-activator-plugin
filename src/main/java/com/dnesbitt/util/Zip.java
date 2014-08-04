package com.dnesbitt.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Daniel Nesbitt
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public final class Zip {

    private Zip() { }

    public static void unzipToDirectory(InputStream is, File outputDir) throws IOException {
        outputDir.mkdirs();

        try (ZipInputStream zis = new ZipInputStream(is)) {
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();
				File current = new File(outputDir, name);

                if (entry.isDirectory()) {
                    current.mkdirs();
                } else {
                    current.getParentFile().mkdirs();
                    Files.copy(zis, current.toPath());
                }
            }
        }

    }

}
