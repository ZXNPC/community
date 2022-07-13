package com.example.community.mapper;

import com.example.community.dto.QuestionQueryDTO;
import com.example.community.model.Question;
import com.example.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionExtMapper {
    int incView(@Param("row") Question row);
    int incComment(@Param("row") Question row);
    List<Question> selectRelated(Question question);
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}