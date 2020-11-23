package nl.leonw.demo1.fullboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<DBCustomer, UUID> {
    List<DBCustomer> findAll();
    List<DBCustomer> findByLastName(String lastName);
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class DBCustomer {
    private UUID id;
    private String firstName;
    private String lastName;
}
