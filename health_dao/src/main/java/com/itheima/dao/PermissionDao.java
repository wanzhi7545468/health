package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.domain.Menu;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface PermissionDao {
    Page<Permission> findPage(String queryString);
    @Insert("insert into t_permission (name,keyword) values(#{name},#{keyword})")
    void addPermission(Permission permission);
    @Update("update t_permission set name = #{name},keyword=#{keyword} where id = #{id}")
    void updatePermission(Permission permission);
    @Delete("delete from t_permission where id = #{id}")
    void deletePermission(Integer id);

    Page<Role> findPageRole(String queryString);
    @Select("SELECT COUNT(1) FROM t_role_permission WHERE permission_id = #{id}")
    Integer findPermissionCountById(Integer id);
    @Select("select * from t_permission ")
    List<Permission> getAllPermission();

    void addRole(Role role);
    @Select("select * from t_menu")
    List<Menu> getAllmenu();
    @Insert("insert into t_role_permission values(#{roleid},#{permissionId})")
    void addRoleAndPermission(Map<String,Integer> map);
    @Insert("insert into t_role_menu values(#{roleid},#{menuId})")
    void addRoleAndMenu(Map<String,Integer> map);
    @Select("SELECT permission_id FROM t_role_permission WHERE role_id = #{roleId}")
    List<Integer> findPermissionList(Integer roleId);
    @Select("SELECT menu_id FROM t_role_menu WHERE role_id = #{roleId}")
    List<Integer> findMenuList(Integer roleId);
    @Update("UPDATE t_role SET NAME = #{name} , keyword=#{keyword} WHERE id = #{id}")
    void updateRole(Role role);
    @Delete("delete from t_role_permission where role_id = #{id}")
    void deleteRoleAndPermission(Integer id);
    @Delete("delete from t_role_menu where role_id = #{id}")
    void deleteRoleAndMenu(Integer id);
    @Select("select count(1) from t_user_role where role_id = #{id}")
    Integer findRoleFromUserAndRole(Integer id);
    @Delete("delete from t_role where id = #{id}" )
    void deleteRole(Integer id);

    Page<User> findPageUser(String queryString);
    @Select("select * from t_role")
    List<Role> findRole();
    @Select("select count(1) from t_user where username = #{username}")
    Integer checkUsername(String username);

    void addUser(User user);
    @Insert("insert into t_user_role values(#{user_id},#{role_id})")
    void addUserAndRole(HashMap<String, Integer> map);
    @Select("SELECT role_id FROM t_user_role WHERE user_id = #{id} ")
    List<Integer> findUserRoles(Integer id);
    @Update("update t_user set password = #{password} where id = #{id}")
    void updateUser(User user);
    @Delete("delete from t_user_role where user_id = #{id}")
    void deleteUserAndRole(Integer id);
    @Delete("delete from t_user where id = #{id}")
    void deleteUser(Integer id);
}
