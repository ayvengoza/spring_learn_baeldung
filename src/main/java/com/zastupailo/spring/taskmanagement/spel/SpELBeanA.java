package com.zastupailo.spring.taskmanagement.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanA {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{'Learn ' + 'Spring'}")
    private String addString;

    @Value("#{2 == 2}")
    private boolean equal;

    @Value("#{spELBeanB.prop1}")
    private String otherBeanProperty;


    public Integer getAdd() {
        return add;
    }

    public String getAddString() {
        return addString;
    }

    public boolean isEqual() {
        return equal;
    }

    public String getOtherBeanProperty() {
        return otherBeanProperty;
    }
}
