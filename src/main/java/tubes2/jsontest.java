package tubes2;

public class jsontest {
    public static void main(String[] args){
        IDataStore dataStore=new JSONDataStore();
        FixedBill fixedBill=new FixedBill();
        ElmtOfBill elmtOfBill=new ElmtOfBill("barang",1);
        fixedBill.addListBelanja(elmtOfBill);
        fixedBill.addListBelanja(elmtOfBill);
        Customer customer=new RegisteredCustomer("tes","no",fixedBill);
        customer.addHistoriTransaksi(fixedBill);
        customer.addHistoriTransaksi(fixedBill);
        CustomerList cl=new CustomerList();
        Customer ucust=new UnregisteredCustomer(2,customer.getHistoriTransaksi());
        Customer registered2=new RegisteredCustomer(2, ucust.getHistoriTransaksi(),true,"testes","123",0,true);
        cl.addCustomer(customer);
        cl.addCustomer(ucust);
        dataStore.writeCustomer(cl);
        dataStore.updateCustomer(registered2);
        Barang barang=new Barang(1,2,"barang",10,9,"tes","gambar");
        BarangList bl=new BarangList();
        bl.addBarang(barang);
        bl.addBarang(barang);
        dataStore.writeBarang(bl);
        barang.addStok(10);
        dataStore.updateBarang(barang);
//        BarangList bl=dataStore.readBarang();
    }
}