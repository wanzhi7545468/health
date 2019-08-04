package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    @Select("select count(1) from t_member where phoneNumber = #{phoneNumber} ")
    int findMemberByTelephone(String phoneNumber);
    @Insert("insert into t_member set(phoneNumber,regTime) values(#{phoneNumber},#{regTime})")
    void addMember(Member member);
}
