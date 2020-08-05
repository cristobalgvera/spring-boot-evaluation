package cl.fullstack.springbootproject.model.user;

import cl.fullstack.springbootproject.model.DefaultModel;

public class DefaultCustomer extends AbstractUser implements DefaultModel<Customer> {
    @Override
    public Customer create() {
        setDefaultStuffs("ROLE_CUSTOMER");

        Customer customer = new Customer();
        {
            customer.setPersonData(personData);
            customer.setCredential(credential);
            credential.setCustomer(customer);
        }
        return customer;
    }
}
