package menu;

import customer.Customer;
import customer.Customers;
import exception.InputEmptyException;
import exception.InputFormatException;
import group.Group;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class CustomerMenu extends Menu{

    public static Customers allCustomers = new Customers();
    public CustomerMenu(){
    }
    public static int initCustomerMenu()throws IOException {
        while (true) {
            try{
                System.out.println("================================");
                System.out.println("1. 고객 정보 설정");
                System.out.println("2. 고객 정보 출력");
                System.out.println("3. 고객 정보 변경");
                System.out.println("4. 고객 정보 삭제");
                System.out.println("5. 이전");
                System.out.println("================================");
                System.out.println("Choose one : ");
                int choose = Integer.parseInt(Menu.br.readLine());
                if(choose>=1&&choose<=5){
                    return choose;
                }
                throw new IndexOutOfBoundsException();
            }catch (IndexOutOfBoundsException err){
                System.out.println("\n범위를 벗어났습니다. 다시 입력해주세요");
            }catch (NumberFormatException err){
                System.out.println("\n잘못된 입력입니다. 다시 입력해주세요");
            }
        }
    }
    public static void inputCustomerMenu()throws IOException{
        while (true) {
            int choose = initCustomerMenu();
            if (choose == 1) {
                int size = getSizeOfCustomers();
                setCustomerData(size);
            } else if (choose == 2) {
                viewCustomerData();
            } else if (choose == 3) {
                updateCustomerData();
            } else if (choose == 4) {
                deleteCustomerData();
            }else{
                if (choose == 5) {
                    return;
                }
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }

    public static int getSizeOfCustomers()throws IOException {
        while (true) {
            try {
                System.out.println();
                System.out.println("================================");
                System.out.println("입력하실 고객의 인원수를 입력해주세요");
                System.out.println("최소 입력값은 1입니다.");
                System.out.println("================================");
                int size = Integer.parseInt(Menu.br.readLine());
                if (size < 0) {
                    throw new IndexOutOfBoundsException();
                }
                return size;
            } catch (IndexOutOfBoundsException err) {
                System.out.println("범위를 벗어났습니다. 다시 입력해주세요.");
            } catch (NumberFormatException err) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    public static void setCustomerData(int size)throws IOException{
        label2:
        for (int i = 0; i <size; ++i) {
            Customer customer = new Customer();
            System.out.println("\n======Customer "+(i+1)+" 님의 정보");

            while(true){
                while (true) {
                    int choose = displaySetCustomerMenu();
                    if (choose == 1) {
                        setCustomerName(customer);
                        break;
                    }
                    if (choose==2) {
                        setCustomerID(customer);
                        break;
                    }
                    if (choose == 3) {
                        setCustomerSpentMoney(customer);
                        break;
                    }
                    if (choose == 4) {
                        setCustomerSpentTime(customer);
                        break;
                    }
                    if (choose == 5) {
                        customer.setGroup(ParameterMenu.allGroups.findByGroupFor(customer));
                        allCustomers.add(customer);
                        System.out.println();
                        continue label2;
                    }
                    System.out.println("\n잘못된 입력입니다. 다시 입력해주세요");
                }
                Group grp = ParameterMenu.allGroups.findByGroupFor(customer);
                if(grp==null){
                    customer.setGroup((Group)null);
                } else if (!grp.equals(customer.getGroup())) {
                    customer.setGroup(grp);
                }
            }
        }
    }
    public static void viewCustomerData(){
        System.out.println("\n========== 고객 정보 ==========");
        for (int i = 0; i <allCustomers.length() ; ++i) {
            Customer cust = allCustomers.get(i);
            if (cust != null) {
                System.out.println("No. "+(i+1)+" => "+cust);
            }else {
                System.out.println("null");
            }
        }
    }
    public static void updateCustomerData(){

    }
    public static void deleteCustomerData()throws IOException{
        int allCustomerCount = allCustomers.length();
        viewCustomerData();
        int custNo = findCustomer(allCustomerCount);
        if (custNo>=1&&custNo<=allCustomerCount){

        }
    }
    public static int findCustomer(int allUserCount)throws IOException{
        while (true){
            try {
                System.out.println();
                System.out.println("Which customer ( 1 ~ "+allUserCount+" )? ");
                int customerNo = Integer.parseInt(Menu.br.readLine());
                return customerNo;
            }catch (NumberFormatException err){
                System.out.println("\n잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    public static void setCustomerName(Customer customer)throws IOException{
        while(true){
            try {
                System.out.println();
                System.out.println("고객의 이름을 입력해주세요.");
                String REGEX = "^[a-zA-Z]{3,}$";
                String customerName = Menu.br.readLine();
                if(customerName!=null&&!customerName.equals("")){
                    if(Pattern.matches(REGEX,customerName)){
                        customer.setCustomerName(customerName);
                        return;
                    }
                    throw new InputFormatException();
                }
                throw new InputEmptyException();
            }catch (InputFormatException err){
                System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
            }catch (InputEmptyException err){
                System.out.println("입력을 하지 않았습니다. 다시 입력해주세요.");
            }
        }
    }
    public static void setCustomerID(Customer customer)throws IOException{
        while (true){
            try {
                System.out.println();
                System.out.println("고객의 ID를 입력해주세요.");
                String REGEX = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}";
                String userID = Menu.br.readLine();
                if (userID!=null&&userID.equals("")){
                    if (Pattern.matches(REGEX, userID)) {
                        customer.setCustomerID(userID);
                        return;
                    }
                    throw new InputFormatException();
                }
                throw new InputEmptyException();
            }catch (InputFormatException err){
                System.out.println("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
            }catch (InputEmptyException err){
                System.out.println("입력을 하지 않았습니다. 다시 입력해주세요");
            }
        }
    }
    public static void setCustomerSpentTime(Customer customer)throws IOException{
        while (true) {
            try{
                System.out.println();
                System.out.println("고객의 이용시간을 입력해주세요.");
                int spentTime = Integer.parseInt(Menu.br.readLine());
                if(spentTime<0){
                    throw new IndexOutOfBoundsException();
                }
                customer.setSpentTime(spentTime);
                return;
            }catch (IndexOutOfBoundsException err){
                System.out.println("시간은 0보다 작을 수 없습니다. 다시 입력해주세요.");
            }catch (NumberFormatException err){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    public static void setCustomerSpentMoney(Customer customer)throws IOException{
        while (true){
            try {
                System.out.println();
                System.out.println("고객의 이용금액을 입력해주세요");
                int spentMoney= Integer.parseInt(Menu.br.readLine());
                if(spentMoney<0){
                    throw new IndexOutOfBoundsException();
                }
                customer.setSpentMoney(spentMoney);
                return;
            }catch (IndexOutOfBoundsException err){
                System.out.println("금액은 0보다 작을 수 없습니다. 다시 입력해주세요.");
            }catch (NumberFormatException err){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    public static int displaySetCustomerMenu()throws IOException{
        while (true) {
            try{
                System.out.println("================================");
                System.out.println("1. 고객 이름 설정");
                System.out.println("2. 고객 ID 설정");
                System.out.println("3. 고객 이용시간 입력");
                System.out.println("4. 고객 이용금액 입력");
                System.out.println("5. 이전");
                System.out.println("================================");
                System.out.println("Choose one : ");
                int choose = Integer.parseInt(Menu.br.readLine());
                if(choose>=1&&choose<=5){
                    return choose;
                }
                throw new IndexOutOfBoundsException();
            }catch (IndexOutOfBoundsException err){
                System.out.println("범위를 벗어났습니다. 다시 입력해주세요");
            }catch (NumberFormatException err){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
