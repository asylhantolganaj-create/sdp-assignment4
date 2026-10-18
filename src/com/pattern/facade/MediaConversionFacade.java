package com.pattern.facade;

import com.pattern.facade.exception.MediaConversionException;
import com.pattern.facade.subsystem.AudioMixer;
import com.pattern.facade.subsystem.BitrateReader;
import com.pattern.facade.subsystem.CodecFactory;
import com.pattern.facade.subsystem.MetadataReader;

import java.io.File;

public class MediaConversionFacade {
    private final MetadataReader metadataReader;
    private final CodecFactory codecFactory;
    private final BitrateReader bitrateReader;
    private final AudioMixer audioMixer;

    public MediaConversionFacade() {
        this.metadataReader = new MetadataReader();
        this.codecFactory = new CodecFactory();
        this.bitrateReader = new BitrateReader();
        this.audioMixer = new AudioMixer();
    }

    public File convertMedia(String fileName, String targetFormat) {
        System.out.println("\n=== Starting Conversion via MediaConversionFacade ===");
        try {
            metadataReader.readMetadata(fileName);
            String sourceCodec = metadataReader.extractVideoCodec(fileName);

            String destinationCodec = codecFactory.extractCodec(targetFormat);
            byte[] rawBuffer = bitrateReader.readBuffer(fileName, sourceCodec);
            byte[] convertedBuffer = bitrateReader.convertBuffer(rawBuffer, destinationCodec);

            byte[] resultBuffer = audioMixer.fixAudioStream(convertedBuffer);

            String outputFileName = fileName.substring(0, fileName.lastIndexOf('.')) + "." + targetFormat;
            System.out.println("[MediaConversionFacade] Conversion finished successfully! Output: " + outputFileName);

            return new File(outputFileName);
        } catch (Exception e) {
            throw new MediaConversionException("Failed to convert media file: " + fileName, e);
        }
    }
}
