package menu;

import customer.Customer;
import customer.Customers;
import exception.InputEmptyException;
import exception.InputOutOfRangeException;
import group.Group;

import java.io.IOException;
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
                if(choose>=1&&choose<=4){
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
    public static Customers classify(){
       Customers groupByCustomers = new Customers();
        for (int i = 0; i <ParameterMenu.allGroups.size(); ++i) {
            Group grp = ParameterMenu.allGroups.get(i);
            groupByCustomers.get(i) = grp.getCustomers(CustomerMenu.allCustomers);
        }
        return groupByCustomers;
    }
    public static void viewSummary(){

    }
    public static String selectOrder()throws IOException{
        while(true){
            try{
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

    }
    public static void sortBySpentTime(OrderType orderType){

    }
    public static void sortBySpentMoney(OrderType orderType){

    }
}
