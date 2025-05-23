import auth.controller.AuthController;
import ui.Menu;
import ui.ViewAuth;

import javax.swing.text.View;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        AuthController authController = new AuthController();
        Menu menu = new Menu();
        ViewAuth viewAuth = new ViewAuth();
        boolean running = true;
        while(running){
            menu.auth();
            System.out.println("Select your choice: ");
            String option = sc.nextLine();
            switch (option){
                case "1":{
                    System.out.println(authController.login(viewAuth.login()));
                    break;
                }
                case "2":{
                    System.out.println(authController.register(viewAuth.register()));
                    break;
                }
                case "3":{
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
