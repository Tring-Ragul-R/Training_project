
import React, { useContext } from "react";
import { UserContext } from "../App";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import "../routes/SignUp.css";
import { toast } from "react-toastify";

function SignIn() {
  const {setLog } = useContext(UserContext);
  const navigator = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const clickSignup = ()=>{
    navigator("/signup")
  }
  const funSubmit = (data) => {

   
    const user = JSON.parse(localStorage.getItem("user"));
   if(user==undefined){
    toast.error("user not found")
   }
   let flag;
   if(user){
      flag = user.email === data.email;
   }
    if ( flag) {
      if(user.password===data.password){
        setLog(true)
        toast.success("User Login Successfull")
      navigator("/persona")
      }
      else{
        toast.error("Invalid password")
      }
    } 
    else{
      toast.error("user not found")
    }
  };

  return (
    <div style={{height:"70vh"}} >
      <div className="signin-parent-con">
        <h1>SignIn</h1>
        <form className="signup-form" onSubmit={handleSubmit(funSubmit)}>
          <div>
            <label>Email</label>
          <input
            type="email"
            placeholder="Enter Email"
            {...register("email", { required: "email is required" })}
          />
          {errors.email && <p className="error">{errors.email.message}</p>}
          </div>
          <div>
            <label>password</label>
          <input
            type="password"
            placeholder="Enter Password"
            {...register("password",{required:"password is reqiured"})}
          />
            {errors.password && <p className="error">{errors.password.message}</p>}
            </div>
          <button type="submit">LogIn</button>
        </form>
        <br />
        <br />
        <p>Don't have a Account <span id="create-acc" onClick={clickSignup}>sign up</span></p>
      </div>
    </div>
  );
}

export default SignIn;