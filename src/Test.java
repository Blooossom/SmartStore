import group.Group;
import group.Groups;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        int[] arr = new int[10];
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
        Groups[] groups = new Groups[10];
        System.out.println(Arrays.toString(groups));
        ArrayList<Groups> groups1 = new ArrayList<Groups>();
        System.out.println(groups1);
    }
}
