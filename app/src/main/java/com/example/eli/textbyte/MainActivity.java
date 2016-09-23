package com.example.eli.textbyte;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.math.BigDecimal;


public class MainActivity extends Activity {
    TextThread thread;
    ImageView imgGif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
//        byte[] byteText = {(byte) 0x42, (byte) 0xC8, (byte) 0x00, (byte) 0x00}; //41 B0 CC D1
        //byte[] byteText = {(byte) 0x01}; //44 7B 6D FF
        //byte[] byteText = {(byte) 0x00 ,(byte) 0x40, (byte) 0xC0, (byte) 0x99, (byte) 0xA2}; //40 C0 99 A2
        //42 C8 00 00
        //41 C6 66 66
        //41 CC CC CD
        //41 0C 00 00
        //42 C8 00 00
        //      Log.e(MainActivity.class.getSimpleName(), "接收成功-------val.length-----" + displayNmuber(byte2float(getVal(byteText), 0)));
        //Log.e(MainActivity.class.getSimpleName(), "接收成功-------val.length-----" + Float.intBitsToFloat(byteText[0] & 0xff));

//        thread1();
//        thread2();

        imgGif = (ImageView) this.findViewById(R.id.img_gif);
        Glide.with(this).load(R.drawable.img2).into(imgGif);
    }

    private void thread1() {
        thread = new TextThread("thread---1");
        thread.start();
    }


    private void thread2() {
        thread = new TextThread("thread---2");
        thread.start();
    }

    private int[] getVal(byte[] valByte) {
        Log.e(MainActivity.class.getSimpleName(), "接收成功-------val.length-----" + valByte.length);
        int[] val = new int[valByte.length];

        for (byte i = 0; i < valByte.length; i++) {
            val[i] = valByte[i] & 0xff;
            System.out.print("" + val[i] + ",");
        }
        return val;
    }

    public static float byte2float(int[] b, int index) {
        int l;
        l = b[index + 3];
        l &= 0xff;
        l |= ((long) b[index + 2] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 1] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 0] << 24);
        return Float.intBitsToFloat(l);
    }

    public static String displayNmuber(float airPress) {
        BigDecimal bd = new BigDecimal(airPress);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.toString();
    }
}
