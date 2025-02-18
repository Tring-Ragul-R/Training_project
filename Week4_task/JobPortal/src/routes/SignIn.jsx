
import React, { useContext } from "react";
import { UserContext } from "../App";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import "../routes/SignUp.css";

function SignIn() {
  const { arrData,setLog } = useContext(UserContext);
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
    //console.log( data);

    const userFound = arrData.some(
      (user) => user.email === data.email && user.password === data.password
    );

    if (userFound) {
        setLog(true)
      navigator("/persona")
    } 
    else{
        alert("user not found");
    }
  };

  return (
    <div style={{height:"70vh"}} >
      <div className="signin-parent-con">
        <h1>SignIn</h1>
        <form className="signup-form" onSubmit={handleSubmit(funSubmit)}>
          <input
            type="email"
            placeholder="Enter Email"
            {...register("email", { required: "email is required" })}
          />
          {errors.email && <p className="error">{errors.email.message}</p>}

          <input
            type="password"
            placeholder="Enter Password"
            {...register("password",{required:"password is reqiured"})}
          />
            {errors.password && <p className="error">{errors.password.message}</p>}
          <button type="submit">LogIn</button>
        </form>
        <p>Don't have a Account <span style={{color:"#287da1",fontWeight:"700"}} onClick={clickSignup}>sign up</span></p>
      </div>
    </div>
  );
}

export default SignIn;