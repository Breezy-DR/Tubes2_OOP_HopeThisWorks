package tubes2;

public class jsontest {
    public static void main(String[] args){
//        IDataStore dataStore=new JSONDataStore();
        FixedBill fixedBill=new FixedBill();
        ElmtOfBill elmtOfBill=new ElmtOfBill("barang",1,1000);
        fixedBill.addListBelanja(elmtOfBill);
        fixedBill.addListBelanja(elmtOfBill);
        Customer customer=new RegisteredCustomer("tes","no",fixedBill);
        customer.addHistoriTransaksi(fixedBill);
        customer.addHistoriTransaksi(fixedBill);
        CustomerList cl=new CustomerList();
        cl.addCustomer(customer);
        DataStoreHub.writeCustomer(cl);
//        Customer ucust=new UnregisteredCustomer(2,customer.getHistoriTransaksi());
//        Customer registered2=new RegisteredCustomer(2, ucust.getHistoriTransaksi(),true,"testes","123",0,true);
//        cl.addCustomer(customer);
//        cl.addCustomer(ucust);
//        DataStoreHub.writeCustomer(cl);
//        DataStoreHub.updateCustomer(registered2);
//        IDataStore xmlDataStore=new XMLDataStore();
//        DataStoreHub.setDataStore(xmlDataStore);
//        CustomerList cl=DataStoreHub.readCustomer();
//        System.out.println(cl.getCustomerList().get(0).getId());
//        Barang barang=new Barang(1,2,"barang",10,9,"tes","gambar");
//        BarangList bl=new BarangList();
//        bl.addBarang(barang);
//        bl.addBarang(barang);
//        dataStore.writeBarang(bl);
//        barang.addStok(10);
//        dataStore.updateBarang(barang);
//        BarangList bl=dataStore.readBarang();
//        Fee fee=new Fee(0.5f,0.5f,0.5f);
//        DataStoreHub.updateFee(fee);
//        Fee fee1=DataStoreHub.readFee();
//        System.out.println(fee1.getDiscount());
//        Kurs kurs=new Kurs();
//        KursList kursList=new KursList();
//        kursList.addKurs(kurs);
//        DataStoreHub.writeKurs(kursList);
//        KursList kursList1=DataStoreHub.readKurs();
//        System.out.println(kursList1.getKursList().get(0).getKursToIDR());
//        Customer customer=new RegisteredCustomer();
    }
}
