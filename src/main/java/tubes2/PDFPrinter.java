package tubes2;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfObject;
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
    public static void printLaporanPenjualan(CustomerList customerList,String filePath,String fileName)throws IOException,DocumentException{
        Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream(filePath+"/"+fileName));
        document.open();
        document.add(new Paragraph("Laporan Penjualan: "));
        for (Customer c :
                customerList.getCustomerList()) {
            document.add(new Paragraph("Customer ID: "+c.getId()));
            if (c instanceof RegisteredCustomer){
                RegisteredCustomer temp=(RegisteredCustomer) c;
                document.add(new Paragraph("   vip: "+temp.isVIP()));
                document.add(new Paragraph("   nama: "+temp.getNama()));
                document.add(new Paragraph("   nomorTelepon: "+temp.getNomorTelepon()));
                document.add(new Paragraph("   poin: "+temp.getPoin()));
                document.add(new Paragraph("   aktif: "+temp.isAktif()));
            }
            document.add(new Paragraph("   Fixed Bill: "));
            for (int i=0;i<c.getHistoriTransaksi().size();i++){
                document.add(new Paragraph("     Fixed Bill "+(i+1)));
                for (ElmtOfBill e :
                        c.getHistoriTransaksi().get(i).getlistBelanja()) {
                    document.add(new Paragraph("       Nama Barang: "+e.getNama()+", Jumlah: "+e.getJumlah()));
                }
            }
        }
        document.close();
    }
}
