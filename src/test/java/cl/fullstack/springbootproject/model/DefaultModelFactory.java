package cl.fullstack.springbootproject.model;

import cl.fullstack.springbootproject.constant.Model;
import cl.fullstack.springbootproject.model.user.DefaultCustomer;
import cl.fullstack.springbootproject.model.user.DefaultEmployee;
import cl.fullstack.springbootproject.model.visit.DefaultAddress;
import org.springframework.stereotype.Component;

@Component
public class DefaultModelFactory {
    public Object create(String model) {
        DefaultModel defaultModel = null;
        switch (model) {
            case Model.CUSTOMER:
                defaultModel = new DefaultCustomer();
                break;
            case Model.ADDRESS:
                defaultModel = new DefaultAddress();
                break;
            case Model.EMPLOYEE:
                defaultModel = new DefaultEmployee();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + model);
        }
        return defaultModel.create();
    }
}
