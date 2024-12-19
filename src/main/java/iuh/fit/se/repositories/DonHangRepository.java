package iuh.fit.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.DonHang;
@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer>{
	@Query(value = "SELECT * FROM don_hang WHERE ma_cua_hang IN (SELECT ma_cua_hang FROM cua_hang WHERE ten LIKE :tenCuaHang)\r\n"
			+ "OR ma_don_hang LIKE :maDonHang" , nativeQuery = true)
	public List<DonHang> findDonHangByMaDonHangOrTenCuaHang(@Param("maDonHang") String maDonHang, @Param("tenCuaHang") String tenCuaHang);
	
	
	  @Query(value =
	  "SELECT * FROM don_hang WHERE ngay_dat_hang = :ngayDatHang AND email = :email" , nativeQuery = true) public List<DonHang>
	  findDonHangByNgayDatHangAndEmail(@Param("ngayDatHang") String
	  ngayDatHang, @Param("email") String email);
	 
}
