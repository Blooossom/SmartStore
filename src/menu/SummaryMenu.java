package menu;

import java.io.IOException;

public class SummaryMenu extends Menu{
    public SummaryMenu(){
    }
    public static int initSummaryMenu()throws IOException {
        while (true) {
            try{
                System.out.println("================================");
                System.out.println("1. 현재 정보 출력");
                System.out.println("2. 시간 정렬 출력");
                System.out.println("3. 금액 정렬 출력");
                System.out.println("4. 이전으로");
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

            } else if (choose == 3) {

            } else if (choose == 4) {
                return;
            }else{
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            }
        }
    }
}
