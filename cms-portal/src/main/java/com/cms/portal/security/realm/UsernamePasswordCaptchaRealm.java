package com.cms.portal.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Shiro的认证过程最终会交给Realm执行,这时会调用Realm的getAuthenticationInfo(token)方法
 * 自定义一个 realm类,继承 AuthorizingRealm抽象类,重写相关需要修改的方法即可
 *
 * 该方法主要执行以下操作
 * (1)检查提交的进行认证的令牌信息
 * (2)根据令牌信息从数据源(通常为数据库)中获取用户信息
 * (3)对用户信息进行匹配验证。
 * (4)验证通过将返回一个封装了用户信息的 AuthenticationInfo 实例。
 * (5)验证失败则抛出 AuthenticationException 异常信息。
 * @author 29237
 */
public class UsernamePasswordCaptchaRealm extends AuthorizingRealm {

    /**
     * 授权
     * 获取授权信息
     * PrincipalCollection是一个身份集合,因为我们现在就一个Realm,所以直接调用getPrimaryPrincipal得到之前传入的用户名即可,
     * 然后根据用户名调用UserService接口获取角色及权限信息。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * 获取身份认证信息
     * 认证回调函数,登录时调用
     * 首先根据传入的用户名获取user信息,如果user为空,那么抛出未找到帐号异常UnknownAccountException,
     * 如果用户找到了但锁定了,则抛出锁定异常LockedAccountException,最后生成AuthenticationInfo信息
     * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
