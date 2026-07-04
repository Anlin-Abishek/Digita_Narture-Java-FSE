public interface CustomerRepository {
    String findCustomerById(int id);
}

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 101) {
            return "Alice Smith";
        }
        return "Customer Not Found";
    }
}
