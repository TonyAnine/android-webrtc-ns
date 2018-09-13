package com.qd.gtcom.wangzhengcheng.ns;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = true;

    private static final String INPUT_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/99999-wzc-test.pcm";
    private static final String OUT_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wzc-agc-ns-test.pcm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (DEBUG){
            doNs();
        }else {
            doNxs();
        }
    }



    private void doNs(){
        try{
            AgcUtils agcUtils = new AgcUtils();
            agcUtils.setAgcConfig(3,20,1).prepare();

            NsUtils nsUtils = new NsUtils();
            int createStatus = nsUtils.nsCreate();
            int initStatus = nsUtils.nsInit(createStatus,8000);
            int setStatus = nsUtils.nsSetPolicy(createStatus,2);

            Log.e(TAG,"createStatus = " + createStatus + "initStatus = " + initStatus  + "setStatus = " + setStatus);


            FileInputStream fInt = new FileInputStream(INPUT_FILE_PATH);
            FileOutputStream fOut = new FileOutputStream(OUT_FILE_PATH);
            byte[] buffer = new byte[160];
            int bytes ;

            while(fInt.read(buffer) != -1){
                short[] inputData = new short[80];
                short[] outData = new short[80];
                short[] outDataend = new short[80];
                ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(inputData);

                int aa = agcUtils.agcProcess(inputData,0,80,outData,0,0,0,0);
                Log.e(TAG, "-====== aa = " + aa);

                int ret = nsUtils.nsProcess(createStatus,outData,null,outDataend,null);
                Log.e(TAG,"ret = " + ret);

                fOut.write(shortArrayToByteArry(outDataend));
            }

            fInt.close();
            fOut.close();



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void doNxs(){
        try{

            NsUtils nsUtils = new NsUtils();
            int createStatus = nsUtils.nsxCreate();
            int initStatus = nsUtils.nsxInit(createStatus,8000);
            int setStatus = nsUtils.nsxSetPolicy(createStatus,2);

            Log.e(TAG,"createStatus = " + createStatus + "initStatus = " + initStatus  + "setStatus = " + setStatus);


            FileInputStream fInt = new FileInputStream(INPUT_FILE_PATH);
            FileOutputStream fOut = new FileOutputStream(OUT_FILE_PATH);
            byte[] buffer = new byte[160];
            int bytes ;

            while(fInt.read(buffer) != -1){
                short[] inputData = new short[80];
                short[] outData = new short[80];
                ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(inputData);
                int ret = nsUtils.nsxProcess(createStatus,inputData,null,outData,null);

                Log.e(TAG,"ret = " + ret);

                fOut.write(shortArrayToByteArry(outData));
            }

            fInt.close();
            fOut.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // shortתbyte
    public byte[] shortArrayToByteArry(short[] data) {
        byte[] byteVal = new byte[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            byteVal[i * 2] = (byte) (data[i] & 0xff);
            byteVal[i * 2 + 1] = (byte) ((data[i] & 0xff00) >> 8);
        }
        return byteVal;
    }

}
