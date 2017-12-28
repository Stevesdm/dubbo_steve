package com.steve.security;

import com.steve.model.Permission;
import com.steve.model.User;
import com.steve.service.PermissionService;
import com.steve.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/28 下午3:20
 */
public class SteveUserService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByName(username);
        if (user != null){
            List<Permission> permissions = permissionService.getPermissionsByUserId(user.getUserId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions){
                if (permission != null && permission.getPermissionName() != null ){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),grantedAuthorities);

        }else{
            throw new UsernameNotFoundException(username + "do not exist!");
        }
    }
}
