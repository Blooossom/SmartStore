package menu;

import customer.Customer;
import customer.Customers;
import exception.InputEmptyException;
import exception.InputOutOfRangeException;
import group.Group;
import group.GroupType;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SummaryMenu extends Menu{
    public SummaryMenu(){
    }
    public static int initSummaryMenu()throws IOException {
        while (true) {
            try{
                System.out.println("================================");
                System.out.println("1. 현재 정보 출력");
                System.out.println("2. 이름 순 출력");
                System.out.println("3. 시간 순 출력");
                System.out.println("4. 금액 순 출력");
                System.out.println("5. 이전으로");
                System.out.println("================================");
                System.out.println("Choose one : ");
                int choose= Integer.parseInt(Menu.br.readLine());
                if(choose>=1&&choose<=5){
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

    public static void inputSummaryMenu()throws IOException{
        while(true){
            int choose=initSummaryMenu();
            if (choose == 1) {
                viewSummary(classify());
            } else if (choose == 2) {
                manageSortByName();
            } else if (choose == 3) {
                manageSortBySpentTime();
            } else if (choose == 4) {
                manageSortBySpentMoney();
            } else if (choose == 5) {
                return;
            } else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            }
        }
    }
    public static List<Customers> classify(){
        List<Customers> groupByCustomers = new LinkedList<>();
        for (int i = 0; i <ParameterMenu.allGroups.size(); ++i) {
            Group grp = ParameterMenu.allGroups.get(i);
            groupByCustomers.add(grp.getCustomers(CustomerMenu.allCustomers));
        }
        return groupByCustomers;
    }
    public static void viewSummary(List<Customers> groupByCustomers){
        System.out.println();

        for (int i = 0; i < ParameterMenu.allGroups.size(); ++i) {
            Group grp = ParameterMenu.allGroups.get(i);
            int customerCount = 0;
            if(groupByCustomers!=null&&!groupByCustomers.isEmpty()){
                customerCount = groupByCustomers.get(i).getCustomers().size();
            }
            System.out.println();
            System.out.println("==========================");
            if (grp.getGroupType().equals(GroupType.NONE)) {
                System.out.println("Others : "+customerCount+" customer(s)");
            }else{
                PrintStream var = System.out;
                String var1 = grp.getGroupType().toString();
                var.println(var1 + " Group : "+customerCount + " customer(s)");
                if (grp.getParameter() == null) {
                    System.out.println("[Parameter] null");
                }else{
                    System.out.println("[Parameter] " + grp.getParameter().toString());
                }
            }
            System.out.println("============================");
            if(groupByCustomers != null && !groupByCustomers.isEmpty()){
                for (int j = 0; j < customerCount; ++j) {
                    for (int k = 0; k <groupByCustomers.get(j).length() ; ++k) {
                        Customer cust = groupByCustomers.get(j).get(k);
                        if (cust != null) {
                            System.out.println("No. "+(j+1)+" => "+cust);
                        }
                    }
                }
            }else{
                System.out.println("No customer.");
            }
        }
    }
    public static String selectOrder()throws IOException{
        while(true){
            try{
                System.out.println();
                System.out.println("** Press 'end', if you want to exit! **");
                System.out.print("Which order (UP, DOWN)? ");
                String choose = Menu.br.readLine().toUpperCase();
                if(choose==null){
                    throw new NullPointerException();
                }
                if(choose.equals("")){
                    throw new InputEmptyException();
                }
                if(choose.equals("END")){
                    return choose;
                }
                try{
                    OrderType orderType = OrderType.valueOf(choose);
                    for (int i = 0; i <OrderType.values().length; i++) {
                        if(orderType==OrderType.values()[i]){
                            return choose;
                        }
                    }
                }catch (IllegalArgumentException err){
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            }catch (NullPointerException err){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }catch (InputEmptyException err){
                System.out.println("입력을 하지 않았습니다. 다시 입력해주세요.");
            }catch (InputOutOfRangeException err){
                System.out.println("입력값이 범위를 벗어났습니다. 다시 입력해주세요.");
            }
        }
    }

    public static void manageSortByName()throws IOException{
        while (true){
            String select = selectOrder().toUpperCase();
            if (select.equals("END")) {
                return;
            }
            try{
                OrderType orderType = OrderType.valueOf(select);
                if(orderType==OrderType.UP){
                    System.out.println("UP");
                    sortByName(OrderType.UP);
                }else{
                    System.out.println("DOWN");
                    sortByName(OrderType.DOWN);
                }
            }catch (IllegalArgumentException err){
                System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    public static void manageSortBySpentTime()throws IOException {
        while(true){
            String select = selectOrder().toUpperCase();
            if(select.equals("END")){
                return;
            }
            try{
                OrderType orderType = OrderType.valueOf(select);
                if (orderType==OrderType.UP){
                    System.out.println("UP");
                    sortBySpentTime(OrderType.UP);
                } else if (orderType == OrderType.DOWN) {
                    System.out.println("DOWN");
                    sortBySpentTime(OrderType.DOWN);
                }else{
                    throw new InputOutOfRangeException();
                }
            }catch (InputOutOfRangeException err){
                System.out.println("\n범위를 벗어났습니다. UP과 DOWN 둘 중 하나를 입력해주세요.");
            }
        }
    }
    public static void manageSortBySpentMoney()throws IOException{
        while(true){
            String select = selectOrder().toUpperCase();
            if (select.equals("END")) {
                return;
            }
            try{
                OrderType orderType=OrderType.valueOf(select);
                if(orderType==OrderType.UP){
                    System.out.println("UP");
                    sortBySpentMoney(OrderType.UP);
                }else{
                    System.out.println("DOWN");
                    sortBySpentMoney(OrderType.DOWN);
                }
            }catch (IllegalArgumentException err){
                System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void sortByName(OrderType orderType){
        List<Customers> groupByCustomers = classify();
        if (orderType != null && !orderType.equals("")) {
            for (int i = 0; i <groupByCustomers.size(); ++i) {
                List<Customer> customers = groupByCustomers.get(i).getCustomers();
                if(orderType==OrderType.UP){
                    Collections.sort(customers, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            return o1.getCustomerName().compareTo(o2.getCustomerName());
                        }
                    });
                }else{
                    Collections.sort(customers, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            return o1.getCustomerName().compareTo(o2.getCustomerName())*-1;
                        }
                    });
                }
                groupByCustomers.get(i).setCustomers(customers);
            }
            viewSummary(groupByCustomers);
        }

    }
    public static void sortBySpentTime(OrderType orderType){
        List<Customers> groupByCustomers = classify();
        if(orderType!=null&&!orderType.equals("")){
            for (int i = 0; i < groupByCustomers.size(); i++) {
                List<Customer> customers = groupByCustomers.get(i).getCustomers();
                if(orderType==OrderType.UP){
                    Collections.sort(customers, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            if(o1.getSpentTime()<o2.getSpentTime()){
                                return -1;
                            }else if(o1.getSpentTime()==o2.getSpentTime()){
                                return o1.getCustomerName()!=null&&o2.getCustomerName()!=null? o1.getCustomerName().compareTo(o2.getCustomerName()):0;
                            }else{
                                return 1;
                            }
                        }
                    });
                }else{
                    Collections.sort(customers, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            if(o1.getSpentTime()<o2.getSpentTime()){
                                return 1;
                            }else if(o1.getSpentTime()==o2.getSpentTime()){
                                return o1.getCustomerName()!=null&&o2.getCustomerName()!=null? o1.getCustomerName().compareTo(o2.getCustomerName()):0;
                            }else{
                                return -1;
                            }
                        }
                    });
                }
                groupByCustomers.get(i).setCustomers(customers);
            }
            viewSummary(groupByCustomers);
        }
    }
    public static void sortBySpentMoney(OrderType orderType){
        List<Customers> groupByCustomers = classify();
        if (orderType != null && !orderType.equals("")) {
            for (int i = 0; i <groupByCustomers.size(); ++i) {
                List<Customer> customers = groupByCustomers.get(i).getCustomers();
                if (orderType == OrderType.UP) {
                    Collections.sort(customers, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            if(o1.getSpentMoney()<o2.getSpentMoney()){
                                return -1;
                            }else if(o1.getSpentMoney()==o2.getSpentMoney()){
                                return o1.getCustomerName()!=null&&o2.getCustomerName()!=null? o1.getCustomerName().compareTo(o2.getCustomerName()):0;
                            }else{
                                return 1;
                            }
                        }
                    });
                }else{
                    Collections.sort(customers, new Comparator<Customer>() {
                        @Override
                        public int compare(Customer o1, Customer o2) {
                            if(o1.getSpentMoney()<o2.getSpentMoney()){
                                return 1;
                            } else if (o1.getSpentMoney() == o2.getSpentMoney()) {
                                return o1.getCustomerName()!=null&&o2.getCustomerName()!=null? o1.getCustomerName().compareTo(o2.getCustomerName()):0;
                            }else{
                                return -1;
                            }
                        }
                    });
                }
                groupByCustomers.get(i).setCustomers(customers);
            }
            viewSummary(groupByCustomers);
        }
    }
}
