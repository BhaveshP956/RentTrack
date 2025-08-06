package com.example.renttrack.controller;

import com.example.renttrack.model.OCRResponse;
import com.example.renttrack.service.OCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/ocr")
public class OCRController {

    @Autowired
    private OCRService ocrService;

    @PostMapping("/upload")
    public OCRResponse extractFromImage(@RequestParam("file") MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("upload", file.getOriginalFilename());
        file.transferTo(tempFile);

        String extractedText = ocrService.extractTextFromImage(tempFile);

        // Extract fields from raw text using regex
        String name = extractField(extractedText, "(?i)name[:\\s]+([A-Z][a-z]+\\s[A-Z][a-z]+)");
        String dob = extractField(extractedText, "(?i)dob[:\\s]+(\\d{2}/\\d{2}/\\d{4})");
        String id = extractField(extractedText, "(?i)(id|id no|id number)[:\\s]+([A-Z0-9]+)");

        return new OCRResponse(name, dob, id);
    }

    private String extractField(String text, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        return matcher.find() ? matcher.group(1) : "Not Found";
    }
}
