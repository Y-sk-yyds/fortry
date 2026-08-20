package com.example.fortry.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConmmentTreeDTO {
    private Long id;
    private String context;
    private List<ConmmentTreeDTO> children;

    public ConmmentTreeDTO(long id, String context, List<ConmmentTreeDTO> children) {
        this.id = id;
        this.context = context;
        this.children = children;
    }
}
