package com.crb.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crb.library.entity.Administrator;
import com.crb.library.service.IAdministratorService;
import com.crb.library.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crb
 * @since 2022-05-19
 */
@RestController
public class AccountController {

    @Resource
    private IAdministratorService administratorService;

    @PostMapping("/login")
    public Result login(@RequestBody Administrator administrator) {
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", administrator.getName());
        queryWrapper.eq("password", administrator.getPassword());
        Administrator one = administratorService.getOne(queryWrapper);
        if (one == null) {
            return Result.fail("用户名或密码不正确");
        } else {
            return Result.success("登陆成功");
        }
    }
}
