package cl.fullstack.springbootproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServiceTest extends AbstractTest {

    @Test
    @Transactional
    protected void createCustomerWithAddress() {
        log.setCurrentTest("INSERT CUSTOMER TO DATABASE");
        log.start();
        createDefaultModel();

        testCustomer.addAddress(testAddress);
        dbCustomer = customerService.save(testCustomer);
        log.message(dbCustomer);

        dbCredential = credentialService.findByCustomerId(dbCustomer.getId());
        log.message(dbCredential);

        dbAddresses = addressService.entityDAO.getAllByCustomerId(dbCustomer.getId());
        dbAddresses.forEach(address -> log.message(address.toString()));

        dbAddresses.forEach(address -> {
            assertEquals(address.getCustomer().getId(), dbCustomer.getId());
        });

        log.finish();
    }
}
