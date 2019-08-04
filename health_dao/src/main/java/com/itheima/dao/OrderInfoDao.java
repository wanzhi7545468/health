package com.itheima.dao;

import com.itheima.domain.Member;
import com.itheima.domain.Order;
import com.itheima.domain.Setmeal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface OrderInfoDao {
    @Select("SELECT COUNT(1) FROM t_order WHERE member_id = (SELECT id FROM t_member WHERE NAME = #{name}) AND setmeal_id = #{setmeal_id}")
    int findHasOrder(HashMap<String, Object> findHasOrderMap);
    @Select("select count(*) from t_member where idCard = #{idCard} ")
    int findMemberByIdCard(String idCard);
    @Insert("INSERT INTO t_member (NAME,sex,idcard,phoneNumber,regTime)VALUES(#{name},#{sex},#{idCard},#{phoneNumber},#{regTime})" )
    void addMember(Member member);
    @Select("select id from t_member where idcard = #{idcard}")
    int findMemberidByIdcard(String idcard);
    void setOrder(Order order);

    Order findById(int id);

    @Select("SELECT * FROM t_setmeal WHERE id = #{id}")
    Setmeal findSetmealById(int id);
}
