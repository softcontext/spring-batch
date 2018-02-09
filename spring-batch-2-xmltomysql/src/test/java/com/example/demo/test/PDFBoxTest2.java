package com.example.demo.test;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.Test;

/*
 * https://www.tutorialspoint.com/pdfbox/pdfbox_tutorial.pdf
 */
public class PDFBoxTest2 {

	@Test
	public void test() throws IOException {
		PDDocument document = new PDDocument();

		PDPage page = new PDPage();
		document.addPage(page);

		// ------------------------------------------------------
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		// Begin the Content stream
		contentStream.beginText();

		// Setting the font to the Content stream
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

		// Setting the position for the line
		contentStream.newLineAtOffset(25, 500);

		String text = "This is the sample document and we are adding content to it.";

		// Adding text in the form of string
		contentStream.showText(text);

		// Ending the content stream
		contentStream.endText();

		System.out.println("Content added");

		// Closing the content stream
		contentStream.close();
		// ------------------------------------------------------

		// Saving the document
		document.save(new File("C:/Lesson4/pdfs/my_cocntent.pdf"));

		// Closing the document
		document.close();

		System.out.println("PDF created");
	}

	@Test
	public void test2() throws IOException {
		File file = new File("C:/Lesson4/pdfs/my_cocntent.pdf");

		PDDocument document = PDDocument.load(file);

		// Creating a PDF Document
		PDPage page = document.getPage(0); // TODO: 덮어쓰기가 되는데 기존 컨텐츠를 유지하는 방법을 알아보자.

		// ------------------------------------------------------
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		contentStream.beginText();

		contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);

		// Setting the leading
		contentStream.setLeading(14.5f);

		contentStream.newLineAtOffset(25, 725);

		String text1 = "This is an example of adding text to a page in the pdf document. we can add as many lines";
		String text2 = "as we want like this using the showText() method of the ContentStream class";

		contentStream.showText(text1);

		contentStream.newLine();

		contentStream.showText(text2);

		contentStream.endText();

		System.out.println("Content added");

		contentStream.close();
		// ------------------------------------------------------

		document.save(new File("C:/Lesson4/pdfs/my_cocntent_new.pdf"));

		document.close();

		System.out.println("PDF created");
	}
}
