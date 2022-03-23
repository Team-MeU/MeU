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

})(jQuery); // End of use strict