package com.matancita.cardatabase.service;

import com.matancita.cardatabase.dao.UserDao;
import com.matancita.cardatabase.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author manue
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    UserDao userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User currentUser = userService.findByUsername(username);
        
        UserDetails user = new org.springframework.security.core.userdetails
                .User(username, currentUser.getPassword(),true, true, true, true,
                        AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
        
    }
    
}
