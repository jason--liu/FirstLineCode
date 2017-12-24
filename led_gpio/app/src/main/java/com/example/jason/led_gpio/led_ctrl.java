package com.example.jason.led_gpio;

/**
 * Created by jason on 17-12-23.
 */

public class led_ctrl {
    public static native int ledOpen();
    public static native void ledClose();
    public static native int ledCtrl(int which, int status);

    static {
        System.loadLibrary("led_ctrl");
    }

}
