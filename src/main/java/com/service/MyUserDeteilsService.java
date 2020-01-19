//package com.service;
//
//import com.DAO.UserDAO;
//import com.model.UserRoles;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service("userDeteilsService")
//public class MyUserDeteilsService {
//    UserDAO userDAO;
//    public UserDAO getUserDAO() {
//        return userDAO;
//    }
//    @Autowired
//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//    private UserDetails buildUserForAuthentication(com.model.User user,
//                                                   List<GrantedAuthority> authorities) {
//        return new User(user.getUsername(),
//                user.getPassword(), user.getEnabled(),
//                true, true, true, authorities);
//    }
//    public UserDetails loadUserByUsername(final String username)
//            throws UsernameNotFoundException {
//
//        com.model.User user = userDAO.findByUsername(username);
//        List<GrantedAuthority> authorities =
//                buildUserAuthority(user.getUserRole());
//
//        return buildUserForAuthentication(user, authorities);
//    }
//    private List<GrantedAuthority> buildUserAuthority(Set<UserRoles> userRoles) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        // Build user's authorities
//        for (UserRoles userRole : userRoles) {
//            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//        }
//
//        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return Result;
//    }
//}