package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.domain.CheckGroup;
import com.itheima.domain.Setmeal;
import com.itheima.entity.QueryPageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface SetmealDao {
    void addSetmeal(Setmeal setmeal);
    @Insert("insert into t_setmeal_checkgroup values(#{setmeal_id},#{checkgroup_id})")
    void setT_setmeal_checkgroup(HashMap<String,Object>map);

    Page<Setmeal> findPage(String queryString);
    @Delete("delete from t_setmeal where id = #{id} ")
    void deleteSetmealById(Integer id);
    @Delete("delete from t_setmeal_checkgroup where setmeal_id = #{setmeal_id} ")
    void deleteT_setmeal_checkgroupById(Integer setmeal_id);
    @Select("select count(1) from t_setmeal_checkgroup where checkgroup_id = #{checkgroup_id}")
    int findCheckGroupById(int checkgroup_id);
    @Select("SELECT checkgroup_id FROM t_setmeal_checkgroup WHERE setmeal_id = #{setmeal_id}")
    List<Integer> findTableData(int setmeal_id);
    @Update("update t_setmeal set name = #{name},code=#{code},helpCode=#{helpCode},sex=#{sex},age=#{age},price=#{price},remark=#{remark},attention=#{attention},img=#{img} where id = #{id} ")
    void update(Setmeal setmeal);
    @Select("select * from t_setmeal")
    List<Setmeal> findAllSetmeal();

    Setmeal findSetmealById(Integer id);
}
