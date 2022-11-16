package group;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Groups {
    public ArrayList<Group> groups;
    public Groups() {
        this.groups = new ArrayList<>();
    }
    public void initialize(){
        int i = 0;
        GroupType[] groupTypes = GroupType.values();
        int size = groupTypes.length;
        for (int j = 0; j <size; ++j) {
            GroupType groupType = groupTypes[j];
            this.groups.add(i,new Group(groupType,(Parameter) null));
            ++i;
        }
    }
    public int length(){
        return this.groups.size();
    }
    public boolean isNullOrEmpty(){
        return this.groups==null||this.groups.size()==0;
    }
    public Group find(GroupType groupType){
        ArrayList<Group> groups = this.groups;
        for (int i = 0; i < groups.size(); i++) {
            Group grp = groups.get(i);
            if(grp.getGroupType()==groupType){
                return grp;
            }
        }return null;
    }

    public void add(Group group){
        Group grp = this.find(group.getGroupType());
        if (grp != null) {
            this.update(grp);
        }else{
            groups.add(grp);
        }
    }
    public void update(Group group){
        Group grp = this.find(group.getGroupType());
        if (grp != null) {
            grp.setParameter(grp.getParameter());
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.groups.size(); ++i) {
            str=str + " " + this.groups.get(i).toString()+"\n";
        }
        return str;
    }
}
