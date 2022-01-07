package com.traveler.server.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class FamilyCommentsDto {
    private String userId;
    private String content;
    private List<FamilyCommentsDto> secondComments;
}
