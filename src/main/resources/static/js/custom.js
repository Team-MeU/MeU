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
				window.location.href="../../";
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
				console.log("login success");
				window.location.href = '../../';
			});
	});

	$(document).on("click","#logout-button",function(){
		var session_id = $.cookie('id');
		console.log("로그아웃!");
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

		$.ajax({
			method: "POST",
			url: "/post",
			data: JSON.stringify({
				"content": content
			}),
			contentType: "application/json"
		})
		.done(function(response) {
			console.log("Post creation success!");
			window.location.href = "/";
		})
		.fail(function(response) {
			alert("로그인 후 이용할 수 있습니다.");
			window.location.href = "/user/login";
		});
	});

	$("#post-edit").click(function(){

	});

	$("#post-delete").click(function(){
		var id = $("#post-id").val();

		$.ajax({
			method: "DELETE",
			url: "/post",
			data: {
				"id": id,
			}
		})
		.done(function(response) {
			console.log("Post delete success!");
			window.location.href = "/";
		})
		.fail(function(response) {
			alert("게시물 삭제 권한이 없습니다.");
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
                 "<img src=\"img/rmate1.jpg\" class=\"img-fluid rounded-circle\" alt=\"commenters-img\">"+
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