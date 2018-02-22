<template>
<div id="background">
	    <h3 class="page-title">Customer Registration</h3>
	    <form id="registration-form" class="form-horizontal">
	        <div class="form-group">
	            <label for="firstname" class="col-sm-2 control-label">First Name</label>
	            <div class="col-sm-10">
	                <input type="text"  style="width:500px;" class="form-control" id="firstname" name="firstname" required>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="lastname" class="col-sm-2 control-label">Last Name</label>
	            <div class="col-sm-10">
	                <input type="text"  style="width:500px;" class="form-control" id="lastname" name="lastname"required>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="emailaddress" class="col-sm-2 control-label">Email Address</label>
	            <div class="col-sm-10">
	                <input type="text"  style="width:500px;" class="form-control" id="emailaddress" name="emailaddress"required>
	            </div>
	        </div>
	        <div class="form-group">
	            <label for="password" class="col-sm-2 control-label">Password</label>
	            <div class="col-sm-10">
	                <input type="password"  style="width:500px;" class="form-control" id="password" name="password"required>
	            </div>
	        </div>
			<div class="form-actions">
			   <center>
	       			<button type="submit" class="btn btn-primary">Register!</button>
		       </center>
   			</div>
	    </form>
		</div>
</template>

<script>
   $(function () {
    "use strict";

    $("#registration-form").on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: "http://ec2-52-53-167-111.us-west-1.compute.amazonaws.com:8086/gateway/customer/create",
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            data: JSON.stringify({
                firstName: $('#firstname').val(),
                lastName: $('#lastname').val(),
                email: $('#emailaddress').val(),
                password: $('#password').val()
            })
        }).done(function(response) {
            alert("Successfully registered!");
			window.location.href="homepage.html";
        }).fail(function(response){
            switch(response.status) {
                case 400:
                    $.notify('Bad Request. Missing required fields', 'error');
                    break;
                default:
                    $.notify('Internal Server Error, failed to register. Please try again.', 'error')
            }
        });
    });
});
 
</script>