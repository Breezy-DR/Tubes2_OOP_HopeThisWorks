package tubes2;


public class objtest {
    public static void main(String[] args){
//        IDataStore dataStore=new OBJDataStore();
//        FixedBill fixedBill=new FixedBill();
//        ElmtOfBill elmtOfBill=new ElmtOfBill("barang",1);
//        fixedBill.addListBelanja(elmtOfBill);
//        fixedBill.addListBelanja(elmtOfBill);
//        Customer customer=new RegisteredCustomer("tes","no",fixedBill);
//        customer.addHistoriTransaksi(fixedBill);
//        customer.addHistoriTransaksi(fixedBill);
//        CustomerList cl=new CustomerList();
//        Customer ucust=new UnregisteredCustomer(2,customer.getHistoriTransaksi());
//        Customer registered2=new RegisteredCustomer(2, ucust.getHistoriTransaksi(),true,"testes","123",0,true);
//        cl.addCustomer(customer);
//        cl.addCustomer(ucust);
//        dataStore.writeCustomer(cl);
//        CustomerList customerList=dataStore.readCustomer();
//        System.out.println(customerList.getCustomerList().get(0).getId());
//        dataStore.updateCustomer(registered2);
//        Barang barang=new Barang(1,2,"barang",10,9,"tes","gambar");
//        BarangList bl=new BarangList();
//        bl.addBarang(barang);
//        bl.addBarang(barang);
//        dataStore.writeBarang(bl);
//        barang.addStok(10);
//        dataStore.updateBarang(barang);
//        BarangList bl1=dataStore.readBarang();
//        System.out.println(bl1.getBarangList().get(0).getNamaBarang());
//        System.out.println(bl1.getBarangList().get(0).getStok());
//        IDataStore objDataStore=new OBJDataStore();
//        DataStoreHub.setDataStore(objDataStore);
//        BarangList barangList=DataStoreHub.readBarang();
//        DataStoreHub.setFilePath("src/main/java/tubes2");
//        IDataStore jsonDataStore=new JSONDataStore();
//        DataStoreHub.setDataStore(jsonDataStore);
//        DataStoreHub.writeBarang(barangList);
//        DataStoreHub.setDataStore(new OBJDataStore());
//        Fee fee=new Fee(0.5f,0.5f,0.5f);
//        DataStoreHub.updateFee(fee);
//        Fee fee1=DataStoreHub.readFee();
//        System.out.println(fee1.getDiscount());
        DataStoreHub.saveJarPath("src/main/java/tubes2");
        System.out.println(DataStoreHub.getJarPath());
    }
}
