package com.example.eli.textbyte;

/**
 * Created by Eli on 2016/8/17.
 */
public class TextThread extends Thread {
    private String mStr = "";

    public TextThread(String str) {
        mStr = str;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println(mStr);
        }
    }
}
