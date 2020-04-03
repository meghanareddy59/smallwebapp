function userInfo(){

alert("hi");
 $.get('UserDetailsServlet',{

  },
function(responseText){
console.log("came");
  if(responseText.length>0 && responseText !== "null"){

                        UiFunction(responseText);
                      }
              else
                    alert(responseText);



 });

}


function UiFunction(details){
var main_div=document.createElement('div');
     main_div.setAttribute('class','main_div');
     document.body.appendChild(main_div);
  var users = JSON.parse(details);
console.log(users)
   var i=0;
  while(i<users.length)
  {
  var user=users[i];
console.log(user);
    var email=user.email;
    var password=user.password;
      var image1=user.image;
     var user_div=document.createElement('div');
     user_div.setAttribute('class','user_div');
     main_div.appendChild(user_div);
      var imgDiv = document.createElement('div');
             imgDiv.setAttribute('class','imgdiv');
             var image = document.createElement('img');
             image.setAttribute('src',image1);
             image.setAttribute('class','userphoto');
             imgDiv.appendChild(image);
             user_div.appendChild(imgDiv);
                  var name = document.createElement('h1');
                     name.textContent = email;
                      imgDiv.appendChild(name);
                   var deleteUser = document.createElement('input');
                   deleteUser.setAttribute('class','delete');
                   deleteUser.setAttribute('type','button');
                     deleteUser.setAttribute('value','delete');
imgDiv.appendChild(deleteUser);


i++;
    }



  }
