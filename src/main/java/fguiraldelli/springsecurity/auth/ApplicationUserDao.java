package fguiraldelli.springsecurity.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    public Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
