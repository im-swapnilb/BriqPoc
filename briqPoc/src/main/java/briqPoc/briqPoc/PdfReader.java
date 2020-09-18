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

    	PDDocument document = PDDocument.load(new File("D:\\briqPoc\\briqPoc\\active licences.pdf"));
        PDFTextStripper pdfStripper = new PDFTextStripper();


        //load all lines into a string
        String pages = pdfStripper.getText(document);

        //split by detecting newline
        String[] lines = pages.split("\r\n|\r|\n");
       
        for(String temp:lines)
        {
            System.out.println(temp);
        }
        status = true;
    	return status;
    }
}
