package com.example.demo.model;

import java.io.InputStream;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor //コンストラクタの自動生成
public class AttachmentFile {
    private long length;
    private InputStream inputStream;

    public AttachmentFile(long length, InputStream inputStream) {
        this.length = length;
        this.inputStream = inputStream;
    }
    
    public long getLength() {
        return length;
    }
    public InputStream getInputStream() {
        return inputStream;
    }
}
