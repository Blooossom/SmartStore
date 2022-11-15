package menu;
import java.io.*;

public abstract class Menu {
    public Menu(){
    }
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int initMenu()throws IOException{
        System.out.println("================================");
        System.out.println("1. CustomerMenu");
        System.out.println("2. ParameterMenu");
        System.out.println("3. SummaryMenu");
        System.out.println("4. Quit");
        System.out.println("================================");
        System.out.println("Choose one : ");
        return Integer.parseInt(br.readLine());
    }
}
