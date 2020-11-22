package softuni.jsonprocessing.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonprocessing.domain.entities.Customer;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Set<Customer> findAllByOrderByBirthDateAscYoungDriverAsc();

    Set<Customer> findAllBySalesNotNull();

    @Query("SELECT c FROM Customer c WHERE c.sales.size > 0 ")
    Set<Customer> findAllByAtLeastOneCar();
}
