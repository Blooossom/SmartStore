package customer;

import group.Group;
import group.GroupType;
import group.Groups;

import java.util.LinkedList;
import java.util.List;

public class Customers {
    private List<Customer> customers;

    public Customers(){
        this.customers = new LinkedList<Customer>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int length(){
        return this.customers.size();
    }
    public void refresh(Groups groups){
        if (groups != null) {
            for (int i = 0; i <this.customers.size(); ++i) {
                Customer cust = this.customers.get(i);
                cust.setGroup(groups.findByGroupFor(cust));;
            }
        }
    }
    public Customer get(int i){
        return customers.get(i);
    }
    public boolean isNull(){
        return this.customers == null;
    }
    public boolean isEmpty(){
        return this.customers.size()==0;
    }

    public void add(Customer customer){
        this.customers.add(customer);
    }
    public void insert(int index, Customer customer) {
        if(index<this.customers.size()) {
            this.customers.add(index, customer);
        }else {
            this.customers.add(customer);
        }
    }

    public void update(int index, Customer customer){
      this.customers.set(index,customer);
    }
    public Customers findCustomers(GroupType groupType){
        Customers custs = new Customers();
        if (custs != null) {
            for (int i = 0; i <this.customers.size(); i++) {
                Customer cust = this.get(i);
                if (cust != null) {
                    Group grp = cust.getGroup();
                    if (groupType.equals(GroupType.NONE)) {
                        if (grp == null || grp.getGroupType() == null || grp.getGroupType().equals(GroupType.NONE)) {
                            custs.add(cust);
                        }
                    } else if (grp != null && grp.getGroupType().equals(groupType)) {
                        custs.add(cust);
                        }
                    }
                }
            }
        return custs;
        }

    public Customers findCustomers(Group grp){
        if (grp != null) {
            if (grp.getGroupType() != null) {
                return this.findCustomers(grp.getGroupType());
            }else{
                System.out.println("No GroupType!");
                return null;
            }
        }else{
            System.out.println("No Group!");
            return null;
        }
    }
    public void delete(int index){
        this.customers.remove(index);
    }
}
