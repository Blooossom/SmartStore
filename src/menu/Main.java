package menu;

import group.Groups;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public Main(){
    }
    public static void main(String[] args) throws IOException {
        System.out.println(ParameterMenu.allGroups.toString());
        while (true) {
            try{
                int choose = Menu.initMenu();
                if (choose == 1) {
                    CustomerMenu.inputCustomerMenu();
                } else if (choose == 2) {
                    ParameterMenu.inputParameterMenu();
                } else if (choose == 3) {
                    SummaryMenu.inputSummaryMenu();
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
