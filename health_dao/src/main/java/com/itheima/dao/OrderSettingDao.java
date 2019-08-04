package com.itheima.dao;

import com.itheima.domain.OrderSetting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderSettingDao {
    @Select("SELECT COUNT(1) FROM t_ordersetting WHERE orderDate = #{orderDate}")
    int findOrderSettingByDate(Date orderDate);
    @Update("update t_ordersetting set number=#{number} where orderDate = #{orderDate} ")
    void updateNumberByDate(OrderSetting orderSetting);
    @Insert("insert into t_ordersetting values(null,#{orderDate},#{number},#{reservations}) ")
    void addOrderSetting(OrderSetting orderSetting);
    List<OrderSetting> findAll(String orderDate);
    @Select("select reservations from t_ordersetting where orderDate = #{orderDate} ")
    int findReservationsByDate(Date orderDate);
    @Select("select number from t_ordersetting where orderDate = #{orderDate} ")
    int findNumberByDate(Date orderDate);
    @Update("UPDATE t_ordersetting SET reservations=(reservations+1) WHERE orderdate = #{orderdate}")
    void updateReservationsByDate(Date orderDate);
}
