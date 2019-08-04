package com.itheima.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReportDao {
    @Select("SELECT COUNT(1) FROM t_member WHERE regTime < #{value}")
    int getCountByRegtime(String regtime);
    @Select("SELECT NAME FROM t_setmeal")
    List<String> getSetmealName();
    @Select("SELECT COUNT(1) FROM t_order WHERE setmeal_id=(SELECT id FROM t_setmeal WHERE NAME = #{setName})")
    int getCountBysetmealName(String setName);
    @Select("SELECT COUNT(1) FROM t_order WHERE orderdate = #{today}")
    int getTodayNewMember(String today);
    @Select("SELECT COUNT(1) FROM t_member")
    int getTotalMember();
    @Select("SELECT count(1) FROM t_member WHERE regTime BETWEEN #{thisWeekMonday} AND #{sundayOfThisWeek}")
    int getThisWeekNewMember(@Param("thisWeekMonday") String thisWeekMonday, @Param("sundayOfThisWeek") String sundayOfThisWeek);
    @Select("SELECT COUNT(1) FROM t_member WHERE regTime LIKE #{thisMonth}")
    int getThisMonthNewMember(String thisMonth);
    @Select("SELECT COUNT(1) FROM t_order WHERE orderdate = #{today}")
    int getTodayOrderNumber(String today);
    @Select("SELECT COUNT(1) FROM t_order WHERE orderDate = #{today} AND orderStatus = '已到诊'")
    int getTodayVisitsNumber(String today);
    @Select("SELECT COUNT(1) FROM t_order WHERE orderDate BETWEEN #{thisWeekMonday} AND #{sundayOfThisWeek}")
    int getThisWeekOrderNumber(@Param("thisWeekMonday") String thisWeekMonday,@Param("sundayOfThisWeek") String sundayOfThisWeek);
    @Select("SELECT COUNT(1) FROM t_order WHERE orderDate BETWEEN #{thisWeekMonday} AND #{sundayOfThisWeek} AND orderStatus = '已到诊' ")
    int gettThisWeekVisitsNumber(@Param("thisWeekMonday")String thisWeekMonday,@Param("sundayOfThisWeek") String sundayOfThisWeek);
    @Select("SELECT count(1) FROM t_order WHERE orderDate LIKE #{thisMonth}")
    int getThisMonthOrderNumber(String thisMonth);
    @Select("SELECT count(1) FROM t_order WHERE orderDate LIKE #{thisMonth} AND orderStatus = '已到诊' ")
    int getThisMonthVisitsNumber(String thisMonth);
    @Select("SELECT t_setmeal.`name`, COUNT(1) setmeal_count FROM t_setmeal,t_order WHERE t_setmeal.`id`=t_order.`setmeal_id` GROUP BY setmeal_id ORDER BY COUNT(1) DESC LIMIT 0,4")
    List<Map> gethHotSetmeal();
    @Select(" SELECT COUNT(1) FROM t_order")
    int getCountOrder();
}
