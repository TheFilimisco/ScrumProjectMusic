package ui;


import java.util.Scanner;

public class AppView {
    private final Scanner sc = new Scanner(System.in);

    public String searchByTitle() {
        System.out.println("=================Search Song By Title=============");
        System.out.print("Enter Title:");
        return sc.nextLine();
    }
    public String searchByArtist() {
        System.out.println("=================Search Songs By Artist=============");
        System.out.print("Enter Artist:");
        return sc.nextLine();
    }

    public String searchByAlbum() {
        System.out.println("=================Search Songs By Album=============");
        System.out.print("Enter Album:");
        return sc.nextLine();
    }

    public String searchByGenre() {
        System.out.println("=================Search Songs By Genre=============");
        System.out.print("Enter Genre:");
        return sc.nextLine();
    }

    public String searchByYear() {
        System.out.println("=================Search Songs By Year=============");
        System.out.print("Enter Year:");
        return sc.nextLine();
    }
}
