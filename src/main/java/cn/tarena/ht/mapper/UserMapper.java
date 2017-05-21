package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
	public List<User> findAll();

	@Insert("insert into role_user_p values (#{roleId}, #{userId})")
	void saveUserRole(@Param("roleId") String roleId,@Param("userId") String userId);

	@Delete("delete from role_user_p where auth_user_id = #{userId}")
	void deleteByUserId(String userId);

	@Select("select role_id from role_user_p where auth_user_id = #{userId}")
	List<Role> findRoleByUserId(String userId);


	void saveUser(User user);



    User findUserByNameAndPassword(@Param("userName") String userName,@Param("password") String password);

    @Select("select * from user_p where username = #{username}")
    User findUserByUserName(String username);


//	public void updateState(@Param("userIds") String[] userIds, @Param("state") int state, @Param("updateTime") Date updateTime);
//
//	public void deleteUser(String[] userIds);
//
//	public User findOne(String userId);
}
