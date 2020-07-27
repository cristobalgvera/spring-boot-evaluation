package cl.fullstack.springbootproject.model;

import cl.fullstack.springbootproject.constant.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultModelCreator {
    @Autowired
    private DefaultModelFactory defaultModelFactory;

    public Map<String, Object> createDefaultModel() {
        Map<String, Object> basicsList = new HashMap<>();
        basicsList.put(Model.CUSTOMER, defaultModelFactory.create(Model.CUSTOMER));
        basicsList.put(Model.ADDRESS, defaultModelFactory.create(Model.ADDRESS));
        basicsList.put(Model.EMPLOYEE, defaultModelFactory.create(Model.EMPLOYEE));
        return basicsList;
    }
}
