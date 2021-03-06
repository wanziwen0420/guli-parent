package com.atguigu.guli.service.edu.service.impl;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.query.TeacherQuery;
import com.atguigu.guli.service.edu.mapper.TeacherMapper;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public IPage<Teacher> selectPage(Long page, Long limit, TeacherQuery teacherQuery) {
        //组装分页对象
        Page<Teacher> pageParam = new Page<>(page, limit);

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String joinDateBegin = teacherQuery.getJoinDateBegin();
        String joinDateEnd = teacherQuery.getJoinDateEnd();

        //组装查询条件
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name", name);//注意：like会使索引失效 %值%  %值
        }

        if(!StringUtils.isEmpty(joinDateBegin)){
            queryWrapper.ge("join_date", joinDateBegin);
        }

        if(!StringUtils.isEmpty(joinDateEnd)){
            queryWrapper.le("join_date", joinDateEnd);
        }

        if(level != null){
            queryWrapper.eq("level", level);
        }

        //执行查询返回结果
        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
