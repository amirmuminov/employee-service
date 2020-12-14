package kz.muminov.employeeservice.repository;

import kz.muminov.employeeservice.model.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<EmployeeRole, Long> {

    Optional<EmployeeRole> findFirstByCodeEquals(String code);

}
