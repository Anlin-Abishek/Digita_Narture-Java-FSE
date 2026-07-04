public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerDetails(int id) {
        String customerName = customerRepository.findCustomerById(id);
        System.out.println("Customer Profile Details: " + customerName);
    }
}
