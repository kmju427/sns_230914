<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex justify-content-center">
	<div class="contents-box">
		<%-- 글쓰기 영역(로그인된 사람만 보이게) --%>
		<c:if test="${not empty userId}">
		<div class="write-box border rounded m-3">
			<textarea id="writeTextArea" placeholder="내용을 입력해주세요" class="w-100 border-0"></textarea>
			
			<div class="d-flex justify-content-between">
				<div class="file-upload d-flex">
					<%-- file 태그를 숨겨두고 이미지를 클릭하면 file 태그를 클릭한 것과 같은 효과 --%>
					<input type="file" id="file" accept=".jpg, .jpeg, .gif, .png" class="d-none">
				
					<%-- 이미지에 마우스를 올리면 마우스 커서가 변하도록 적용 --%>
					<a href="#" id="fileUploadBtn"><img width="35" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"></a>
					
					<%-- 업로드된 임시 이미지 파일 이름 나타내는 곳 --%>
					<div id="fileName" class="ml-2"></div>
				</div>
				<button id="writeBtn" class="btn btn-info">게시</button>
			</div>
		</div> <%--// 글쓰기 영역 끝 --%>
		</c:if>
		
		<%-- 타임라인 영역 --%>
		<div class="timeline-box my-5">
			<c:forEach items="${postList}" var="post">
			<%-- 카드1 --%>
			<div class="card border rounded mt-3">
				<%-- 글쓴이, 더보기(삭제) --%>
				<div class="p-2 d-flex justify-content-between">
					<span class="font-weight-bold">${post.userId}</span>
					
					<a href="#" class="more-btn">
						<img src="https://www.iconninja.com/files/860/824/939/more-icon.png" width="30">
					</a>
				</div>	
				
				<%-- 카드 이미지 --%>
				<div class="card-img">
					<img src="${post.imagePath}" class="w-100" alt="본문 이미지">
				</div>
				
				<%-- 좋아요 --%>
				<div class="card-like m-3">
					<a href="#" class="like-btn">
						<img src="https://www.iconninja.com/files/214/518/441/heart-icon.png" width="18" height="18" alt="empty heart">
					</a>
					
					좋아요 13개
				</div>
				
				<%-- 글 --%>
				<div class="card-post m-3">
					<span class="font-weight-bold">${post.userId}</span>
					<span>${post.content}</span>
				</div>
				
				<%-- 댓글 제목 --%>
				<div class="card-comment-desc border-bottom">
					<div class="ml-3 mb-1 font-weight-bold">댓글</div>
				</div>
				
				<%-- 댓글 목록 --%>
				<div class="card-comment-list m-2">
					<%-- 댓글 내용들 --%>
					<div class="card-comment m-1">
						<span class="font-weight-bold">댓글쓰니</span>
						<span>댓글 내용1111</span>
						
						<%-- 댓글 삭제 버튼 --%>
						<a href="#" class="comment-del-btn">
							<img src="https://www.iconninja.com/files/603/22/506/x-icon.png" width="10" height="10">
						</a>
					</div>
					
					<%-- 댓글 쓰기 --%>
					<div class="comment-write d-flex border-top mt-2">
						<input type="text" class="form-control border-0 mr-2 comment-input" placeholder="댓글 달기"/> 
						<button type="button" class="comment-btn btn btn-light">게시</button>
					</div>
				</div> <%--// 댓글 목록 끝 --%>
			</div> <%--// 카드1 끝 --%>
			</c:forEach>
		</div> <%--// 타임라인 영역 끝  --%>
	</div> <%--// contents-box 끝  --%>
</div>

<script>
	$(document).ready(function() {
		// 파일 업로드 이미지 클릭 -> 숨겨져 있는 id="file" 동작시킨다.
		$("#fileUploadBtn").on('click', function(e) {
			e.preventDefault(); // a 태그의 기본 동작을 멈춤(스크롤 위로 올라가는 것)
			$("#file").click(); // input file을 클릭한 효과
		});
		
		// 사용자가 업로드할 이미지를 선택하는 순간 유효성 확인 및 업로드된 파일명 노출
		$("#file").on('change', function(e) {
			// alert("이미지 선택");
			
			// 업로드할 이미지를 선택하지 않고 취소하거나, 한 번 선택 후 또 선택하는 과정에서 취소할 때 비어있는 경우 처리
			let file = e.target.files[0];
			if (file == null) {
				$("#file").val(""); // 파일 태그 파일 제거(보이지 않지만 업로드될 수 있으므로 주의)
				$("#fileName").text(""); // 보여지는 파일명 비우기
				return;
			}
			
			// 업로드할 이미지 선택할 때
			let fileName = e.target.files[0].name; // desert-8460850_640.jpg
			console.log(fileName);
			
			// 확장자 유효성 체크
			let ext = fileName.split(".").pop().toLowerCase();
			// alert(ext);
			if (ext != "jpg" && ext != "jpeg" && ext != "png" && ext != "gif") {
				alert("이미지 파일만 업로드할 수 있습니다.");
				$("#file").val(""); // 파일 태그 파일 제거(보이지 않지만 업로드될 수 있으므로 주의)
				$("#fileName").text(""); // 보여지는 파일명 비우기
				return;
			}
			
			// 유효성 통과한 이미지의 경우 파일명 노출
			$("#fileName").text(fileName);
		});
		
		// 글 쓰기
		$("#writeBtn").on('click', function() {
			// alert("게시 버튼");
			
			// 글 내용, 이미지
			let content = $("#writeTextArea").val();
			let fileName = $("#file").val();
			
			if (!fileName) {
				alert("업로드할 이미지를 선택하세요.");
				return;
			}
			
			// 이미지 확장자 체크
			if (fileName) {
				// alert("업로드할 이미지가 있습니다.");
				let ext = fileName.split(".").pop().toLowerCase();
				// alert(ext);
				if (ext != "jpg" && ext != "jpeg" && ext != "png" && ext != "gif") {
					alert("이미지 파일만 업로드할 수 있습니다.");
					$("#file").val("");
					return;
				}
			}
			
			// form 태그를 js에서 만든다.
			// 이미지 업로드할 때는 반드시 form 태그가 있어야 한다.
			let formData = new FormData();
			formData.append("content", content); // key는 name 속성과 같다. Request Parameter명
			formData.append("file", $("#file")[0].files[0]);
			
			// AJAX
			$.ajax({
				// request
				type:"POST"
				, url:"/post/create"
				, data:formData
				, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
				, processData:false // 파일 업로드를 위한 필수 설정
				, contentType:false // 파일 업로드를 위한 필수 설정
				
				// response
				, success:function(data) {
					if (data.code == 200) {
						alert("게시글이 업로드 되었습니다.");
						location.href = "/timeline/timeline-view";
					} else {
						alert(data.error_message);
					}
				}
				, error:function(request, status, error) {
					alert("게시글을 업로드하는데 실패했습니다.");
				}
			});
		});
	});
</script>