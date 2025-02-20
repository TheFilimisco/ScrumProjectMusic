package auth;

import model.user.User;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Authentication {
    private HashMap<Integer,User> users;

    public Authentication() {
        users = new HashMap<>();
    }

    public void register(User user){
        if (validation(user)){
            users.put(user.getId(),user);
            return;
        }
        throw new IllegalStateException("DNI, email or Password, invalid!");
    }

    public User login(String nickName, String password){
        for (User us: users.values()){
            if (us.getNickName().equals(nickName) && us.getPassword().equals(password)){
                return us;
            }
        }
        throw new IllegalStateException("NickName or Password, invalid!");
    }


    private boolean validation(User user){
        if (!Pattern.matches("\\d{8}[A-Z]", user.getIdentificationNumber())){
            return false;
        } else if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", user.getEmail())) {
            return false;
        } else if (!Pattern.matches("^(?=.*\\d)(?=.*[A-Z])[A-Za-z\\d]{8}$", user.getPassword())) {
            return false;
        } else if (user.getNickName().isEmpty()){
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
            newUser.append(user.getName()).append(((int) (Math.random() * user.getDateOfBirth().getYear())));
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
}