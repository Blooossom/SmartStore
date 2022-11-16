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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return minimumSpentTime == parameter.minimumSpentTime && minimumSpentMoney == parameter.minimumSpentMoney;
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
