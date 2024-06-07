package com.group8.cookinBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavedRecipesDto {
    private int savedrecipeId;
    private long userid;
    private int recipeid;

}
