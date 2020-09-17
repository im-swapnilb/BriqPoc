package briqPoc.briqPoc;

import java.io.File; 
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper; 


public class PdfReader
{
	static boolean status = false;
	    
    public static void main( String[] args ) throws IOException
    {
        System.out.println("PDF read is "+pdfDataRead());
    }
    
 
    
    public static boolean pdfDataRead() throws IOException {
    	PDFTextStripper  tStripper = new PDFTextStripper();
	    tStripper.setStartPage(1);
	    tStripper.setEndPage(3);
    	PDDocument document = PDDocument.load(new File("D:\\briqPoc\\briqPoc\\active licences.pdf"));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(1);

        //load all lines into a string
        String pages = pdfStripper.getText(document);

        //split by detecting newline
        String[] lines = pages.split("\r\n|\r|\n");

        int count=1;   //Just to indicate line number
       
        for(String temp:lines)
        {
            System.out.println(temp);
        }
        status = true;
    	return status;
    }
}
