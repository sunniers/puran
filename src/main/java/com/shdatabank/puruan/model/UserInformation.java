/**
 * UserInformation.java
 * Created at 2016-10-29
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.model;

import java.util.List;

public class UserInformation {
    
    /** 用户id */
    private Long userId;

    /** 用户基本信息 */
    private User user;
    
    /** 用户教育经历 */
    private TalentEduExperience talentEduExperience;
    
    /** 用户工作经历 */
    private List<TalentWorkExperience> talentWorkExperiences;
    
    private UserCreativeTalent userCreativeTalent;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TalentEduExperience getTalentEduExperience() {
        return talentEduExperience;
    }

    public void setTalentEduExperience(TalentEduExperience talentEduExperience) {
        this.talentEduExperience = talentEduExperience;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TalentWorkExperience> getTalentWorkExperiences() {
        return talentWorkExperiences;
    }

    public void setTalentWorkExperiences(List<TalentWorkExperience> talentWorkExperiences) {
        this.talentWorkExperiences = talentWorkExperiences;
    }

    public UserCreativeTalent getUserCreativeTalent() {
        return userCreativeTalent;
    }

    public void setUserCreativeTalent(UserCreativeTalent userCreativeTalent) {
        this.userCreativeTalent = userCreativeTalent;
    }
    
}
