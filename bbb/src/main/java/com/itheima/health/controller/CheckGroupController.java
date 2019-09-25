package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constants.MessageConstant;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.health.service.CheckGroupService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Discription :
 * @Author LTM
 */
@RestController
@RequestMapping("/checkGroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;
    /**
     *@Description: 添加检查组
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.add(checkGroup,checkitemIds);
            return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
    }
    /**
     *@Description: 分页查询检查组
     */
    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkGroupService.findPage(queryPageBean.getQueryString(), queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        if(pageResult!=null){
            return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,pageResult);
        }else {
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }
    /**
     *@Description: 根据检查组ID回显所有的检查项ID
     */
    @RequestMapping("/findEditById")
    public Result findEditById(int id){
        try {
            CheckGroup checkGroup = checkGroupService.findEditById(id);
            return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
        }

    }
    /**
     *@Description: 编辑检查组
     */
    @RequestMapping("/updateCheckGroup")
    public Result updateCheckGroup(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
                checkGroupService.updateCheckGroup(checkGroup,checkitemIds);
            return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);
        }

    }
    /**
     *@Description: 获取检查组对应的检查项ID
     */
    @RequestMapping("/findCheckitemIdsByCheckGroup")
    public List<Integer> findCheckitemIdsByCheckGroup(int checkGroupId){

        List<Integer> integers = checkGroupService.findCheckitemIdsByCheckGroup(checkGroupId);

                return integers;
    }
}
