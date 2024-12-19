package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.entities.CuaHang;
import iuh.fit.se.repositories.CuaHangRepository;
import iuh.fit.se.services.CuaHangService;

@Service
public class CuaHangServiceImpl implements CuaHangService{
	@Autowired
	private CuaHangRepository cuaHangRepository;

	@Override
	public List<CuaHang> findAll() {
		// TODO Auto-generated method stub
		return cuaHangRepository.findAll();
	}
	
}
