package com.masai.springjwt.Config;

import com.masai.springjwt.Entity.SecurityUser;
import com.masai.springjwt.Entity.UserInfo;
import com.masai.springjwt.Repository.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LoadUserInfo implements UserDetailsService {
     @Autowired
    UserInfoDAO userInfoDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo  userInfo = userInfoDAO.findByEmail(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        }else return new SecurityUser(userInfo);
    }
}
