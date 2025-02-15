package model.user;

public class GuestUser extends User{
    public GuestUser() {
        super();
    }

    @Override
    public String accessPlatform() {
        return "guest";
    }
}