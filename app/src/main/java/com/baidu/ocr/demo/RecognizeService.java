/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.ocr.demo;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.BankCardParams;
import com.baidu.ocr.sdk.model.BankCardResult;
import com.baidu.ocr.sdk.model.GeneralBasicParams;
import com.baidu.ocr.sdk.model.GeneralParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.baidu.ocr.sdk.model.OcrRequestParams;
import com.baidu.ocr.sdk.model.OcrResponseResult;
import com.baidu.ocr.sdk.model.Word;
import com.baidu.ocr.sdk.model.WordSimple;

import java.io.File;

/**
 * Created by ruanshimin on 2017/4/20.
 */

public class RecognizeService {

    interface ServiceListener {
        public void onResult(String result);
    }

    public static void recGeneral(String filePath, final ServiceListener listener) {
        GeneralParams param = new GeneralParams();
        param.setDetectDirection(true);
        param.setVertexesLocation(true);
        param.setRecognizeGranularity(GeneralParams.GRANULARITY_SMALL);
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeGeneral(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                StringBuilder sb = new StringBuilder();
                for (WordSimple wordSimple : result.getWordList()) {
                    Word word = (Word) wordSimple;
                    sb.append(word.getWords());
                    sb.append("\n");
                }
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recGeneralBasic(String filePath, final ServiceListener listener) {
        GeneralBasicParams param = new GeneralBasicParams();
        param.setDetectDirection(true);
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeGeneralBasic(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                StringBuilder sb = new StringBuilder();
                for (WordSimple wordSimple : result.getWordList()) {
                    WordSimple word = wordSimple;
                    sb.append(word.getWords());
                    sb.append("\n");
                }
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recGeneralEnhanced(String filePath, final ServiceListener listener) {
        GeneralBasicParams param = new GeneralBasicParams();
        param.setDetectDirection(true);
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeGeneralEnhanced(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                StringBuilder sb = new StringBuilder();
                for (WordSimple wordSimple : result.getWordList()) {
                    WordSimple word = wordSimple;
                    sb.append(word.getWords());
                    sb.append("\n");
                }
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recWebimage(String filePath, final ServiceListener listener) {
        GeneralBasicParams param = new GeneralBasicParams();
        param.setDetectDirection(true);
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeWebimage(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                StringBuilder sb = new StringBuilder();
                for (WordSimple wordSimple : result.getWordList()) {
                    WordSimple word = wordSimple;
                    sb.append(word.getWords());
                    sb.append("\n");
                }
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recBankCard(String filePath, final ServiceListener listener) {
        BankCardParams param = new BankCardParams();
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeBankCard(param, new OnResultListener<BankCardResult>() {
            @Override
            public void onResult(BankCardResult result) {
                String res = String.format("卡号：%s\n类型：%s\n发卡行：%s",
                        result.getBankCardNumber(),
                        result.getBankCardType().name(),
                        result.getBankName());
                listener.onResult(res);
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recVehicleLicense(String filePath, final ServiceListener listener) {
        OcrRequestParams param = new OcrRequestParams();
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeVehicleLicense(param, new OnResultListener<OcrResponseResult>() {
            @Override
            public void onResult(OcrResponseResult result) {
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recDrivingLicense(String filePath, final ServiceListener listener) {
        OcrRequestParams param = new OcrRequestParams();
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeDrivingLicense(param, new OnResultListener<OcrResponseResult>() {
            @Override
            public void onResult(OcrResponseResult result) {
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }

    public static void recLicensePlate(String filePath, final ServiceListener listener) {
        OcrRequestParams param = new OcrRequestParams();
        param.setImageFile(new File(filePath));
        OCR.getInstance().recognizeLicensePlate(param, new OnResultListener<OcrResponseResult>() {
            @Override
            public void onResult(OcrResponseResult result) {
                listener.onResult(result.getJsonRes());
            }

            @Override
            public void onError(OCRError error) {
                listener.onResult(error.getMessage());
            }
        });
    }
}
