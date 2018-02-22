<template>

	    <h3 class="page-title">Login</h3>
	    <form id="login-form" class="form-horizontal">
	        <div class="form-group">
	            <label for="emailaddress" class="col-sm-2 control-label">Email Address</label>
	            <div class="col-sm-10">
	                <input type="text" style="width:500px;"class="form-control" id="emailaddress" name="emailaddress" required>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="password" class="col-sm-2 control-label">Password</label>
	            <div class="col-sm-10">
	                <input type="password" style="width:500px;" class="form-control" id="password" name="password"required>
	            </div>
	        </div>
			<div class="form-actions">
			   <center>
	       			<button type="submit" class="btn btn-primary">Login!</button>
		       </center>
   			</div>
	    	</form>
		</div>
	
</template>

<script>
$(function() {
    "use strict";

    $("#login-form").on('submit', function(event) {
        event.preventDefault();
        $.ajax({
            url: "http://ec2-52-53-167-111.us-west-1.compute.amazonaws.com:8086/gateway/customer/auth",
            type: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({
                email: $('#emailaddress').val(),
                password: $('#password').val()
            })
        }).done(function(response) {
            alert("Login Successful!")
            window.location.href = "homepage.html";
        }).fail(function(response) {
            switch (response.status) {
                case 401:
                    alert("Incorrect credentials. Please try again");
                    break;
                case 400:
                    $.notify('Bad Request. Missing required fields', 'error');
                    break;
                default:
                    $.notify('Internal Server Error, failed to login. Please try again.', 'error');
            }
        });
    });
});

    
</script>