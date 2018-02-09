package com.example.demo.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.Test;

/*
 * https://www.tutorialspoint.com/pdfbox/pdfbox_tutorial.pdf
 */
public class PDFBoxTest {

	@Test
	public void test() throws IOException {
		// Creating PDF document object
		PDDocument document = new PDDocument();

		// Creating a blank page
		PDPage page = new PDPage();

		// Adding the blank page to the document
		document.addPage(page);

		// Saving the document
		document.save("C:/Lesson4/pdfs/my_test.pdf");

		// Closing the document
		document.close();

		System.out.println("PDF created");
	}

	@Test
	public void test2() throws IOException {
		// Loading an existing document
		File file = new File("C:/Lesson4/pdfs/my_test.pdf");
		PDDocument document = PDDocument.load(file);

		// Creating a blank page
		PDPage page = new PDPage();

		// Adding the blank page to the document
		document.addPage(page);

		// Saving the document
		document.save("C:/Lesson4/pdfs/my_test.pdf");

		// Closing the document
		document.close();

		System.out.println("PDF updated");
	}

	@Test
	public void test3() throws IOException {
		// Loading an existing document
		File file = new File("C:/Lesson4/pdfs/my_test.pdf");
		PDDocument document = PDDocument.load(file);

		// Listing the number of existing pages
		int noOfPages = document.getNumberOfPages();

		// removing the pages
		document.removePage(noOfPages - 1);

		// Saving the document
		document.save("C:/Lesson4/pdfs/my_test.pdf");

		// Closing the document
		document.close();

		System.out.println("PDF updated : " + noOfPages + " page deleted");
	}
	
	/*
	 * Property						Description
	 * ------------------------------------------------------------------------------------------------------------------
	 * File							This property holds the name of the file.
	 * Title						Using this property, you can set the title for the document.
	 * Author						Using  this  property,  you  can  set  the  name  of  the  author  for  the document.
	 * Subject						Using this property, you can specify the subject of the PDF document.
	 * Keywords						Using this property, you can list the keywords with which we can search the document.
	 * Created						Using this property, you can set the date created for the document.
	 * Modified						Using this property, you can set the date modified for the document.
	 * Application					Using this property, you can set the Application of the document.
	 */
	
	@Test
	public void test4() throws IOException {
		PDPage page = new PDPage();
		
		PDDocument document = new PDDocument();
		document.addPage(page);
		
		//Instantiating the PDDocumentInformation class
		PDDocumentInformation pdd = document.getDocumentInformation();
		
		//Setting the author of the document
		pdd.setAuthor("Tutorialspoint");
		
		// Setting the title of the document
		pdd.setTitle("Sample document");
		
		//Setting the creator of the document
		pdd.setCreator("PDF Examples");
		
		//Setting the subject of the document
		pdd.setSubject("Example document");
		
		Calendar date = new GregorianCalendar();
		
		//Setting the created date of the document
		date.set(2015, 10, 5);
		pdd.setCreationDate(date);
		
		//Setting the modified date of the document
		date.set(2016, 5, 5);
		pdd.setModificationDate(date);
		
		//Setting keywords for the document
		pdd.setKeywords("sample, first example, my pdf");
		
		document.save("C:/Lesson4/pdfs/my_attributes.pdf");
		document.close();

		System.out.println("PDF created : Properties added successfully");
	}
	
	@Test
	public void test5() throws IOException {
		// Loading an existing document
		File file = new File("C:/Lesson4/pdfs/my_attributes.pdf");

		PDDocument document = PDDocument.load(file);

		// Getting the PDDocumentInformation object
		PDDocumentInformation pdd = document.getDocumentInformation();

		// Retrieving the info of a PDF document
		System.out.println("Author of the document is : " + pdd.getAuthor());
		System.out.println("Title of the document is : " + pdd.getTitle());
		System.out.println("Subject of the document is : " + pdd.getSubject());
		System.out.println("Creator of the document is : " + pdd.getCreator());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Creation date of the document is : " + sdf.format(pdd.getCreationDate().getTime()));
		System.out.println("Modification date of the document is : " + sdf.format(pdd.getModificationDate().getTime()));
		System.out.println("Creator of the document is : " + pdd.getKeywords());

		// Closing the document
		document.close();
	}
	
}
