package com.softserve.itacademy.securityFromNazar;


import com.softserve.itacademy.model.User;
import com.softserve.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetelServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetelServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByEmail(s);
        return !optional.isPresent() ? null : new UserDetailsImp(optional.get());
    }
}
