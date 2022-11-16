package menu;

import group.Group;
import group.GroupType;
import group.Groups;
import group.Parameter;

import java.io.IOException;
import java.util.NoSuchElementException;

public class ParameterMenu extends Menu{

    public static Groups allGroups = new Groups();
    public ParameterMenu(){
    }
    public static int initParameterMenu()throws IOException {
        while (true) {
            try{
                System.out.println("================================");
                System.out.println("1. 파라미터 설정");
                System.out.println("2. 현재 파라미터 보기");
                System.out.println("3. 파라미터 변경");
                System.out.println("4. 이전으로");
                System.out.println("================================");
                System.out.println("Choose one : ");
                int choose = Integer.parseInt(Menu.br.readLine());
                if(choose>=1&&choose<=4){
                    return choose;
                }
                throw new IndexOutOfBoundsException();
            }catch (NumberFormatException err){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            }catch (IndexOutOfBoundsException err){
                System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
            }
        }
    }
    public static void inputParameterMenu()throws IOException{
        while (true) {
            int choose=initParameterMenu();
            if (choose == 1) {
                setParameterManage();
            } else if (choose==2) {
                viewParameter();
            } else if (choose == 3) {
                updateParameter();
            }else if (choose == 4){
                return;
            }else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static String selectGroup()throws IOException {
        while (true) {
            try {
                System.out.println("================================");
                System.out.println("설정할 그룹을 선택해주세요.");
                System.out.println("NONE, GENERAL, VIP, VVIP");
                System.out.println("종료를 원하시면 \"END\" 를 입력해주세요");
                System.out.println("================================");
                String select = Menu.br.readLine().toUpperCase();
                if (select == null) {
                    throw new NullPointerException();
                }
                if (select.equals("")) {
                    throw new NoSuchElementException();
                }
                if (select.equals("END")) {
                    return select;
                }
                for (int i = 0; i < GroupType.values().length; i++) {
                    if (select != null && select.equals(GroupType.values()[i].toString())) {
                        return select;
                    }
                }
            } catch (NullPointerException err) {
                System.out.println("입력을 하지 않았습니다. 다시 입력해주세요.");
            } catch (NoSuchElementException err) {
                System.out.println("입력값이 없습니다. 다시 입력해주세요.");
            }
        }
    }

    public static int setParameterMenu()throws IOException{
        while(true){
            try{
                System.out.println("================================");
                System.out.println("1. 최소 시간 설정");
                System.out.println("2. 최소 금액 설정");
                System.out.println("3. 이전으로");
                System.out.println("================================");
                int choose = Integer.parseInt(Menu.br.readLine());
                if(choose>=1&&choose<=3){
                    return choose;
                }
                throw new IndexOutOfBoundsException();
            }catch (NumberFormatException err){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }catch (IndexOutOfBoundsException err){
                System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
            }
        }
    }

    public static void setParameterManage()throws IOException{
        while(true){
        String selGroup = selectGroup().toUpperCase();
        if(selGroup.equals("END")){
            return;
        }
        GroupType groupType;
        try{
            groupType=GroupType.valueOf(selGroup);
        }catch (IllegalArgumentException err){
            System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
            continue;
        }
        Group grp = allGroups.find(groupType);
            if (grp != null&&grp.getParameter()!=null) {
                System.out.println("\n"+selGroup+"이미 설정되어 있는 그룹입니다. 다시 선택해주세요.");
                System.out.println("\n"+grp);
            }else {
                Parameter parameter = new Parameter();
                while(true){
                    try{
                        int choose = setParameterMenu();
                        if (choose == 1) {
                            setMinimumSpentTime(parameter);
                        } else if (choose == 2) {
                            setMinimumSpentMoney(parameter);
                        } else if (choose == 3) {
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                    }catch (NumberFormatException err){
                        System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
                    }catch (IndexOutOfBoundsException err){
                        System.out.println("\n범위를 벗어난 입력입니다. 다시 입력해주세요.");
                        Menu.br.readLine();
                    }
                    allGroups.add(new Group(groupType,parameter));
                    CustomerMenu.allCustomers.refresh(allGroups);
                }
            }
        }
    }
    public static void viewParameter()throws IOException{
        while(true){
            String selGroup = selectGroup().toUpperCase();
            if(selGroup.equals("END")){
                return;
            }
            GroupType groupType;
            try{
                groupType=GroupType.valueOf(selGroup);
            }catch (IllegalArgumentException err){
                System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }
            Group grp = allGroups.find(groupType);
            System.out.println();
            System.out.println(grp);
        }
    }
    public static void updateParameter()throws IOException{
        while(true) {
            String selGroup = selectGroup().toUpperCase();
            if (selGroup.equals("END")) {
                return;
            }
            GroupType groupType;
            try {
                groupType = GroupType.valueOf(selGroup);
            } catch (IllegalArgumentException err) {
                System.out.println("\n잘못된 입력입니다. 다시 입력해주세요");
                continue;
            }
            Group grp = allGroups.find(groupType);
            if(grp.getParameter()==null){
                System.out.println("\n선택하신 그룹의 파라미터가 설정되지 않았습니다. 파라미터를 먼저 설정해주세요.");
            }else{
                System.out.println("\n"+grp.toString());
                Parameter parameter = grp.getParameter();

                label1:
                while (true){
                    try{
                        int choose = setParameterMenu();
                        if (choose == 1) {
                            setMinimumSpentTime(parameter);
                        } else if (choose == 2) {
                            setMinimumSpentMoney(parameter);
                        } else if (choose == 3) {
                            break label1;
                        }else{
                            throw new IndexOutOfBoundsException();
                        }
                    }catch (IndexOutOfBoundsException err){
                        System.out.println("\n범위를 벗어났습니다. 다시 선택해주세요.");
                        Menu.br.readLine();
                    }
                }
            }
            CustomerMenu.allCustomers.refresh(allGroups);
            System.out.println("\n"+grp.toString());
        }
    }
    public static void setMinimumSpentTime(Parameter parameter)throws IOException{
        while(true){
            try{
                System.out.println("================================");
                System.out.println("설정할 최소 이용시간을 입력해주세요.");
                System.out.println("================================");
                int time = Integer.parseInt(Menu.br.readLine());
                if(time<0){
                    throw new IndexOutOfBoundsException();
                }else{
                    parameter.setMinimumSpentTime(time);
                    return;
                }
            }catch (IndexOutOfBoundsException err){
                System.out.println("\n이용시간은 0보다 작을 수 없습니다. 다시 입력해주세요.");
            }catch (NumberFormatException err){
                System.out.println("\n잘못된 입력값입니다. 다시 입력해주세요");
            }
        }
    }
    public static void setMinimumSpentMoney(Parameter parameter)throws IOException{
        while(true){
            try{
                System.out.println("================================");
                System.out.println("설정할 최소 이용금액을 입력해주세요.");
                System.out.println("================================");
                int money = Integer.parseInt(Menu.br.readLine());
                if(money<0){
                    throw new IndexOutOfBoundsException();
                }else{
                    parameter.setMinimumSpentMoney(money);
                    return;
                }
            }catch (IndexOutOfBoundsException err){
                System.out.println("이용금액은 0보다 작을 수 없습니다. 다시 입력해주세요.");
            }catch (NumberFormatException err){
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
            }
        }
    }
}
