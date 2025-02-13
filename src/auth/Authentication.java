package auth;

import model.user.AdminUser;
import model.user.MemberUser;
import model.user.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Authentication {
    private HashMap<Integer,User> users;

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public Authentication() {
        users = new HashMap<Integer,User>();
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

    public boolean isMember(Integer id){
        User user = users.get(id);
        if (user.getType().matches("Member")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*
    }       Authentication auth = new Authentication();
        //Email Fail
        auth.register(new MemberUser("Steven", LocalDate.now(),"usuario123dominio.com", "Pass1234","12345678L"));
        System.out.println(auth.users);
        //Password Fail
        auth.register(new MemberUser("Steven", LocalDate.now(),"usuario123@dominio.com", "Pass1234asdasd","12345678L"));
        System.out.println(auth.users);
        //DNI fail
        auth.register(new MemberUser("Steven", LocalDate.now(),"usuario123@dominio.com", "Pass1234","12345678l"));
        System.out.println(auth.users);

        //Correct Register
        User dummy = new MemberUser("Steven", LocalDate.now(),"nystepro@gmail.com", "Pass1234","12345678L");
        auth.register(dummy);
        System.out.println(auth.users);

        //Invalid Login
//        auth.login(dummy.getNickName(), "Pass1234asdasdsa");

        //Correct Login
        System.out.println(auth.login(dummy.getNickName(), "Pass1234"));
*/
    }

}
