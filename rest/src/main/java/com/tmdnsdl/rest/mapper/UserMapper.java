package com.tmdnsdl.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tmdnsdl.rest.model.UserInfo;

@Mapper
public interface UserMapper {

	@Select("select * from user_info")
	List<UserInfo> getUserInfoList();
	
	@Select("select * from user_info where user_id = #{user_id}")
	UserInfo getUserInfo(@Param("user_id") String user_id);
	
	@Insert("insert into user_info values(#{user_id},#{user_name},#{user_dept},#{user_ranknum},#{user_createdate},null,#{user_grant},#{user_menu_id},null,#{user_position},null)")
	int insertUserInfo(UserInfo user);
	
	@Update("update user_info set user_name = #{user_name}, user_ranknum = #{user_ranknum}, user_updatedate = #{user_updatedate}, user_grant = #{user_grant}, user_position = #{user_position}, user_dept = #{user_dept} where user_id = #{user_id}")
	int updateUserInfo(UserInfo user);
	
	@Delete("delete from user_info where user_id = #{user_id}")
	int deleteUserInfo(@Param("user_id") String user_id);
}
