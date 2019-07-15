package main;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> items;

    public Menu(List<String> items) {
        this.items = items;
    }

    public int select() {
        for (String item : items) {
            System.out.println(item);
        }
        System.out.print("\nEnter your choise:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        in.close();
        return n;
    }
}
