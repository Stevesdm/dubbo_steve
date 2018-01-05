package com.steve.web;

import com.steve.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/27 下午3:16
 */
@Controller
public class DemoController {

    @Autowired
    DemoService demoService;


    @RequestMapping(value = "/home")
    public ModelAndView hello() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/demo")
    @ResponseBody
    public String demo() {

        return demoService.test();
    }


    //动态编辑权限
    //连接数据库存储对应权限
//    @GetMapping("/vip")
//    public boolean updateToVIP() {
//        // 得到当前的认证信息
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        //  生成当前的所有授权
//        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
//        // 添加 ROLE_VIP 授权
//        updatedAuthorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
//        // 生成新的认证信息
//        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
//        // 重置认证信息
//        SecurityContextHolder.getContext().setAuthentication(newAuth);
//        return true;
//    }

}
