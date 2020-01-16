<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.member{
width:500px;
height: 800px;
border: 1px solid #bbbbbb;
margin-left:35%;

}

.btn{
margin-top:20px;
margin-left:100px;
width:170px;
height:70px;


}
p{
margin-left:100px;


}
.tx{
margin-left:100px;

}

h2{
margin-left:100px;

}


</style>
</head>
<body>



<form method="post" action="mb_ok">
<div class="member">
<h2>회원가입</h2>
<p>아이디 :</p> <input type="text" name="id" class="tx"></br>
<p>비밀번호 :</p> <input type="text" name="pw" class="tx"></br>
<p>이름 : </p> <input type="text" name="name" class="tx"></br>
<p>이메일 :</p> <input type="email" name="email" class="tx"></br>
<p>휴대폰 :</p> <input type="text" name="phone" class="tx"></br>
<p>주소 :</p> <input type="text" name="address" class="tx"></br>
<p>생년월일 :</p> <input type="text" name="birthday" class="tx"></br>

<input type="submit" value="회원가입" class="btn"></br>
<input type="reset" value="초기화" class="btn">

</div>
</form>
</body>
</html>