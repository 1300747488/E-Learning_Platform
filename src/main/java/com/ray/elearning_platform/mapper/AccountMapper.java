package com.ray.elearning_platform.mapper;

import com.ray.elearning_platform.entity.Account;
import com.ray.elearning_platform.resp.UserListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    // 新增账户
    int insertAccount(Account account);

    // 根据用户名查询账户
    Account selectByUsername(@Param("username") String username);

    // 根据账户ID查询账户
    Account selectById(@Param("accountId") Integer accountId);

    // 修改个人资料
    int updateProfile(Account account);

    // 修改账户状态
    int updateStatus(@Param("accountId") Integer accountId,
                     @Param("status") String status);

    // 查询用户列表
    List<UserListResp> selectUserList(@Param("role") String role,
                                      @Param("keyword") String keyword);
}