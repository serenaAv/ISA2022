package isa.ProgettoEsame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.ProgettoEsame.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    //@Query("SELECT r FROM Roles r WHERE r.role = ?1")
    public Role findByRole(String role);
}
