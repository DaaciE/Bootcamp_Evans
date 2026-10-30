package org.example;


import com.sun.source.tree.SwitchTree;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== EVERYDAY THEORY ==========");
        System.out.println("it's provocative and gets the people going\n");

        List<Product> productList = FileManager.readProducts();
        UserInterface ui = new UserInterface(productList);

        ui.DisplayScreen();


    }
} //