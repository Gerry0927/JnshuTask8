package com.gerry.task.controller;

import com.jnshu.common.constant.CommonResult;
import com.gerry.task.pojo.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
//    @PreAuthorize("ss.hasPermission('admin')")
//    @PreAuthorize("hasAuthority()")
    @ApiOperation(value = "查询用户列表", notes = "目前仅仅是作为测试，所以返回用户全列表")
    public CommonResult<UserInfo> getUserInfo(Integer userId){
        return CommonResult.success(new UserInfo(),"查询成功");
    }
}
