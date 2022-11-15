package menu;

import java.io.IOException;

public class CustomerMenu extends Menu{
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

            } else if (choose == 2) {

            } else if (choose == 3) {

            } else if (choose == 4) {

            }else{
                if (choose == 5) {
                    return;
                }
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
            }
        }
    }
}
