package com.example.community.mapper;

import com.example.community.model.Comment;
import com.example.community.model.CommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentExtMapper {
    int incComment(@Param("row") Comment row);
}