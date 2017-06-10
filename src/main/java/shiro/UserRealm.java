package shiro;

import entity.User;
import service.UserService;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    
    Logger logger = Logger.getLogger(UserRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        logger.info("日志信息：" + username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRoles(username));
        authorizationInfo.setStringPermissions(userService.getPermissions(username));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userName=(String)token.getPrincipal();
        User user=userService.getByUserName(userName);
        if(user!=null){
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xx");
            return authcInfo;
        }else{
            return null;                
        }
       /* String username = (String)token.getPrincipal();
        logger.info("日志信息1：" + username);
        User user = userService.getByUserName(username);
        
        if(user != null){
            logger.info("日志信息：" + user.toString());
        }
        if(user == null) {
            logger.info("日志信息：" + "user是空");
            throw new UnknownAccountException();//没找到帐号
        }

        
        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;*/
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
