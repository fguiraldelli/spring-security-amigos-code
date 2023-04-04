package fguiraldelli.springsecurity.auth;

import java.util.Optional;

public class FakeApplicationDaoService implements ApplicationUserDao{
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return Optional.empty();
    }
}
