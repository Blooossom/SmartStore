package group;

public enum GroupType {
    NONE("NONE"),
    GENERAL("GENERAL"),
    VIP("VIP"),
    VVIP("VVIP");

    String groupType="";

    GroupType(String groupType){
        this.groupType=groupType;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }
}
