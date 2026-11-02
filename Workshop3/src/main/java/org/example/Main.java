package org.example;


import com.sun.source.tree.SwitchTree;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = FileManager.readProducts();
        UserInterface ui = new UserInterface(productList);

        System.out.println("============ EVERYDAY THEORY ============");
        System.out.println("~~provocative and gets the people going~~\n");

        ui.DisplayHomeScreen();


    }
}