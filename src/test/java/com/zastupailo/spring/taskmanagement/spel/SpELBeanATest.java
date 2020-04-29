package com.zastupailo.spring.taskmanagement.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpELBeanATest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void add() {
        assertNotNull(spELBeanA);
        assertEquals(spELBeanA.getAdd(), 5);
    }

    @Test
    public void addString() {
        assertNotNull(spELBeanA);
        assertEquals(spELBeanA.getAddString(), "Learn Spring");
    }

    @Test
    public void equal() {
        assertNotNull(spELBeanA);
        assertEquals(spELBeanA.isEqual(), true);
    }

    @Test
    public void otherBeanProperty() {
        assertNotNull(spELBeanA);
        assertEquals(spELBeanA.getOtherBeanProperty(), "10");
    }

}