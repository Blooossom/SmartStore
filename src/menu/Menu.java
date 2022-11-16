package menu;
import java.io.*;

public abstract class Menu {
    public Menu(){
    }
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int initMenu()throws IOException{
        System.out.println("================================");
        System.out.println("1. 고객");
        System.out.println("2. 지표");
        System.out.println("3. 요약");
        System.out.println("4. 프로그램 종료");
        System.out.println("================================");
        System.out.println("Choose one : ");
        return Integer.parseInt(br.readLine());
    }
}
