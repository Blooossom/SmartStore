package group;

public class Group {
    private GroupType groupType;
    private Parameter parameter;

    public Group(){
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
}
