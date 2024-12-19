package iuh.fit.se.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Table(name = "DonHang")
@Entity
@Data
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String maDonHang = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	@NotEmpty(message = "Ten khach hang khong duoc rong")
	@Size(min = 5,max = 50, message = "Ten khach hang it nhat 5 ky tu va be hon 50 ky tu")
	private String tenKhachHang;
	@Email(message = "Email phai dung dinh dang cua email")
	@NotEmpty(message = "Email khong duoc rong")
	private String email;
	@Future(message = "Ngay dat hang phai lon hon ngay hien tai")
	@NotNull(message = "Ngay dat hang khong duoc rong")
	private LocalDate ngayDatHang;
	@NotEmpty(message = "Ten san pham khong duoc rong")
	private String tenSP;
	private boolean trangThai;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "maCuaHang")
	private CuaHang cuaHang;
}
