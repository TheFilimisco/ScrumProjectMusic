package auth.controller;


import auth.service.AuthService;
import auth.utils.AuthDTO;

import java.sql.SQLException;

public class AuthController {
    private final AuthService authService;

    public AuthController() {
        this.authService = new AuthService();
    }

    public boolean login(AuthDTO authDTO) throws SQLException {
        return authService.login(authDTO);
    }

    public boolean register(AuthDTO authDTO) throws SQLException {
        return authService.register(authDTO);
    }
}
