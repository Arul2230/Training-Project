$(function() {
          $('#login-form-link').click(function(e) {
      		$("#login-form").delay(100).fadeIn(100);
       		$("#register-form").fadeOut(100);
      		$('#register-form-link').removeClass('active');
      		$(this).addClass('active');
      		e.preventDefault();
      	});
      	$('#register-form-link').click(function(e) {
      		$("#register-form").delay(100).fadeIn(100);
       		$("#login-form").fadeOut(100);
      		$('#login-form-link').removeClass('active');
      		$(this).addClass('active');
      		e.preventDefault();
      	});
      
      });
var check = function() {

  if (!document.getElementById('password').value ) {
    document.getElementById('register-submit').disabled =true;
    document.getElementById('message').innerHTML = '';
  } else if (document.getElementById('password').value ==
    document.getElementById('confirm-password').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'Password Matching';
    document.getElementById('register-submit').disabled =false;
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'Password does not match';
    document.getElementById('register-submit').disabled=true;
  }
}
