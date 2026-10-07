package fi.haagahelia.bookstore.service;

import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
                curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}
