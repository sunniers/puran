/**
 * ModifyPwdService.java
 * Created at 2016-10-10
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;

import com.shdatabank.puruan.model.BackUser;
import com.shdatabank.puruan.model.User;

/**
 * 前后台用户修改密码service层
 * 1.验证后台用户旧密码是否正确
 * 2.更新后台用户新密码
 * 3.验证前台用户旧密码是否正确
 * 4.更新前台用户新密码
 */
public interface ModifyPwdService {
    
    /**
     * 验证后台用户旧密码是否正确
     * @param backUser 用户名和密码
     * @return 是否正确
     */
    public Integer selectBackUserOldPwd(BackUser backUser) throws Exception;
    
    /**
     * 更新后台用户新密码
     * @param backUser 用户名和新密码
     */
    public boolean updateBackUserNewPwd(BackUser backUser) throws Exception;
    
    /**
     * 验证前台用户旧密码是否正确
     * @param user 用户名和密码
     * @return 是否正确
     */
    public Integer selectUserOldPwd(User user) throws Exception;
    
    /**
     * 更新前台用户新密码
     * @param user 用户名和新密码
     */
    public boolean updateUserNewPwd(User user) throws Exception;
}
