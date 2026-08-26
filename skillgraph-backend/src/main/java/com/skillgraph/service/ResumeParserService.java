package com.skillgraph.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

@Service
public class ResumeParserService {

    public String extractText(String filePath) {

        try {

            File file = new File(filePath);

            PDDocument document = PDDocument.load(file);

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {

            e.printStackTrace();
            return "Unable to Read Resume";
        }

    }

}