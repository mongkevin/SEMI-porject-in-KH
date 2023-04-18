<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .outer{
            color: black;
            width: 1000px;
            height: 500px;
            margin: auto;
            margin-top: 50px;
        }
        .outer>h2{
            border-style: solid white;
            border-radius: 120px;
            background-color: rgb(223, 223, 30);
            width: 600px;
            margin:auto;
            text-align:center;
        }
        #enroll-form>table{border : 1px solid white;}
        #enroll-form input,textarea{
        	width : 100%;
        	box-sizing:border-box;
        }
        #but{
        	float: right;
        }
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 >공지사항 작성</h2>
		<br>
		<form action="<%=contextPath%>/insert.no" method="post" id="enroll-form">
			
			<table align="center">
				<tr>
					<td width="50">제목 :</td>
					<td width="450"><input type="text" name="title" required></td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="15" cols="20" name="content" style="resize:none" required></textarea>
					</td>
					
				</tr>
				
			</table>
			<br><br>
			<div id="but">
				 <button type="submit">등록하기</button>
				 
				 <button type="button" onclick="history.back();">뒤로가기</button>
				 <!-- history.back() :이전페이지로 돌아가기 -->
			</div>
		
		</form>
		<br><br><br><br>
	</div>

</body>
</html>