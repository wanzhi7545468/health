package com.itheima.dao;


import com.github.pagehelper.Page;
import com.itheima.domain.CheckGroup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CheckGroupDao {
    void addCheckGroup(CheckGroup checkGroup);
    @Insert("insert into t_checkgroup_checkitem values(#{checkgroup_id},#{checkitem_id})")
    void setT_checkgroup_checkitem(HashMap<String,Object>map);

    Page<CheckGroup> findPage(String queryString);
    @Delete("delete from t_checkgroup where id=#{id}")
    void deleteCheckGroup(int id);
    @Delete("DELETE FROM T_checkgroup_checkitem WHERE checkgroup_id = #{id} ")
    void deleteT_checkgroup_checkitem(int id);
    @Select("SELECT checkitem_id FROM t_checkgroup_checkitem WHERE checkgroup_id=#{checkgroup_id}")
    List<Integer> findCheckItemByCheckGroupId(int checkgroup_id);
    @Update("update t_checkgroup set code=#{code},name=#{name},helpCode=#{helpCode},sex=#{sex},remark=#{remark},attention=#{attention} where id=#{id}")
    void updateCheckGroup(CheckGroup checkGroup);
    @Select("select * from t_checkgroup")
    List<CheckGroup> findAll();

    List<CheckGroup> findCheckGroupBySetmealId(int id);

}
