package auth.controller;


import auth.service.AuthService;

import java.sql.SQLException;

public class AuthController {
    private final AuthService authService;

    public AuthController() {
        this.authService = new AuthService();
    }

    public boolean login(String email, String password) throws SQLException {
        return authService.login(email,password);
    };
    public boolean register(String email, String password) throws SQLException {
        return authService.register(email,password);
    }
}
