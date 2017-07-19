/**
 * 
 */
window.onload = function(){
	
	loadTeacherProfile();
	
}

function loadTeacherProfile(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			
			console.log('loading profile code');
			var teacherProfile = JSON.parse(xhr.responseText);
			document.getElementById('profile').innerHTML = xhr.responseText;
			document.getElementById('userid').innerHTML = teacherProfile.userId;
			document.getElementById('email').innerHTML = teacherProfile.email;
			document.getElementById('firstName').innerHTML = teacherProfile.firstName;
			document.getElementById('lastName').innerHTML = teacherProfile.lastName;
		}

	}
	xhr.open("GET", "ajaxProcessProfile", true);
	xhr.send();
}