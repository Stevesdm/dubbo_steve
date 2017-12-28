package com.steve.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.steve.model.Permission;
import com.steve.model.Role;
import com.steve.model.User;
import com.steve.service.PermissionService;
import com.steve.service.RoleService;
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


    @Reference
    private UserService userService;

    @Reference
    private PermissionService permissionService;

    @Reference
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByName(username);
        if (user != null) {


            //基于权限的访问控制
//            List<Permission> permissions = permissionService.getPermissionsByUserId(user.getUserId());
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            for (Permission permission : permissions){
//                if (permission != null && permission.getPermissionName() != null ){
//                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionName());
//                    grantedAuthorities.add(grantedAuthority);
//                }
//            }
//            return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),grantedAuthorities);

            //基于角色的访问控制
            List<Role> roles = roleService.getRoleByUserId(user.getUserId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Role role : roles) {
                if (role != null && role.getRoleName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);


        } else {
            throw new UsernameNotFoundException(username + "do not exist!");
        }
    }
}
