
import SecuGen.FDxSDKPro.jni.JSGFPLib;
import SecuGen.FDxSDKPro.jni.SGFDxDeviceName;
import SecuGen.FDxSDKPro.jni.JSGFPLib;
import SecuGen.FDxSDKPro.jni.SGDeviceInfoParam;
import SecuGen.FDxSDKPro.jni.SGFDxDeviceName;
import SecuGen.FDxSDKPro.jni.SGFDxErrorCode;
import SecuGen.FDxSDKPro.jni.SGFDxSecurityLevel;
import SecuGen.FDxSDKPro.jni.SGFingerInfo;
import SecuGen.FDxSDKPro.jni.SGFingerPosition;
import SecuGen.FDxSDKPro.jni.SGImpressionType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author insan
 */
public class Scanning {
    long ret; 
    JSGFPLib sgfplib;
    SGDeviceInfoParam deviceInfo;
    SGFingerInfo fingerInfo;

    public Scanning() {
        this.sgfplib = new JSGFPLib();
        this.ret = sgfplib.Init(SGFDxDeviceName.SG_DEV_AUTO);
        this.deviceInfo = new SGDeviceInfoParam();
        this.sgfplib.GetDeviceInfo(deviceInfo);
        this.fingerInfo = new SGFingerInfo();
        this.fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        this.fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        this.fingerInfo.ViewNumber = 1;
    }
    
 public static byte[] getTemplate(JSGFPLib sgfplib, SGDeviceInfoParam deviceInfo) {
        int[] quality = new int[1];
        byte[] regMin = new byte[400];
        byte[] imageBuffer = new byte[deviceInfo.imageHeight * deviceInfo.imageWidth];
        long err;
        SGFingerInfo fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;
        if (sgfplib.GetImageEx(imageBuffer, 210000000, 0, 80) == SGFDxErrorCode.SGFDX_ERROR_NONE) {
            err = sgfplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer, quality);
            err = sgfplib.CreateTemplate(fingerInfo, imageBuffer, regMin);
            System.out.println("eror template : " + err);
        }

        return regMin;
    }
}

