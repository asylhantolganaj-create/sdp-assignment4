package com.pattern.facade;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        MediaConversionFacade converter = new MediaConversionFacade();

        File convertedMp4 = converter.convertMedia("funny_cat_video.avi", "mp4");
        File convertedOgg = converter.convertMedia("podcast_audio.wav", "ogg");
    }
}