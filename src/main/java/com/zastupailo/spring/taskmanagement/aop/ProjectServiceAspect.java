package com.zastupailo.spring.taskmanagement.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProjectServiceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceAspect.class);

    @Before(value = "execution(* com.zastupailo.spring.taskmanagement.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        LOG.info("Searching Project with id {}", joinPoint.getArgs()[0]);
    }
}
