package com.xz.parking.shiro;

import com.xz.parking.entity.dto.ScopeDto;
import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.vo.AdminVo;
import com.xz.parking.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/19
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    AdminService adminService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //读取权限表，赋予用户权限
        //info.addStringPermission("ADMIN");//指定权限名

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //通过下面方法return new SimpleAuthenticationInfo(admin,admin.getPasswd(),"");中的第一个参数（principal）接收传入的管理员对象
        AdminPo currentAdminPo = (AdminPo) subject.getPrincipal();
        List<String> roleScope = adminService.queryRoleByAdminId(currentAdminPo.getId());
        //添加用户拥有的权限进程序
        info.addStringPermissions(roleScope);


        //把用户信息过滤后传入session，给业务层调用
        AdminVo adminVo = new AdminVo();
        BeanUtils.copyProperties(currentAdminPo, adminVo);
        SecurityUtils.getSubject().getSession().setAttribute("user", adminVo);
        SecurityUtils.getSubject().getSession().setAttribute("scope", new ScopeDto(roleScope));
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        //查询数据库中的用户
        AdminPo adminPo = adminService.queryAdminByEmployeeNo(userToken.getUsername());
        if (adminPo == null) {
            //没有找到管理员
            //抛出UnknownAccountException
            return null;
        }

        //密码加密方式：MD5加密，MD5盐值加密
        //密码认证由shiro来做
        return new SimpleAuthenticationInfo(adminPo, adminPo.getPasswd(), "");
    }
}
