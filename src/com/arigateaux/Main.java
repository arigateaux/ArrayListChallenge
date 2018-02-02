package com.arigateaux;

import java.util.Scanner;

public class Main {

    public static boolean isRunning = false;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (!isRunning) {
            new GUI();

        }

    }

}
