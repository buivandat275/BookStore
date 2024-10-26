<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Chúc mừng bạn đã đăng ký tài khoản thành công! Vui lòng quay lại trang đăng nhập!</h1>
 <h3>Tự động quay lại sau: <span id="countdown" style="color: red">5</span> giây.</h3>
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
</script>

</body>
</html>