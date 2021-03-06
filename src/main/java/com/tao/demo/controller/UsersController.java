package com.tao.demo.controller;

import com.tao.demo.entity.Users;
import com.tao.demo.params.UsersParam;
import com.tao.demo.dto.UsersDto;
import com.tao.demo.service.UsersService;
import com.tao.frameworks.base.common.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
* @author zt on 2020-04-23 13:41:32
*/
@RestController
@RequestMapping("/users")
@Api(tags = "用户API接口")
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping(value = "/insert", name = "插入")
    public void insert(Users users) {
        this.usersService.insert(users);
    }

    @GetMapping(value = "/delete", name = "删除")
    public void delete(Integer id) {
        this.usersService.deleteById(id);
    }

    @PostMapping(value = "/update", name = "修改")
    public void update(Users users) {
        this.usersService.update(users);
    }

    @GetMapping(value = "/get", name = "详情")
    public UsersDto get(Integer id) {
        return this.usersService.getById(id);
    }

    @ApiOperation(value="分页查询用户", notes="分页查询用户")
    @RequestMapping(value = "/query", name = "分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "页码", required = true)})
    public Result query(int page, int limit, UsersParam params) {
        return this.usersService.selectPage(page, limit, params);
    }

    @RequestMapping(value = "/select", name = "查询所有")
    public List<UsersDto> select(UsersParam params) {
        return this.usersService.selectByMap(params);
    }

}