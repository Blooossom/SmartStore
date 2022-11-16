package menu;

import customer.Customer;
import customer.Customers;

import java.io.IOException;

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
    public static void setCustomerData(int size){

    }
    public static void viewCustomerData(){

    }
    public static void updateCustomerData(){

    }
    public static void deleteCustomerData(){

    }
    public static int findCustomer(int allUserCount)throws IOException{
        int customerNo = Integer.parseInt(Menu.br.readLine());
        return customerNo;
    }
}
