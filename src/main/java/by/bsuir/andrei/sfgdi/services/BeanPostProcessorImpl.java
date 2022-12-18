package by.bsuir.andrei.sfgdi.services;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object object, String name) {
        if (object instanceof LifeCycleDemoBean) {
            ((LifeCycleDemoBean) object).beforeInit();
        }
        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String name) {
        if (object instanceof LifeCycleDemoBean) {
            ((LifeCycleDemoBean) object).afterInit();
        }
        return object;
    }
}
