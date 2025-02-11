document.getElementById("signin-button").addEventListener("click",function(){
    const email = document.getElementById("signin-email").value.trim()
    const password  = document.getElementById("signin-password").value.trim()

    console.log(email,password);
    
    
    let userData = getCookie("userData")
    if(userData==null){
        alert("Session Timed Out")
        return;
    }
    const data = JSON.parse(userData)
    if(data.email!==email){
       return alert("Invalid Email")
    }
    if(data.password!==password){
        return alert("Invalid password")
    }
    window.location.href="Home.html"
})

function getCookie(name){
 const cookies = document.cookie.split(";")
 for(let i =0;i<cookies.length;i++){
    let c = cookies[i].split("=")
    if(c[0]==name)
        return decodeURIComponent(c[1])
 }
 return null;
}