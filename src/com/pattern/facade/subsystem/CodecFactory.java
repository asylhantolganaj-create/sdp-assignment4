package com.pattern.facade.subsystem;

public class CodecFactory {
    public String extractCodec(String format) {
        System.out.println("[CodecFactory] Preparing codec for target format: " + format);
        if ("mp4".equalsIgnoreCase(format)) {
            return "MPEG-4 Codec";
        } else if ("ogg".equalsIgnoreCase(format)) {
            return "Ogg Vorbis Codec";
        } else if ("avi".equalsIgnoreCase(format)) {
            return "Audio Video Interleave Codec";
        }
        return "Generic Codec";
    }
}