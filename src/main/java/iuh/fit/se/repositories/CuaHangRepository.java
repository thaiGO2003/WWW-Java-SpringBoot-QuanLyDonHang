package iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.CuaHang;
@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, Integer>{

}
