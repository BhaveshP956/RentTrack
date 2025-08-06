package com.example.renttrack.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OCRService {

    public String extractTextFromImage(File file) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Update path!
        tesseract.setLanguage("eng");

        try {
            return tesseract.doOCR(file);
        } catch (TesseractException e) {
            throw new RuntimeException("OCR failed: " + e.getMessage());
        }
    }
}
