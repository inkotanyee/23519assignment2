function validateFname() {
  const fname = document.getElementById("fname").value;
  const fnameError = document.getElementById("fnameError");
  
  if (!fname.match(/^[a-zA-Z]+$/)) {
    fnameError.textContent = "Only letters allowed.";
  } else {
    fnameError.textContent = "";
  }
}
function validatePseudo() {
  const fname = document.getElementById("do").value;
  const fnameError = document.getElementById("doError");
  
  if (!fname.match(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{10,}$/)) {
    fnameError.textContent = "No Exceeding 10 character";
  } else {
    fnameError.textContent = "";
  }
}

function validateLname() {
  const lname = document.getElementById("lname").value;
  const lnameError = document.getElementById("lnameError");
  
  if (!lname.match(/^[a-zA-Z]+( [a-zA-Z]+)*$/)) {
    lnameError.textContent = " Only Letters allowed.";
  } else {
    lnameError.textContent = "";
  }
}
function validateEmail() {
  const email = document.getElementById("email").value;
  const emailError = document.getElementById("emailError");
  var pat = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (!email.match(pat)) {
    emailError.textContent = "Use the format aaa@example.com ";
  } else {
    emailError.textContent = "";
  }
}


function changeOption() {
  const l1 = document.getElementById("l1");
  const l2 = document.getElementById("l2");
  const departmentError = document.getElementById("departmentError");
  const facultyError = document.getElementById("facultyError");
  
  if (l1.value === "1") {
    l2.innerHTML = 
  "<option>Music</option><option>Movie</option><option>Documentary</option>";
  } else if (l1.value === "2") {
    l2.innerHTML =
  "<option>Live</option><option>Studio</option><option>Adventure</option>";
  } else if (l1.value === "3") {
    l2.innerHTML =
  "<option>Acrylic</option><option>Street</option><option>Canvas</option>";
  }
else{
    facultyError.textContent = "";
  }   
}


function validateBirthdate() {
  const dob = new Date(document.getElementById("dob").value);
  const dobError = document.getElementById("dobError");
  const today = new Date();
  const age = today.getFullYear() - dob.getFullYear();
  if (age > 18 || age < 30) {
//    dobError.textContent ="You must be between 18 and 30 years old.";
//  }
 //if( dob.getFullYear() ===""){
   dobError.textContent = "You must be btn 18-30 ";   
}else {
    dobError.textContent = "";
  }
  } 

function validateRadio() {
  const r = document.getElementsByName("gender").value;
  const genderError= document.getElementsByName("genderError");
  const checked = false;
  for (var i = 0; i < r.length; i++) {
    if (r[i].checked) {
      checked = true;
      break;
    }
  }
  if (!checked) {
    genderError.textContent = "Invalid Gender ";
    return false;
  }
 else {
    genderError.textContent = "";
  }}

function validatePhone() {
  const phone = document.getElementById("phone").value;
  const phoneError = document.getElementById("phoneError");
  if (phone.length === 9) {
    phoneError.textContent = "";
  } else {
    phoneError.textContent = "9 digits to add";
  }
}

function validatePassword() {
  const pass = document.getElementById("pass").value;
  const passError = document.getElementById("passError");
  //var confpass = document.getElementById("confpass").value;
  const pattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,}$/;
  
  if (!pattern.test(pass)) {
    passError.textContent ="Password must be 6 char,include a nbr,a letter and a special char ";
    return false;
  }else {
       passError.textContent = "";
  }
  }
  
  
  
  function validateConfPassword() {
   var pass = document.getElementById("pass").value;
   var confpass = document.getElementById("confpass").value;
   const confpassError = document.getElementById("confpassError");
   if (pass !== confpass) {
    confpassError.textContent ="Passwords do not match.";   
   }else {
        confpassError.textContent = "";
  }
  }
  
function validateFile() {
  const file = document.getElementById("myFile").value;
  if (!file.endsWith(".png") && !file.endsWith(".jpg")) {
    alert("Please select a PNG or JPG file.");
    document.getElementById("myFile").value = "";
  }
}

function validateFileType(){
var fileInput = document.getElementById("pdfFile");
var filePath = fileInput.value;
var allowedExtensions = /(\.pdf)$/i;
if(!allowedExtensions.exec(filePath)){
alert('Invalid file type. Only PDF files are allowed.');
fileInput.value = '';
return false;
}
}


function submitForm() {
  const form = document.getElementById("form");
  const fnameError = document.getElementById("fnameError").textContent;
  const lnameError = document.getElementById("lnameError").textContent;
  const emailError = document.getElementById("emailError").textContent;
  const dobError = document.getElementById("dobError").textContent;
  const departmentError = document.getElementById("departmentError").textContent;
  const facultyError = document.getElementById("facultyError").textContent;
  const genderError= document.getElementsByName("genderError").textContent;
  const phoneError = document.getElementById("phoneError").textContent;
  const passError = document.getElementById("passError").textContent;
  const confpassError = document.getElementById("confpassError").textContent;
  
    //const passwordError = document.getElementById("passwordError").textContent;
  
  if (!fnameError && !emailError && !lnameError && !dobError && !departmentError && !facultyError && !genderError && !phoneError && !passError && !confpassError) 
  {
      //return true;
      form.submitForm();
   
  //alert("Registered Successful!!"); 
    
}     
   else {
    alert("Please fix the errors before submitting the form.");
    return false;
  }
}

