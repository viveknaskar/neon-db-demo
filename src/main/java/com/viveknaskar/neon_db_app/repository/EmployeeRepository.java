package com.viveknaskar.neon_db_app.repository;

import com.viveknaskar.neon_db_app.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
