<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<div class="d-flex justify-content-center">
		<%-- 로그인되어 있을 때만 보여진다. --%>
		<c:if test="${not empty userId}">
			<div class="w-50 border">
				<textarea cols="61" rows="3" placeholder="내용을 입력하세요."></textarea>
				
				<div class="d-flex justify-content-between">
					<a href="#"><img src="https://cdn.pixabay.com/photo/2016/03/31/19/13/icon-1294806_1280.png" width="30"></a>
					<button class="btn btn-info">업로드</button>
				</div>
			</div>
		</c:if>
	</div>
	
	<div class="d-flex justify-content-center mt-5">
		<div class="w-50 d-flex justify-content-between border">
			<div class="ml-2">${userId}</div>
			<div class="mr-2">
				<img src="https://www.iconninja.com/files/860/824/939/more-icon.png" width="30">
			</div>
		</div>
	</div>
	<div class="d-flex justify-content-center">
		<div class="w-50">
			<img src="https://cdn.pixabay.com/photo/2024/01/07/16/27/chinese-reed-8493547_1280.jpg" width="479">
		</div>
	</div>
	<div class="d-flex">
		<div class="w-50">
			<img src="https://www.iconninja.com/files/527/809/128/heart-icon.png" width="30">
			좋아요 11개
		</div>
	</div>
</div>