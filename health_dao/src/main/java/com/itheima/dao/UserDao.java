package com.itheima.dao;

import com.itheima.domain.Menu;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao {

    User getUserByUsername(String username);
    @Select("SELECT t_menu.* FROM t_role,t_menu,t_role_menu WHERE t_role_menu.`role_id`=t_role.`id`AND t_role_menu.`menu_id`=t_menu.`id` AND t_role.`id`=(\n" +
            "SELECT t_role.`id` FROM t_user,t_role,t_user_role \n" +
            "WHERE t_user_role.`user_id`=t_user.`id` AND t_user_role.`role_id`=t_role.`id` \n" +
            "AND username = #{username}\n" +
            ") AND LEVEL = 1")
    List<Menu> findMenuByUsername(String username);

    @Select("SELECT * FROM t_menu WHERE parentMenuId = #{id}")
    List<Menu> findChildrenMenu(Integer id);
    @Select("select count(1) from t_user where username = #{username}")
    Integer findUser(User user);
    @Update("update t_user set password = #{password} where username = #{username}")
    void updatePassword(User user);
}
