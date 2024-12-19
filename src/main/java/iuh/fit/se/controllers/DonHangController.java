package iuh.fit.se.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.se.entities.DonHang;
import iuh.fit.se.services.CuaHangService;
import iuh.fit.se.services.DonHangService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/donhang")
public class DonHangController {
	@Autowired
	private DonHangService donHangService;
	@Autowired
	private CuaHangService cuaHangService;
	
	@GetMapping("")
	public String showAllScreen(Model model) {
		model.addAttribute("listDonHang", donHangService.findAll());
		return "list";
	}
	@GetMapping("/search")
	public String searhcScreen(Model model, @RequestParam(name = "maDonHang", required = false, defaultValue = "") String maDonHang, @RequestParam(name = "tenCuaHang", required = false, defaultValue = "") String tenCuaHang) {
		model.addAttribute("listDonHang", donHangService.findDonHangByMaDonHangOrTenCuaHang(maDonHang,tenCuaHang));
		return "list";
	}
	@GetMapping("/save/{id}")
	public String saveScreen(@PathVariable(name = "id", required = true) int id, Model model) {
		DonHang donHang = null;
		if(id == 0) {
			donHang = new DonHang();
			donHang.setId(id);
		}
		else {
			donHang = donHangService.findById(id);
		}
		model.addAttribute("donHang", donHang);
		model.addAttribute("listCuaHang", cuaHangService.findAll());
		return "save";
	}
	@PostMapping("/remove/{id}")
	public String removeAction(@PathVariable int id) {
		donHangService.remove(id);
		return "redirect:/donhang";
	}
	@PostMapping("/save")
	public String saveAction(@ModelAttribute @Valid DonHang donHang, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("listCuaHang", cuaHangService.findAll());
			return "save";
		}
		try {
			if(donHang.getId()==0)
				donHangService.save(donHang);
				else donHangService.update(donHang.getId(), donHang);
		} catch (Exception e) {
			bindingResult.rejectValue("email","error.email",e.getMessage());
			model.addAttribute("listCuaHang", cuaHangService.findAll());
			return "save";
		}
		
		return "redirect:/donhang";
	}
}
