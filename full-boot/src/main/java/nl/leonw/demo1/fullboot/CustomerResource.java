package nl.leonw.demo1.fullboot;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@AllArgsConstructor
public class CustomerResource {

    private CustomerRepository customerRepository;

    @GetMapping("/customers/")
    @ApiOperation(
            value = "Get all customers matching the optional query parameters",
            notes = "The query parameter lastName is optional"
    )
    public List<Customer> getCustomers(@RequestParam("lastName") Optional<String> lastName) {
        List<DBCustomer> dbCustomers = lastName
                .map(name -> customerRepository.findByLastName(name))
                .orElseGet(() -> customerRepository.findAll());

        return dbCustomers.stream()
                    .map(this::dbToApiCustomer)
                    .collect(Collectors.toList());
    }

    @GetMapping("/customers/{id}")
    @ApiOperation(value = "Get a single customer", notes = "returns 404 if customer is not found")
    public Customer getCustomer(@PathVariable("id") String id) {
        return customerRepository.findById(UUID.fromString(id))
                .map(this::dbToApiCustomer)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find customer with id " + id));
        // orElse( value ) vs orElse( supplier ): value is always evaluated, supplier only on demand
    }


    private Customer dbToApiCustomer(DBCustomer dbc) {
        // OF COURSE we decouple the DB structure from our REST API.
        // Otherwise we could never refactor the DB without breaking all consumers of our service.
        return  new Customer(
                dbc.getId().toString(),
                dbc.getFirstName(),
                dbc.getLastName());
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
    private String id;
    private String firstName;
    private String lastName;
}
