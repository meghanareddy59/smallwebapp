$(document).ready(function(){
$("#signup").click(function(){
var email = $("#s_email").val();
var password = $("#s_password").val();


$.post('SignupServlet', {
    emailId : email,
     passwordId : password,

    }, function(responseText) {
   alert(responseText);
   console.log(responseText)
 }
        );
    });



$("#login").click(function(){
var email = $("#email").val();
var password = $("#password").val();
 $.post('LoginServlet', {
    email : email,
     password : password,

    }, function(responseText) {

    if(responseText==="Success")
    {
     window.location.replace("page.html");
    }
    else{
       alert(responseText);}


 }
        );
    });
    });