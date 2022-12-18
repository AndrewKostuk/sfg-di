package by.bsuir.andrei.sfgdi.services;

import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public LifeCycleDemoBean() {
        System.out.println("INSIDE LIFECYCLEDEMOBEAN CONSTRUCTOR");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MY NAME IS " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory factory) {
        System.out.println("SETTING BEAN FACTORY");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("SETTING APPLICATION CONTEXT");
    }

    public void beforeInit() {
        System.out.println("POST BEFORE INITIALIZATION METHOD");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("THE BEAN HAS BEEN CONSTRUCTED");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("NOW ALL THE PROPERTIES HAVE BEEN SET");
    }

    public void afterInit() {
        System.out.println("POST AFTER INITIALIZATION METHOD");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("THE CONTAINER IS GOING TO DESTROY MY BEAN");
    }

    @Override
    public void destroy() {
        System.out.println("INSIDE DESTROY METHOD OF DISPOSABLE BEAN INTERFACE");
    }
}
