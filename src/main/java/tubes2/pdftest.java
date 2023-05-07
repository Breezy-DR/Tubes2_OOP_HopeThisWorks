package tubes2;

public class pdftest {
    public static void main(String[] args){
//        FixedBill fixedBill=new FixedBill();
//        ElmtOfBill elmtOfBill=new ElmtOfBill("barang1",10);
//        ElmtOfBill elmtOfBill2=new ElmtOfBill("barang2",5);
//        fixedBill.addListBelanja(elmtOfBill);
//        fixedBill.addListBelanja(elmtOfBill2);
//        try {
//            PDFPrinter.printFixedBill(fixedBill,"src/main/java/tubes2/data","tes.pdf");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        try{
            IDataStore dataStore=new JSONDataStore();
            CustomerList customerList=dataStore.readCustomer();
            PDFPrinter.printLaporanPenjualan(customerList,"src/main/java/tubes2/data","laporan.pdf");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
