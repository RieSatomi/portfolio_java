package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;


@Service
public class ImageService {

    // 画像をBase64にエンコードするユーティリティメソッド
    public String encodeImage(InputStream inputStream) {
        byte[] imageBytes;
        try {
            imageBytes = IOUtils.toByteArray(inputStream); // InputStreamをバイト配列に変換
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(imageBytes); // バイト配列をBase64にエンコードして返す
    }
}