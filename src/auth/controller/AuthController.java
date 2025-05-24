package auth.controller;


import auth.service.AuthService;
import auth.utils.AuthDTO;

import java.sql.SQLException;

public class AuthController {

    private final AuthService authService;

    public AuthController() {
        this.authService = new AuthService();
    }

    public Integer login(AuthDTO authDTO) throws SQLException {
        boolean success = authService.login(authDTO);
        return success ? authService.getLoggedUserId() : null;
    }

    public boolean register(AuthDTO authDTO) throws SQLException {
        return authService.register(authDTO);
    }
}
