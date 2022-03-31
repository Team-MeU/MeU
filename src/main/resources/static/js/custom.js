/*
Template Name: Vogel - Social Network & Community HTML Template
Author: Askbootstrap
Author URI: https://themeforest.net/user/askbootstrap
Version: 1.0
*/

(function ($) {
	"use strict"; // Start of use strict

	$(document).ready(function(){
		var session_id = $.cookie('id');
		if (session_id) {
			console.log("login now!");
			$("#logout-button").show();
			$("#login-button").hide();
			$("#signup-menu").hide();
		} else {
			console.log("No login now!");
			$("#logout-button").hide();
			$("#login-button").show();
			$("#signup-menu").show();
		}
	});

	$("#signup-submitButton").click(function(){
		var email = $("#name").val();
		var nickname = $("#nickname").val();
		var password = $("#password").val();

		$.ajax({
			method: "POST",
			url: "/user",
			data: JSON.stringify({
				"email": email,
				"nickname": nickname,
				"password": password
			}),
			contentType: "application/json"
		})
			.done(function(response) {
				console.log("signup success");
				window.location.href="/";
			})
			.fail(function(response) {
				alert("입력 정보를 확인해주세요.")
			});
	});

	$("#login-submitButton").click(function(){
		var email = $("#name").val();
		var password = $("#password").val();

		$.ajax({
			method: "POST",
			url: "/user/login",
			data: JSON.stringify({
				"email": email,
				"password": password
			}),
			contentType: "application/json"
		})
		.done(function(response) {
			console.log("로그인!");
			window.location.href = '/';
		});

	});

	$(document).on("click","#logout-button",function(){
		var session_id = $.cookie('id');
		console.log("로그아웃!");
		$.ajax({
			method: "DELETE",
			url: "/user/session",
			data: {
				"id": session_id
			}
		})
		.done(function(response) {
			document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
			window.location.href = "/";
		});
	});

	$("#checkpwd_btn").click(function(){
		var password = $("#floatingPass").val();
		var session_id = $.cookie('id');
		console.log(password);
		console.log(session_id);

		$.ajax({
			method: "POST",
			url: "/checkpwd/post",
			data: JSON.stringify({
				"password": password,
				"sessionId": session_id
			}),
			contentType: "application/json",
			success: function (result) {
				if(result==true) {
					console.log("right password");
					window.location.href = '/edit-profile';
				} else {
					alert("비밀번호가 틀렸습니다!");
					location.reload();
				}
			},
			error: function () {
				alert("비밀번호가 틀렸습니다!");
				location.reload();
			}
		})
	});

	$("#saveProfile-button").click(function(){
		var nickname = $("#floatingName").val();
		var birth = $("#floatingBirth").val();
		var email = $("#floatingEmail").val();
		var password = $("#floatingPass").val();

		console.log(nickname);
		console.log(birth);
		console.log(email);
		console.log(password);

		$.ajax({
			method: "PUT",
			url: "/user/edit-profile",
			data: JSON.stringify({
				"email": email,
				"nickname": nickname,
				"password": password
			}),
			contentType: "application/json",
			success: function (result) {
				alert("수정 완료!");
				location.reload();
			},
			error: function () {
				alert("수정 실패!");
				location.reload();
			}
		})

	});

	var Popular = {
		init: function () {
			this.Basic.init();
		},

		Basic: {
			init: function () {

				this.ListSlider();

			},

			// list_slider
			ListSlider: function () {
				$('.account-slider').slick({
					dots: false,
					arrows: false,
					infinite: false,
					speed: 300,
					slidesToShow: 4.2,
					slidesToScroll: 4.2,
					responsive: [
						{
							breakpoint: 1024,
							settings: {
								slidesToShow: 4.5,
								slidesToScroll: 4.5,
							}
						},
						{
							breakpoint: 680,
							settings: {
								slidesToShow: 2.5,
								slidesToScroll: 2.5
							}
						},
						{
							breakpoint: 520,
							settings: {
								slidesToShow: 3.5,
								slidesToScroll: 3.5
							}
						},
						{
							breakpoint: 422,
							settings: {
								slidesToShow: 2.5,
								slidesToScroll: 2.5
							}
						}
					]
				});
			},



		}
	}
	jQuery(document).ready(function () {
		Popular.init();
	});

	$("#post-create").click(function(){
		var content = $("#post-content").val();
		var formData = new FormData();
		var file = $("input[id=uploadFile]")[0].files[0];

		if (file == null){
			alert("파일을 선택해 주세요");
			return false;
		}

		formData.append("content", content);
		formData.append("file", file);

		$.ajax({
			method: "POST",
			url: "/post",
			data: formData,
			processData: false,
			contentType: false,
			// dataType: 'json',
			success: function(data){
				alert("업로드 성공");
				console.log("Post create success!");
				location.href = "/";
			},
			err: function (err){
				alert("업로드 실패");
				return false;
			}
		})
	});

	$("#post-edit").click(function(){

	});


    $(document).on("click","#post-delete",function(){
		var id   = $(this).parent().parent().children("#dropdown-postId").val();
		$.ajax({
			method: "DELETE",
			url: "/post",
			data: {
				"id": id,
			}
		})
        .done(function(response) {
            console.log("post remove success!");
            window.location.reload();
            })
        .fail(function(response) {
            alert("해당 권한이 없습니다. (현재 post-id : "+id);
            window.location.href = "/";
        });
	});


	$(document).on("click","#logout-button",function(){
		var session_id = $.cookie('id');

		$.ajax({
			method: "DELETE",
			url: "/user/session",
			data: {
				"id": session_id,
			}
		})
			.done(function(response) {
				document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
				window.location.href = "/";
			});
	});

	$(document).on("click","#more-comment-button",function(){
		var id   = $(this).parent().children("#post-id").val();
        var next_page = parseInt($(this).attr("current-comment-page")) + 1;
		$.ajax({
			method: "GET",
			url: "/comment",
			data: {
				"postId": id,
				"page": next_page
			}
		})
		.done(function(response) {
		    for(var comment of response) {
		        $("#commentInPost"+id).append(
		        "<div class=\"comments\"><div class=\"d-flex mb-2\">"+
		         "<a href=\"#\" class=\"text-dark text-decoration-none\" data-bs-toggle=\"modal\" data-bs-target=\"#commentModal\">"+
                 "<img src="+comment.profileImg+" class=\"img-fluid rounded-circle\" alt=\"commenters-img\">"+
                 "</a> <div class=\"ms-2 small\">"+
                 "<a href=\"#\" class=\"text-dark text-decoration-none\" data-bs-toggle=\"modal\" data-bs-target=\"#commentModal\">"+
                 "<div class=\"bg-light px-3 py-2 rounded-4 mb-1 chat-text\">"+
                 "<p class=\"fw-500 mb-0\">"+comment.commentNickname+"</p>"+
                 "<span class=\"text-muted\">"+comment.commentContent+"</span>"+
                 "</div></a>"+
                 "<div class=\"d-flex align-items-center ms-2\">"+
                 "<input type=\"hidden\" id=\"comment-id\" value="+comment.commentId+">"+
                 "<input type=\"hidden\" id=\"user-id\" value="+comment.userId+">"+
                 "<input type=\"hidden\" id=\"post-id\" value="+comment.postId+">"+
                 "<input type=\"hidden\" id=\"content\" value="+comment.content+">"+
                 "<span class=\"fs-3 text-muted material-icons mx-1\">circle</span>"+
                 "<a class=\"small text-muted text-decoration-none\" id=\"comment-modify-button\">수정</a>"+
                 "<span class=\"fs-3 text-muted material-icons mx-1\">circle</span>"+
                 "<a class=\"small text-muted text-decoration-none\" id=\"comment-delete-button\">삭제</a>"+
                 "<span class=\"fs-3 text-muted material-icons mx-1\">circle</span>"+
                 "<span class=\"small text-muted\">"+comment.updatedAt+"</span>"+
                 "</div> </div> </div> </div>");
		    }
		})
		$(this).attr("current-comment-page", next_page);
	});

    $(document).on("keypress","#comment-create",function(e){
            if(e.which == 13){
                var id = $(this).parent().children("#post-id").val();
                var content = $(this).parent().children("#comment-create").val();
                $.ajax({
                		method: "POST",
                		url: "/comment",
                		data: JSON.stringify({
                		    "postId":  id,
                			"content": content
                			}),
                		contentType: "application/json"
                })
                .done(function(response) {
                    console.log("Comment creation success!");
                    window.location.reload();
                })
                .fail(function(response) {
                    alert("로그인이 필요한 서비스입니다");
                    window.location.href = "/user/login";
                });
            }
    });

    $(document).on("click","#comment-delete-button",function(){
		var id = $(this).parent().children("#comment-id").val();
		$.ajax({
			method: "DELETE",
			url: "/comment",
			data: {
				"commentId": id,
			}
		})
		.done(function(response) {
			console.log("Comment delete success!");
            window.location.reload();
		})
		.fail(function(response) {
			alert("해당 댓글의 삭제 권한이 없습니다.");
		});
	});

    $(document).on("click","#postLike-button",function(){
        var postId = $(this).parent().parent().children("#post-id").val();

		$.ajax({
			method: "POST",
			url: "/post/like",
			data: JSON.stringify({
                "postId": postId
            }),
            contentType: 'application/json',
		})

		.done(function(response) {
			console.log("좋아요 success! postId=>"+postId);
            window.location.reload();
		})
		.fail(function(response) {
			alert("로그인이 필요한 서비스입니다.");
		});
	});

    $(document).on("click","#comment-modify-button",function(){
		var id = $(this).parent().children("#comment-id").val();
        var userId = $(this).parent().children("#user-id").val();
        var postId = $(this).parent().children("#comment-id").val();
        var originContent = $(this).parent().children("#content").val();
        var content = prompt("댓글을 수정합니다.", originContent);
		$.ajax({
			    method: "PUT",
			    url: "/comment",
			    data: JSON.stringify({
				    "commentId": id,
				    "userId": userId,
				    "postId": postId,
				    "content": content
			    }),
		    contentType: 'application/json',
		})
		.done(function(response) {
        	console.log("Comment delete success!");
            window.location.reload();
        })
        .fail(function(response) {
        	alert("해당 댓글의 수정 권한이 없습니다.");
		})
	});

	$(document).on("click","#logout-button",function(){
		var session_id = $.cookie('id');

		$.ajax({
			method: "DELETE",
			url: "/user/session",
			data: {
				"id": session_id,
			}
		})
			.done(function(response) {
				document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
				window.location.href = "/";
			});
	});

})(jQuery); // End of use strict