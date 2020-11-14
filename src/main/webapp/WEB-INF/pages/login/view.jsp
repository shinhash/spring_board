<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>login</title>
    
    <%@ include file="/WEB-INF/pages/linkInfo/link_tag_Info.jsp" %>
    
    
    
    
    
    
    
    <script>

		$(function(){
			// remember me cookie 확인
			if(Cookies.get("REMEMBERME") == "Y"){
				$('#userid').val(getCookieValue("USERNM"))
				$('input[type=checkbox]').prop('checked', true)
			}


			$('#signIn').on('click', function(){

				if($('input[type=checkbox]').prop('checked') == true){
					Cookies.set('REMEMBERME', 'Y');
					Cookies.set('USERNM', $('#userid').val());
					$('#userid').val(Cookies.get("USERNM"));
					
				}else{
					Cookies.remove('REMEMBERME');
					Cookies.remove('USERNM');
				}
				
				// submit 처리
				$('#loginForm').submit();
			})
		})

    </script>
    
    
    
    
    
  </head>

  <body>

    <div class="container">

      <form id="loginForm" class="form-signin" action="${cp }/login/check" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" id="userid" name="userid" value="brown" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pass" value="brownPass" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="signIn">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>
