package cl.fullstack.springbootproject.model.visit;

import cl.fullstack.springbootproject.model.DefaultModel;

public class DefaultAddress implements DefaultModel<Address> {
    @Override
    public Address create() {
        Address address = new Address();
        {
            address.setCountry("Chile");
            address.setCity("Temuco");
            address.setStreet("Olimpia");
            address.setBlock("B");
            address.setAddressNumber(1049);
        }
        return address;
    }
}
