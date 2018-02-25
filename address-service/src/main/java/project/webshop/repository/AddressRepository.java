package project.webshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.webshop.domain.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
}