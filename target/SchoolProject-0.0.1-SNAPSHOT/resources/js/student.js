/**
 * 
 */
window.onload = function(){
	//loadNavbar();
	loadStudentProfile();
	
}


function loadStudentProfile(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			
			console.log('loading profile code');
			var studentProfile = JSON.parse(xhr.responseText);
			document.getElementById('profile').innerHTML = xhr.responseText;
			document.getElementById('userid').innerHTML = studentProfile.userId;
			document.getElementById('email').innerHTML = studentProfile.email;
			document.getElementById('firstName').innerHTML = studentProfile.firstName;
			document.getElementById('lastName').innerHTML = studentProfile.lastName;
		}

	}
	xhr.open("GET", "ajaxProcessProfile", true);
	xhr.send();
}
