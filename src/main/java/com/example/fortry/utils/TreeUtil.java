package com.example.fortry.utils;

import com.example.fortry.dto.ConmmentTreeDTO;
import com.example.fortry.entity.Conmment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeUtil {
    public static List<ConmmentTreeDTO> buildTree(List<Conmment> conmmentList){
        List<ConmmentTreeDTO> rootlist=conmmentList.stream()
                .filter(conmment -> conmment.getParentId()==0L)
                .map(TreeUtil::convertToDTO)
                .collect(Collectors.toList());

        rootlist.forEach(root->setChildren(root,conmmentList));

        return rootlist;
}

    private static void setChildren(ConmmentTreeDTO parent, List<Conmment> allconment) {
        List<Conmment> children=allconment.stream()
                .filter(c->c.getParentId().equals(parent.getId()))
                .collect(Collectors.toList());

        if (children.isEmpty()){
            return;
        }

        List<ConmmentTreeDTO> childDTOs=children.stream()
                .map(TreeUtil::convertToDTO)
                .collect(Collectors.toList());


        parent.setChildren(childDTOs);

        //childDTOs里面去以List内部形式遍历
        childDTOs.forEach(child->setChildren(child,allconment));


    }


    private static ConmmentTreeDTO convertToDTO(Conmment conmment) {
        ConmmentTreeDTO dto=new ConmmentTreeDTO(conmment.getId(),conmment.getContent()
        ,new ArrayList<>());
        return dto;
    }
    }
