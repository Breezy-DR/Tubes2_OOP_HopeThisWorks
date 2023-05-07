package tubes2;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFPrinter {
    public static void printFixedBill(FixedBill fixedBill, String filePath,String fileName) throws IOException,DocumentException {
        Document document=new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath+"/"+fileName));
        document.open();
        document.add(new Paragraph("Fixed Bill"));
        document.add(new Paragraph("Items: "));
        for (ElmtOfBill e :
                fixedBill.getlistBelanja()) {
            document.add(new Paragraph("-"+e.getNama()+" : "+e.getJumlah()));
        }
        document.close();
    }
}
