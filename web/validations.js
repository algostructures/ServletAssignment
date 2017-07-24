/**
 * Created by prajapas on 7/21/2017.
 */
function validateForm() {
    console.log("in Validate");
    var name = document.signupform.name.value;
    var password = document.signupform.password.value;
    var number = document.signupform.phone.value;
    var username = document.signupform.username.value;
    if (name == "") {
        alert("Name must be filled out");
        return false;
    }
    if(username == ""){
        alert("Name must be filled out");
        return false;
    }
    if (password.length < 6){
        alert("Password must be 6 characters long");
        return false;
    }
    if (number.length != 10){
        alert("Phone Number Must be 10 chars long");
        return false;
    }
}