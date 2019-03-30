package com.app.user.service;

import com.app.common.service.BaseService;
import com.app.user.entity.User;

public interface UserService extends BaseService<User>{

    /**
     *  登陆校验
     * @param username
     * @param password
     * @return
     */
    public User validateLogin(String username, String password);

    /**
     * 审核用户
     * @param aLong
     * @param userType
     */
    public void auditUser(Long aLong, String userType);
}
