package com.example.controller;

import com.example.dao.StudentDao;
import com.example.model.Student;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired //自动到Spring容器中去匹配该类型的对象，将这个对象的值赋值给该变量
    private StudentDao studentDao;
    /**
     * /student/list ==> WEB-INF/html/student/list.html
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<Student> list = studentDao.queryAll();
        model.addAttribute("students",list);
        return "student/list";
    }

    /**
     * 跳转到添加学生的页面
     * @return
     */
    @RequestMapping("/addInput")
    public String addInput(){
        return "student/add";
    }
}
