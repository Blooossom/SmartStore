package customer;

import group.Groups;

import java.util.LinkedList;
import java.util.List;

public class Customers {
    public static int SIZE = 10;
    private int count;
    private List<Customer> customers;

    public Customers(){
        this.customers = new LinkedList<Customer>();
    }

    public int getCount() {
        return count;
    }

    public List<Customer> getCustomerList() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int length(){
        return this.customers.size();
    }
    public void refresh(Groups groups){

    }
}
