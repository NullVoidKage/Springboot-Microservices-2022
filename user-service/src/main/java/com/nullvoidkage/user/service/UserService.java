package com.nullvoidkage.user.service;

import com.nullvoidkage.user.VO.Department;
import com.nullvoidkage.user.VO.RestTemplateVO;
import com.nullvoidkage.user.entity.User;
import com.nullvoidkage.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public RestTemplateVO getUserWithDepartment(Long userId) {
            log.info("Inside getUserWithDepartment of UserService");
            RestTemplateVO vo = new RestTemplateVO();
            User user = userRepository.findByUserId(userId);
            Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId() ,Department.class);

            vo.setUser(user);
            vo.setDepartment(department);
            return vo;


    }
}
