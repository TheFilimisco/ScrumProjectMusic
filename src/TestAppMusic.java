import auth.Authentication;
import ui.UI;

import java.util.Scanner;

public class TestAppMusic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Authentication auth = new Authentication();
        UI ui = new UI();
        ui.mainLevel(input,auth);
    }
}
