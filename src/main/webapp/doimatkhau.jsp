<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
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


</head>
<body>
	
		<%
				Object obj = session.getAttribute("khachHang");
					KhachHang khachHang = null;
					if (obj != null)
						khachHang = (KhachHang)obj;
					if (khachHang == null) {
		%>
		<h1>Bạn chưa đăng nhập! Vui lòng quay lại trang chủ</h1>
		<%
					}else{
					String baoLoi = request.getAttribute("baoLoi")+"";
						if(baoLoi.equals("null")){
							baoLoi="";
						}
		%>
		
		<div class="container">
		<h1 style="text-align: center">ĐỔI MẬT KHẨU</h1>
		<span style="color: red"> <%=baoLoi%>
		</span>
<!-- trở về trang tự động -->
		<%
		if(baoLoi.equals("Mật khẩu đã thay đổi thành công")){
		%>
		<h5>Tự động quay lại sau: <span id="countdown" style="color: red">5</span> giây.</h5>
		<%} %>
		<form action="doi-mat-khau" method="post">
		
		<div class="mb-3">
			<label for="matKhauHienTai" class="form-label">Mật khẩu hiện
				tại</label> <input type="password" class="form-control" id="matKhauHienTai"
				name="matKhauHienTai">
		</div>
		<div class="mb-3">
			<label for="matKhauMoi" class="form-label">Mật khẩu mới</label><span style="color: red" id="ktra"></span>
			 <input type="password" class="form-control" id="matKhauMoi"
				name="matKhauMoi" required="required" onkeyup="kiemTraMatKhau()">
				
		</div>
		<div class="mb-3">
			<label for="matKhauNhapLai" class="form-label">Nhập lại mật
				khẩu </label> <input type="password" class="form-control"
				id="matKhauNhapLai" name="matKhauNhapLai" required="required">
		</div>
		
		<button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
	</form>
	</div>
	<% } %>
	<script>
    let countdownTime = 5;
	    function updateCountdown() {
		        countdownTime--;
		        document.getElementById("countdown").textContent = countdownTime;
		        if (countdownTime <= 0) {
		            window.location.href = 'index.jsp';
		        }
		    }
		    setInterval(updateCountdown, 1000);
	    function kiemTraMatKhau() {
			matKhauMoi = document.getElementById("matKhauMoi").value;
			matKhauHienTai = document.getElementById("matKhauHienTai").value;
			if (matKhauMoi == matKhauHienTai) {
				document.getElementById("ktra").innerHTML = "Mật khẩu này giống mật khẩu bạn đang dùng";
				return false;
			} else {
				document.getElementById("ktra").innerHTML = "";
				return true;
			}
		}    
    
    
</script>
</body>
</html>