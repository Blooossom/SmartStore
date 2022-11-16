package menu;

import java.io.IOException;

public class ParameterMenu extends Menu{
    public ParameterMenu(){
    }
    public static int initParameterMenu()throws IOException {
        while (true) {
            try{
                System.out.println("================================");
                System.out.println("1. 최소 이용금액 설정");
                System.out.println("2. 최소 이용시간 설정");
                System.out.println("3. 이전으로");
                System.out.println("================================");
                System.out.println("Choose one : ");
                int choose = Integer.parseInt(Menu.br.readLine());
                if(choose>=1&&choose<=3){
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

            } else if (choose==2) {

            } else if (choose == 3) {
                return;
            }else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
