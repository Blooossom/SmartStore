package menu;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public Main(){
    }
    public static void main(String[] args) throws IOException {
        while (true) {
            try{
                int choose = Menu.initMenu();
                if (choose == 1) {
                    CustomerMenu.initCustomerMenu();
                } else if (choose == 2) {
                    ParameterMenu.initParameterMenu();
                } else if (choose == 3) {
                    SummaryMenu.initSummaryMenu();
                }else{
                    if (choose == 4) {
                        System.out.println("\n프로그램 종료");
                        break;
                    }
                    System.out.println("\n잘못된 입력입니다. 다시 시도해주세요.");
                }
            }catch (InputMismatchException err){
                System.out.println("\n잘못된 입력입니다. 다시 시도해주세요.");
                Integer.parseInt(Menu.br.readLine());
            }
        }
        Menu.br.close();;
    }
}
