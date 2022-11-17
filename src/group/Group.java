package group;

import customer.Customers;

import java.util.Objects;

public class Group {
    private GroupType groupType;
    private Parameter parameter;

    public Group(){this((GroupType)null,(Parameter)null);
    }

    public Group(GroupType groupType, Parameter parameter) {
        this.groupType = groupType;
        this.parameter = parameter;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
    public Customers getCustomers(Customers allCustomers){
        return allCustomers.findCustomers(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupType == group.groupType && Objects.equals(parameter, group.parameter);
    }
    @Override
    public String toString() {
        if(this.groupType==null){
            return "No group.";
        }else if (this.parameter==null){
            return "GroupType: "+this.groupType+"\nParameter: null";
        }else{
            GroupType var10000 = this.groupType;
            return "GroupType: " + var10000 + "\nParameter: "+this.parameter.toString();
        }
    }
}
