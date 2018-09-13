LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := wzc_webrtc_ns
LOCAL_CFLAGS += -DWEBRTC_POSIX

LOCAL_SRC_FILES := \
	E:\WebRtc\android-webrtc-ns\app\src\main\jni\analog_agc.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\complex_bit_reverse.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\complex_fft.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\copy_set_operations.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\cross_correlation.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\digital_agc.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\division_operations.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\dot_product_with_scale.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\downsample_fast.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\energy.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\fft4g.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\get_scaling_square.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\main.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\min_max_operations.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\noise_suppression.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\noise_suppression_x.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\nsx_core.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\nsx_core_c.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\nsx_core_neon_offsets.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\ns_core.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\real_fft.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\resample.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\resample_48khz.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\resample_by_2.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\resample_by_2_internal.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\resample_by_2_mips.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\resample_fractional.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\ring_buffer.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\splitting_filter.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\spl_init.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\spl_sqrt.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\spl_sqrt_floor.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\vector_scaling_operations.c \
    	E:\WebRtc\android-webrtc-ns\app\src\main\jni\util.c \

LOCAL_C_INCLUDES += E:\WebRtc\android-webrtc-ns\app\src\main\jni
LOCAL_C_INCLUDES += E:\WebRtc\android-webrtc-ns\app\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
