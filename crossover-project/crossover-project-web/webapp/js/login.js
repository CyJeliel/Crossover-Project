function check(form) {
	if ( form.login.value.length != 0 && form.password.value.length != 0 ) {
		form.submit();
	} else {
		alert("Error: Login and password cannot be left blank.");
	}
}