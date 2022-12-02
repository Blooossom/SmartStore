package group;

import java.util.Objects;

public class Parameter {
    private int minimumSpentTime;
    private int minimumSpentMoney;

    public Parameter(){
    }

    public Parameter(int minimumSpentTime, int minimumSpentMoney) {
        this.minimumSpentTime = minimumSpentTime;
        this.minimumSpentMoney = minimumSpentMoney;
    }

    public int getMinimumSpentTime() {
        return minimumSpentTime;
    }

    public void setMinimumSpentTime(int minimumSpentTime) {
        this.minimumSpentTime = minimumSpentTime;
    }

    public int getMinimumSpentMoney() {
        return minimumSpentMoney;
    }

    public void setMinimumSpentMoney(int minimumSpentMoney) {
        this.minimumSpentMoney = minimumSpentMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Parameter parameter = (Parameter)o;
            return this.minimumSpentTime == parameter.minimumSpentTime && this.minimumSpentMoney == parameter.minimumSpentMoney;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumSpentTime, minimumSpentMoney);
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "minimumSpentTime=" + minimumSpentTime +
                ", minimumSpentMoney=" + minimumSpentMoney +
                '}';
    }
}
