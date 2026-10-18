package com.pattern.facade.subsystem;

public class BitrateReader {
    public byte[] readBuffer(String fileName, String codec) {
        System.out.println("[BitrateReader] Reading bitrate buffer using codec: " + codec);
        return new byte[]{0x1, 0x2, 0x3, 0x4};
    }

    public byte[] convertBuffer(byte[] buffer, String targetCodec) {
        System.out.println("[BitrateReader] Re-encoding buffer stream to: " + targetCodec);
        return buffer;
    }
}