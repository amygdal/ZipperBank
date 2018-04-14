package io.zipcoder.repository;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository <Account, Long>{
    List<Account> findByCustomer_Id(Long customerId);
}
