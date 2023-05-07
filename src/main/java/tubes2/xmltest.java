package tubes2;

public class xmltest {
    public static void main(String[] args){
//        IDataStore dataStore=new XMLDataStore();
//        FixedBill fixedBill=new FixedBill();
//        ElmtOfBill elmtOfBill=new ElmtOfBill("barang",1);
//        fixedBill.addListBelanja(elmtOfBill);
//        fixedBill.addListBelanja(elmtOfBill);
//        Customer customer=new RegisteredCustomer("tes","no",fixedBill);
//        customer.addHistoriTransaksi(fixedBill);
//        customer.addHistoriTransaksi(fixedBill);
//        CustomerList cl=new CustomerList();
//        DataStoreHub.setDataStore(new XMLDataStore());
//        cl.addCustomer(customer);
////        cl.addCustomer(customer);
//        DataStoreHub.writeCustomer(cl);
//        CustomerList customerList=DataStoreHub.readCustomer();
//        System.out.println(customerList.getCustomerList().get(0).getId());
//        Customer ucust=new UnregisteredCustomer(2,customer.getHistoriTransaksi());
//        Customer registered2=new RegisteredCustomer(2, ucust.getHistoriTransaksi(),true,"testes","123",0,true);
//        cl.addCustomer(customer);
//        cl.addCustomer(ucust);
//        dataStore.writeCustomer(cl);
//        CustomerList customerList=dataStore.readCustomer();
//        System.out.println(customerList.getCustomerList().get(0).getId());
//        dataStore.updateCustomer(registered2);
        Barang barang=new Barang(1,2,"barang",10,9,"tes","gambar");
        BarangList bl=new BarangList();
        bl.addBarang(barang);
        DataStoreHub.setDataStore(new XMLDataStore());
//        bl.addBarang(barang);
        DataStoreHub.writeBarang(bl);
        barang.addStok(10);
        DataStoreHub.updateBarang(barang);
        BarangList bl1=DataStoreHub.readBarang();
        System.out.println(bl1.getBarangList().get(0).getNamaBarang());
//        Fee fee=new Fee(0.5f,0.5f,0.5f);
//        DataStoreHub.setDataStore(new XMLDataStore());
//        DataStoreHub.updateFee(fee);
//        Fee fee1=DataStoreHub.readFee();
//        System.out.println(fee1.getDiscount());
//        Kurs kurs=new Kurs();
//        KursList kursList=new KursList();
//        kursList.addKurs(kurs);
////        kursList.addKurs(kurs);
//        DataStoreHub.setDataStore(new XMLDataStore());
//        DataStoreHub.writeKurs(kursList);
//        KursList kursList1=DataStoreHub.readKurs();
//        System.out.println(kursList1.getKursList().get(0).getKursToIDR());
    }
}
