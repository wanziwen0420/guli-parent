package com.atguigu.guli.service.edu.service.impl;

import com.atguigu.guli.service.edu.entity.Comment;
import com.atguigu.guli.service.edu.mapper.CommentMapper;
import com.atguigu.guli.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
