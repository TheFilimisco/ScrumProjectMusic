package auth;

import model.user.AdminUser;
import model.user.MemberUser;
import model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Authentication {
    private HashMap<Integer,User> users;

    public Authentication() {
        users = new HashMap<Integer,User>();
    }

    public void register(User user){
        users.put(user.getId(), user);
    }

    public User login(User user){
        if (user instanceof MemberUser){
//            return new MemberUser();
        } else if (user instanceof  AdminUser) {
//            return new AdminUser();
        }
        return new User();
    }

    private boolean validation(User user){
        if (!Pattern.matches("\\d{8}[A-Z]", user.getIdentificationNumber())){
            return false;
        } else if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", user.getEmail())) {
            return false;
        } else if (Pattern.matches("^(?=.*\\d)(?=.*[A-Z])[A-Za-z\\d]{8}$", user.getPassword())) {
            return false;
        } else if (user.getNickName() == null){
            user.setNickName(generateNickName(user));
        }
        return true;
    }

    private String generateNickName(User user){
        var running = true;
        StringBuilder newUser = new StringBuilder();
        while (running) {
            newUser.setLength(0);
            boolean exist = false;
            newUser.append(user.getName()).append((( int) (Math.random() * user.getDateOfBirth().getYear())));
            for (User us: users.values()){
                if ((us.getNickName().contentEquals(newUser.toString()))) {
                    exist = true;
                    break;
                }
            }
            if (!exist){
                running = false;
            }
        }
        return newUser.toString();
    }

    public static void main(String[] args) {
//        var user = new User();
//        user.setName("Steven");
//        user.setIdentificationNumber("54910978L");
//        System.out.println(user.getId());
//        Authentication auth = new Authentication();
//        System.out.println(auth.generateNickName(user));
    }


}
