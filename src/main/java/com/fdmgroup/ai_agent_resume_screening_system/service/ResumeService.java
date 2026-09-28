package com.fdmgroup.ai_agent_resume_screening_system.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {

    public String uploadResume(MultipartFile file) {

        try (PDDocument document =
                     Loader.loadPDF(file.getBytes())) {

            PDFTextStripper stripper =
                    new PDFTextStripper();

            String text = stripper.getText(document);

            List<String> chunks = chunkText(text);

            return """
                    Resume uploaded successfully
                    
                    Total Chunks Created: %d
                    """.formatted(chunks.size());

        } catch (IOException e) {
            return "Error reading PDF: "
                    + e.getMessage();
        }
    }

    private List<String> chunkText(String text) {

        List<String> chunks = new ArrayList<>();

        int chunkSize = 500;

        for (int i = 0; i < text.length(); i += chunkSize) {

            chunks.add(
                    text.substring(
                            i,
                            Math.min(
                                    i + chunkSize,
                                    text.length()
                            )
                    )
            );
        }

        return chunks;
    }
}