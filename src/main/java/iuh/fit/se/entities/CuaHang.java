package iuh.fit.se.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "CuaHang")
public class CuaHang {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maCuaHang;
	private String ten;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cuaHang")
	private Set<DonHang> donHangs;
}
