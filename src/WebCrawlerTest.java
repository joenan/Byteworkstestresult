
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.whois.WhoisClient;
import com.itextpdf.text.Document;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nandom Gusen
 */
public class WebCrawlerTest {

    public static void main(String[] args) throws Exception {
        //WebCrawler wb = new WebCrawler();
        System.out.println(getWhois("facebook.com"));
        System.out.println("Done");

        //Write file to PDF
        boolean file = new File("C:/Itext").mkdirs();  // This will create the output directory if it does not exist
        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("C:/Itext/DomainHookup.pdf")); //This will write the domain information in pdf
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add(getWhois("facebook.com"));
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        document.close();

    }

    public static String getWhois(String domainName) {

        StringBuilder result = new StringBuilder("");

        WhoisClient whois = new WhoisClient();
        try {

            //default is internic.net
            whois.connect(WhoisClient.DEFAULT_HOST);
            String whoisData1 = whois.query("=" + domainName);
            result.append(whoisData1);
            whois.disconnect();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    public static void printInPDF() throws FileNotFoundException, DocumentException {

    }
}
