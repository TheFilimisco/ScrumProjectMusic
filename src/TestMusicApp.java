import auth.Authentication;
import management.AdminManager;
import management.MusicManager;
import model.user.AdminUser;
import model.user.memberuser.MemberUser;
import ui.UI;

import java.time.LocalDate;
import java.util.Scanner;

public class TestMusicApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Authentication auth = new Authentication();
        MusicManager manager = new MusicManager();
        AdminManager adminManager = new AdminManager();

        UI ui = new UI();

        auth.register(new MemberUser("Steven", LocalDate.now(), "nystepro@gmail.com", "123456Aa", "54910978L", "XD"));
        auth.register(new AdminUser("Theo", LocalDate.now(), "theo@gmail.com", "123456Aa", "34352323S", "XD2"));
        auth.register(new MemberUser("Julia", LocalDate.now(), "julia@gmail.com", "123456Aa", "35487659A", "XD3"));
        auth.register(new AdminUser("Melina", LocalDate.now(), "melina@gmail.com", "123456Aa", "87465780W", "XD4"));

        ui.mainLevel(sc, auth, manager, adminManager);

    }
}
