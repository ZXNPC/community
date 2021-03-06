package com.example.community.controller;

import com.example.community.cache.TagCache;
import com.example.community.enums.CustomizeErrorCode;
import com.example.community.exception.CustomizeException;
import com.example.community.service.QuestionService;
import com.example.community.dto.QuestionDTO;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 20220402
 */
@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;
    
    @GetMapping("/publish")
    public String publish(Model model) {
        model.addAttribute("tagDTOS", new TagCache().get());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        model.addAttribute("tagDTOS", TagCache.get());

        if(title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if(description == null || description == "") {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if(tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }


        String cs = TagCache.filterInvalid(tag);
        if (StringUtils.isNotBlank(cs)) {
            model.addAttribute("error", "标签错误 " + cs);
            return "publish";
        }


        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);

        questionService.createOrUpdate(question);
        return "redirect:/";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       HttpServletRequest request,
                       Model model) {
        QuestionDTO question = questionService.getById(id);

        if (question.getUser().getId() != ((User) request.getSession().getAttribute("user")).getId()) {
            throw new CustomizeException(CustomizeErrorCode.ACCOUNT_ERROR);
        }

        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id", question.getId());
        model.addAttribute("tagDTOS", new TagCache().get());

        return "publish";
    }
}
