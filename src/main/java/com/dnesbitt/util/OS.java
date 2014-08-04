package com.dnesbitt.util;

/**
 * @author Daniel Nesbitt
 */
public final class OS {

    private OS() { }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

}
