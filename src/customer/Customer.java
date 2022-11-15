package customer;

import java.util.Objects;

public class Customer {
    private String customerNo;
    private String customerName;
    private String customerID;
    private int spentTime;
    private int spentMoney;
    public Customer(){
    }

    public Customer(String customerNo, String customerName, String customerID, int spentTime, int spentMoney) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.customerID = customerID;
        this.spentTime = spentTime;
        this.spentMoney = spentMoney;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }

    public int getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(int spentMoney) {
        this.spentMoney = spentMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return spentTime == customer.spentTime && spentMoney == customer.spentMoney && customerNo.equals(customer.customerNo) && customerName.equals(customer.customerName) && customerID.equals(customer.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNo, customerName, customerID, spentTime, spentMoney);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNo='" + customerNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerID='" + customerID + '\'' +
                ", spentTime=" + spentTime +
                ", spentMoney=" + spentMoney +
                '}';
    }
}
