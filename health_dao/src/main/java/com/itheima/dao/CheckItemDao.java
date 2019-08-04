package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.domain.CheckItem;
import com.itheima.entity.QueryPageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckItemDao {
    @Insert("insert into t_checkitem values(null,#{code},#{name},#{sex},#{age},#{price},#{type},#{attention},#{remark})")
    void addCheckItem(CheckItem checkItem);
    Page<CheckItem> findPage(String queryString);
    @Delete("delete from t_checkitem where id = #{id}")
    void deleteCheckItemById(int id);
    @Update("UPDATE t_checkitem SET CODE=#{code},NAME=#{name},sex=#{sex},age=#{age},price=#{price},TYPE=#{type},attention=#{attention},remark=#{remark} WHERE id = #{id} ")
    void updateCheckItem(CheckItem checkItem);
    @Select("select * from t_checkitem")
    List<CheckItem> findAll();
    @Select("select COUNT(1) from t_checkgroup_checkitem where checkitem_id = #{checkitem_id}")
    Integer findCheckItemFromT_checkgroup_checkitemById(int checkitem_id);

    List<CheckItem> findCheckItemsByCheckGroupId(int id);
}
