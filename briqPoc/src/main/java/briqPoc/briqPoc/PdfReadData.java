package briqPoc.briqPoc;

import java.io.File; 
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper; 

public class PdfReadData 
{

	static boolean status = false;
	static String custAddress = "";
	static String  bankAddress= "";
	    
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Data extracted status "+pdfDataExtraction());

    }
    
 
    
    public static boolean pdfDataExtraction() throws IOException {
    	PDFTextStripper  tStripper = new PDFTextStripper();
	    tStripper.setStartPage(1);
	    tStripper.setEndPage(3);
    	PDDocument document = PDDocument.load(new File("D:\\briqPoc\\briqPoc\\sample statement.pdf"));
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

            if (temp.contains("Customer")) {
            	String custName = temp;
            	System.out.println("Customer name is "+custName);
            	
            }
            else if (temp.contains("Account Number")) {
            	String accNumber = temp.split(":")[1];
            	System.out.println("Customer account is "+accNumber);
            }
            
            else if (temp.contains("Statement Date")) {
            	String statementDate = temp.split(":")[1];
            	System.out.println("Statement date is "+statementDate.trim());
            }
            else if (temp.contains("Ending Balance")) {
            	String endingBal = temp.trim().split(" ")[6];
            	System.out.println("Ending Balance is "+ endingBal);

            }
            
            else if (temp.contains("Total ATM Withdrawals")) {
            	String totalWithdrawals = temp.trim().split("Debits")[1];
            	System.out.println("Total ATM Withdrawals & Debits are "+totalWithdrawals.trim());

            }
            
            else if (temp.contains("Total Deposits")) {
        	String totalDeposits = temp.trim().split("Credits")[1];
            	System.out.println("Total Deposits and Debits are "+totalDeposits.trim());

            }
            else if (temp.contains("Total Checks")) {
            	String totalChecks = temp.trim().split("Paid")[1];
            	System.out.println("Total Checks Paid are "+totalChecks.trim());

            }
           
          
            if (count == 1 || count == 2) {
            	String bankAddress1 = temp;
            	bankAddress = bankAddress+bankAddress1;
            }

            else if (count == 4 || count == 5) {
            	String custAddress1 = temp;
            	 custAddress = custAddress+custAddress1;
            	
            }
            count++;
        }
        System.out.println("Customer address is "+custAddress);
        System.out.println("Bank address is "+bankAddress);
        status = true;
    	return status;
    }    	
    	
}
