package com.example.fortry.controller;

import com.example.fortry.common.Result;
import com.example.fortry.dto.ConmmentTreeDTO;
import com.example.fortry.entity.Conmment;
import com.example.fortry.mapper.ConmmentMapper;
import com.example.fortry.utils.TreeUtil;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommontController {
    @Autowired
    private ConmmentMapper conmmentMapper;

    @GetMapping("/tree")
    public Result<List<ConmmentTreeDTO>> gettree(){
        List<Conmment> allConment=conmmentMapper.selectList(null);

        List<ConmmentTreeDTO> tree= TreeUtil.buildTree(allConment);

        return Result.success(tree);
    }
}
