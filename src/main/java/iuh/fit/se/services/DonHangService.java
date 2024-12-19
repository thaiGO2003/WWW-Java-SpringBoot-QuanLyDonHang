package iuh.fit.se.services;

import java.util.List;

import iuh.fit.se.entities.DonHang;

public interface DonHangService {
	public List<DonHang> findAll();
	public List<DonHang> findDonHangByMaDonHangOrTenCuaHang(String maDonHang, String tenCuaHang);
	public DonHang save(DonHang donHang) throws Exception;
	public void remove(int id);
	public DonHang findById(int id);
	public DonHang update(int id, DonHang donHang) throws Exception;
}
