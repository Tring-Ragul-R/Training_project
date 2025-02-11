const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

document.getElementById("submit-btn").addEventListener("click", function(){
    console.log("hello")
    let username=document.getElementById("name")
    let name = username.value.trim()
    let email=document.getElementById("email").value.trim()
    let mobileNumber=document.getElementById("phone").value.trim()
    let password=document.getElementById("password").value.trim()

    if(name.length==0){
        
        username.placeholder = "Fill your Name";
        return
        
    }

    if(username.length<3&&username.length>0){
        alert("Invalid Username")
        return
    }

    if(email.length==0){
        email.
    }
    if(!emailRegex.test(email)){
        alert("Invalid Email")
        return
    }

    if(mobileNumber.length!==10){
        alert("Invalid Phone Number")
        return
    }

    if(!passwordRegex.test(password)){
        alert("Invalid password")
        return
    }

    setCookie({email:email,password:password})

    window.location.href="SignIn.html"
})

function setCookie(userData){
    let date = new Date();
    date.setTime(date.getTime()+5*24*60*60*1000)
    const expires = date.toUTCString()
    document.cookie="userData="+encodeURIComponent(JSON.stringify(userData))+";path=/;"+"expires="+expires+";"
}

