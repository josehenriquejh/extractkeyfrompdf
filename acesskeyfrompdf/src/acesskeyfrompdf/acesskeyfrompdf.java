
package acesskeyfrompdf;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFObjectStreamParser;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;





public class acesskeyfrompdf {
    
    public static void main(String[] args) {
    PDFParser parser = null;
    PDDocument pdDoc = null;
    COSDocument cosDoc = null;
    PDFTextStripper pdfStripper;

    String parsedText;
    String fileName = "E:\\Files\\Small Files\\PDF\\JDBC.pdf";
    
     
    
    
    File file = new File(fileName);
    try {
        RandomAccessFile raf = new RandomAccessFile("/text.txt", "r");


        InputStream is = Channels.newInputStream(raf.getChannel());
        PDFObjectStreamParser() 
        PDFParser
        
        parser = new PDFParser(new FileInputStream(file));
        parser.parse();
        cosDoc = parser.getDocument();
      
        pdDoc = PDDocument.load(new File("C:\\Users\\Henrique\\Desktop\\NF 199.985 A 200.003 GVI 0134 MAIKIÉL (REGIÃO DE ORLANDIA - T. E. SILVA REPRESENTAÇÕES) 02-04-2020.pdf"));
        pdfStripper = new PDFTextStripper();
        parsedText = pdfStripper.getText(pdDoc);
        System.out.println(parsedText.replaceAll("[^A-Za-z0-9. ]+", ""));
    } catch (Exception e) {
        e.printStackTrace();
        try {
            if (cosDoc != null)
                cosDoc.close();
            if (pdDoc != null)
                pdDoc.close();
        } catch (Exception e1) {
                e1.printStackTrace();
            }

        }

    }

}
