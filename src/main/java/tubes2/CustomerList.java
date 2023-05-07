package tubes2;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customerListClass")
public class CustomerList implements Serializable {
    private List<Customer> customerList;

    public CustomerList(){
        this.customerList=new ArrayList<>();
    }
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }
    public void updateCustomer(Customer customer){
        for (Customer c :
                this.customerList) {
            if (c.getId() == customer.getId()) {
                this.customerList.remove(c);
                this.customerList.add(customer);
                break;
            }
        }
    }
    public Customer getCustomerByID(int id){
        return this.customerList.stream()
                .filter(customer -> customer.getId()==id)
                .findFirst()
                .orElse(null);
    }
    public void insertDummy(){
        FixedBill fixedBill=new FixedBill();
        ElmtOfBill elmtOfBill=new ElmtOfBill("dummy",-1);
        fixedBill.addListBelanja(elmtOfBill);
        fixedBill.addListBelanja(elmtOfBill);
        List<FixedBill> fixedBillList=new ArrayList<>();
        fixedBillList.add(fixedBill);
        fixedBillList.add(fixedBill);
        Customer customer=new RegisteredCustomer(-1,fixedBillList,false,"dummy","-",0,false);
        this.customerList.add(0, customer);
        this.customerList.add(0, customer);
    }
    public void removeDummy(){
        List<Customer> newCustomerList=new ArrayList<>();
        for (Customer c :
                this.customerList) {
            if (c.getId()!=-1){
                newCustomerList.add(c);
            }
        }
        this.customerList=newCustomerList;
    }
}
