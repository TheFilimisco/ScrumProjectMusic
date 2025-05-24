import app.controller.AppMusicController;
import auth.controller.AuthController;
import models.user.Member;
import profile.controller.ProfileController;
import ui.AppView;
import ui.Menu;
import ui.ProfileView;
import ui.ViewAuth;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private final Scanner sc = new Scanner(System.in);

    private final AppMusicController appMusicController = new AppMusicController();
    private final AuthController authController = new AuthController();
    private final ProfileController profileController = new ProfileController();

    private final Menu menu = new Menu();
    private final ViewAuth viewAuth = new ViewAuth();
    private final AppView appView = new AppView();
    private final ProfileView profileView = new ProfileView();

    public static void main(String[] args) throws SQLException {
        App app = new App();
        app.mainLevel();
    }

    private void mainLevel() throws SQLException {
        boolean running = true;
        while(running){
            menu.auth();
            System.out.println("Select your choice: ");
            String option = sc.nextLine();
            switch (option){
                case "1":{
                    secondLevel(authController.login(viewAuth.login()));
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


    private void secondLevel(Integer idMember) throws SQLException {
        boolean running = true;
        while(running){
            menu.app();
            System.out.println("Select your choice: ");
            String option = sc.nextLine();
            switch (option){
                case "1":{
                    Member member = profileController.getValidatedProfile(idMember);
                    if (member != null) {
                        profileLevel(member);
                    }
                    break;
                }
                case "2":{
                    appMusicController.findSongByTitle(appView.searchByTitle());
                    break;
                }
                case "3":{
                    appMusicController.findSongByTitle(appView.searchByGenre());
                    break;
                }
                case "4":{
                    appMusicController.findSongByTitle(appView.searchByArtist());
                    break;
                }
                case "5":{
                    appMusicController.findSongByYear(appView.searchByYear());
                    break;
                }
                case "6": {
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }


    private void profileLevel(Member member) throws SQLException {
        boolean running = true;
        while(running){
            menu.profile();
            System.out.println("Select your choice: ");
            String option = sc.nextLine();
            switch (option){
                case "1":{
                    profileController.getProfile(member);
                    break;
                }
                case "2":{
                    profileController.addInformationProfile(profileView.changeInformation(member));
                    break;
                }
                case "3":{
                    profileController.changeInformationProfile(profileView.changeInformation(member));
                    break;
                }
                case "4":{
                    profileController.getHistoryProfile(member).forEach(System.out::println);
                    break;
                }
                case "5":{
                    running = false;
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
