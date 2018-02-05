package io.arigateaux;

public class GUI {

    public GUI() {
        showMenu();
    }

    public void showMenu() {
        System.out.println(
                "1 - Show Contact\n" +
                        "2 - Add Contact\n" +
                        "3 - Update Contact\n" +
                        "4 - Remove Contact\n" +
                        "5 - Search Contact\n" +
                        "6 - Quit\n");
    }

}
