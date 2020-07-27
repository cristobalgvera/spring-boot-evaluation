package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.constant.Model;
import cl.fullstack.springbootproject.model.DefaultModelCreator;
import cl.fullstack.springbootproject.model.user.Customer;
import cl.fullstack.springbootproject.model.user.Employee;
import cl.fullstack.springbootproject.model.user.util.Credential;
import cl.fullstack.springbootproject.model.visit.*;
import cl.fullstack.springbootproject.util.TestLog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;

public class AbstractTest {
    // Generic
    protected Map<String, Object> defaultModelList;

    // Model: Users
    protected Customer testCustomer, dbCustomer;
    protected Employee testEmployee, dbEmployee;
    protected Credential testCredential, dbCredential;

    // Model: Visit
    protected Activity testActivity, dbActivity;
    protected Address testAddress, dbAddress;
    protected Payment testPayment, dbPayment;
    protected Summary testSummary, dbSummary;
    protected Visit testVisit, dbVisit;

    // Model: Collections<?> (basics)
    protected Collection<Address> dbAddresses;
    protected Collection<Activity> dbActivities;
    protected Collection<Payment> dbPayments;
    protected Collection<Summary> dbSummaries;
    protected Collection<Visit> dbVisits;

    // Services

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected EmployeeService employeeService;

    @Autowired
    protected CredentialService credentialService;

    @Autowired
    protected ActivityService activityService;

    @Autowired
    protected AddressService addressService;

    @Autowired
    protected PaymentService paymentService;

    @Autowired
    protected SummaryService summaryService;

    @Autowired
    protected VisitService visitService;

    @Autowired
    protected TestLog log;

    @Autowired
    protected DefaultModelCreator defaultModelCreator;

    protected void createDefaultModel() {
        defaultModelList = defaultModelCreator
                .createDefaultModel();

        testCustomer = (Customer) defaultModelList.get(Model.CUSTOMER);
        testEmployee = (Employee) defaultModelList.get(Model.EMPLOYEE);
        testAddress = (Address) defaultModelList.get(Model.ADDRESS);
    }
}
