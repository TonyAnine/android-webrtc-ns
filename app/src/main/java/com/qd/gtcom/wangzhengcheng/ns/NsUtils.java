package com.qd.gtcom.wangzhengcheng.ns;

/**
 * Created by wangzhengcheng on 2017/10/30.
 */

public class NsUtils {

    static {
        System.loadLibrary("wzc_webrtc_ns");
    }

    private int nsHandler = 0;

    public native int nsCreate ();

    public native int nsInit(int nsHandler,int frequency);

    public native int nsSetPolicy(int nsHandler,int mode);

    public native int nsProcess(int nsHandler,short[] sample,short[] sample_H,short[] outData, short[] outData_H);

    public native int nsFree(int nsHandler);







    public native int nsxCreate ();

    public native int nsxInit(int nsxHandler,int frequency);

    public native int nsxSetPolicy(int nsxHandler,int mode);

    public native int nsxProcess(int nsxHandler,short[] sample,short[] sample_H,short[] outData, short[] outData_H);

    public native int nsxFree(int nsxHandler);


}
