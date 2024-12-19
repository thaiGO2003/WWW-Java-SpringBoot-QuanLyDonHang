package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.fit.se.entities.DonHang;
import iuh.fit.se.repositories.DonHangRepository;
import iuh.fit.se.services.DonHangService;
@Service
public class DonHangServiceImpl implements DonHangService{
	@Autowired
	private DonHangRepository donHangRepository;

	@Override
	public List<DonHang> findAll() {
		// TODO Auto-generated method stub
		return donHangRepository.findAll();
	}

	@Override
	public List<DonHang> findDonHangByMaDonHangOrTenCuaHang(String maDonHang, String tenCuaHang) {
		// TODO Auto-generated method stub
		if(!maDonHang.isEmpty()) {
			maDonHang = "%"+maDonHang+"%";
		}
		if(!tenCuaHang.isEmpty()) {
			tenCuaHang = "%"+tenCuaHang+"%";
		}
		return donHangRepository.findDonHangByMaDonHangOrTenCuaHang(maDonHang,tenCuaHang );
	}

	@Override
	@Transactional
	public DonHang save(DonHang donHang) throws Exception{
		// TODO Auto-generated method stub
		if(donHangRepository.findDonHangByNgayDatHangAndEmail(donHang.getNgayDatHang().toString(), donHang.getEmail()).isEmpty()) {
			return donHangRepository.save(donHang);	
		} else {
			throw new Exception("Mot email chi co the lap 1 don hang trong 1 ngay");
		}
		
	}
	@Override
	@Transactional
	public DonHang update(int id,DonHang donHang) throws Exception {
		DonHang donHangGoc = findById(id);
		if(donHangGoc!=null) {
			if(!donHangRepository.findDonHangByNgayDatHangAndEmail(donHang.getNgayDatHang().toString(), donHang.getEmail()).isEmpty() && !donHangGoc.getNgayDatHang().equals(donHang.getNgayDatHang())) {
				throw new Exception("Mot email chi co the lap 1 don hang trong 1 ngay");
			} else {
				return donHangRepository.save(donHang);	
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void remove(int id) {
		DonHang donHang = findById(id);
		if(donHang!=null && donHang.isTrangThai() == false) donHangRepository.delete(donHang);
	}

	@Override
	public DonHang findById(int id) {
		// TODO Auto-generated method stub
		return donHangRepository.findById(id).get();
	}
}
