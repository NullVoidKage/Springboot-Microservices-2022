package com.nullvoidkage.user.VO;

import com.nullvoidkage.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateVO {

    private User user;
    private Department department;
}
