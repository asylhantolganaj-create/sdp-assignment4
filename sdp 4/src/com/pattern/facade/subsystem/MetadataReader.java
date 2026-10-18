package com.pattern.facade.subsystem;

public class MetadataReader {
    public void readMetadata(String fileName) {
        System.out.println("[MetadataReader] Reading metadata from file: " + fileName);
    }

    public String extractVideoCodec(String fileName) {
        System.out.println("[MetadataReader] Extracting original codec details...");
        return "mp4";
    }
}
