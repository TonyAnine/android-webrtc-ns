package com.qd.gtcom.wangzhengcheng.ns;

import android.util.Log;

/**
 * Created by wangzhengcheng on 2017/10/23.
 */

public class AgcUtils {

    private static final String TAG = "AgcUtils";

    static {
        System.loadLibrary("wzc_webrtc_agc");
    }


    private int agcInstance = -1;
    private WebRtcAgcConfig config = null;
    private boolean mIsInit = false;

    public native int create();
    public native int init(int agcInstance,int minLevel,int maxLevel,int agcMode,int fs);
    public native int free(int agcInstance);
    public native int process(int agcInstance,short[] inNear,int num_bands,int samples,short[] out,int inMicLevel,int outMicLevel,int echo,int saturationWarning);
    public native int setConfig(int agcInstance,WebRtcAgcConfig agcConfig);
    public native int addFarend(int agcInstance,short[] inFar,int samples);
    public native int addMic(int agcInstance,short[] inMic,int num_bands,int samples);


    public native int getConfig();
    public native int virtualMic();
    public native int getAddFarendError();


    public AgcUtils() {
        config = new WebRtcAgcConfig();
        agcInstance = create();
        Log.e(TAG,"=====" + agcInstance);
    }

    private class WebRtcAgcConfig {
        private int targetLevelDbfs;
        private int compressionGaindB;
        private int limiterEnable;
    }

    public AgcUtils setAgcConfig (int targetLevelDbfs, int compressionGaindB, int limiterEnable ){
        config.targetLevelDbfs = targetLevelDbfs;
        config.compressionGaindB = compressionGaindB;
        config.limiterEnable = limiterEnable;

        return this;
    }

    public AgcUtils prepare(){
        if (mIsInit) {
            close();
            agcInstance = create();
        }

        int aa = init(agcInstance,0,255,3,8000);

        Log.e(TAG,"====== aa = " + aa);

        mIsInit = true;
        int bb = setConfig(agcInstance,config);
        Log.e(TAG,"===== bb = " + bb);
        return this;
    }


    public void close() {

        if (mIsInit) {
            free(agcInstance);
            agcInstance = -1;
            mIsInit = false;
        }
    }

    public int agcProcess (short[] inNear,int num_bands,int samples,short[] out,int inMicLevel,int outMicLevel,int echo,int saturationWarning){

        return process(agcInstance,inNear,num_bands,samples,out,inMicLevel,outMicLevel,echo,saturationWarning);
    }

}
