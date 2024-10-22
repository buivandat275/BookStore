<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1, shrink-to-fit=no">
<title>Đăng ký</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
<style type="text/css">
#red {
	color: red;
}

.red {
	color: red;
}
</style>
</head>
<body>
	<%
	String baoLoi = request.getAttribute("baoLoi")+"";
	baoLoi = (baoLoi.equals("null"))?"":baoLoi;

	
	String tenDangNhap= request.getAttribute("tenDangNhap")+"";	
	tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
	
	String hoVaTen= request.getAttribute("hoVaTen")+"";
	hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;
	
	String gioiTinh= request.getAttribute("gioiTinh")+"";
	gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;
	
	String ngaySinh= request.getAttribute("ngaySinh")+"";
	ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;
	
	String diaChiKhachHang= request.getAttribute("diaChiKhachHang")+"";
	diaChiKhachHang = (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;
	
	String diaChiMuaHang= request.getAttribute("diaChiMuaHang")+"";
	diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;
	
	String diaChiNhanHang= request.getAttribute("diaChiNhanHang")+"";
	diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;
	
	String dienThoai= request.getAttribute("dienThoai")+"";
	dienThoai = (dienThoai.equals("null"))?"":dienThoai;
	
	String email= request.getAttribute("email")+"";
	email = (email.equals("null"))?"":email;
	
	String dongYNhanE= request.getAttribute("dongYNhanE")+"";
	dongYNhanE = (dongYNhanE.equals("null"))?"":dongYNhanE;
	%>
	<div class="container">
		<h1 style="text-align: center">Đăng Ký Tài Khoản</h1>
		<div class="red" id="baoLoi">
			<%=baoLoi%>

		</div>
		<form action="DangKy" method="post">
			<div class="row">
				<div class="col-md-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="user" class="form-label">Tên đăng nhập</label><span
							id="red">*</span> <input type="text" class="form-control"
							id="user" name="user" required="required" value="<%=tenDangNhap%>">

					</div>
					<div class="mb-3">
						<label for="pass" class="form-label">Mật khẩu</label><span
							id="red">*</span> <input type="password" class="form-control"
							id="pass" name="pass" required="required">

					</div>
					<div class="mb-3">
						<label for="passnn" class="form-label">Nhập lại mật khẩu</label><span
							id="red">*</span><span style="color: red" id="ktra"></span> <input
							type="password" class="form-control" id="passnn" name="passnn"
							required="required" onkeyup="kiemTraMatKhau()">

					</div>

					<h3>Thông Tin Khách Hàng</h3>
					<div class="mb-3">
						<label for="hoVaTen" class="form-label">Họ và tên</label> <input
							type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen %>">
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> <select
							id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam" <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %> >Nam</option>
							<option value="Nữ" <%=(gioiTinh.equals("Nữ"))?"selected='selected'":"" %> >Nữ</option>
							<option value="Khác" <%=(gioiTinh.equals("Khác"))?"selected='selected'":"" %> >Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày Sinh</label> <input
							type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>">
					</div>
				</div>
				<div class="col-md-6">
					<h3>Địa Chỉ</h3>
					<div class="mb-3">
						<label for="diaChiKhachHang" class="form-label">Địa chỉ khách
							hàng</label> <input type="text" class="form-control" id="diaChiKhachHang"
							name="diaChiKhachHang" value="<%=diaChiKhachHang%>">
					</div>
					<div class="mb-3">
						<label for="diaChimh" class="form-label">Địa chỉ mua hàng</label>
						<input type="text" class="form-control" id="diaChimh"
							name="diaChimh" value="<%=diaChiMuaHang%>">
					</div>
					<div class="mb-3">
						<label for="diaChinh" class="form-label">Địa chỉ nhận hàng</label>
						<input type="text" class="form-control" id="diaChinh"
							name="diaChinh" value="<%=diaChiNhanHang%>">
					</div>
					<div class="mb-3">
						<label for="dienThoai" class="form-label">Điện thoại</label> <input
							type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="text" class="form-control" id="email" name="email" value="<%=email%>">
					</div>
					<hr />
					<div class="mb-3">
						<label for="DongYDieuKhoan" class="form-label">Đồng ý với
							điều khoản của dat</label><span id="red">*</span> <input type="checkbox"
							class="form-check-input" id="DongYDieuKhoan"
							name="DongYDieuKhoan" required="required" onchange="ktrDongY()" >
					</div>
					<div class="mb-3">
						<label for="DongYNhanE" class="form-label">Đồng ý nhận
							email thông báo</label> <input type="checkbox" class="form-check-input"
							id="DongYNhanE" name="DongYNhanE">
					</div>
					<input type="submit" value="Đăng ký"
						class="btn btn-primary form-control" name="submit" id="submit"
						style="opacity: 0.5;" disabled>
				</div>
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	function kiemTraMatKhau() {
		matKhau = document.getElementById("pass").value;
		matKhauNhapLai = document.getElementById("passnn").value;
		if (matKhau != matKhauNhapLai) {
			document.getElementById("ktra").innerHTML = "Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("ktra").innerHTML = "";
			return true;
		}
	}
	function ktrDongY() {
		dongYDieuKhoan = document.getElementById("DongYDieuKhoan");
		submit = document.getElementById("submit");
		if (dongYDieuKhoan.checked == true) {
			document.getElementById("submit").style.opacity = "1";
			submit.disabled = false; // cho phép trương tác
		} else {
			document.getElementById("submit").style.opacity = "0.5";
			;
			submit.disabled = true;
		}
	}
</script>

</html>