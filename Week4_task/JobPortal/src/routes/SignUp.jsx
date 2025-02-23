
import React, { useContext } from "react";
import { useForm } from "react-hook-form";
import "../routes/SignUp.css";
import { UserContext } from "../App";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

function SignUp() {
  const navigator = useNavigate();
  const { setData } = useContext(UserContext);
  const {setArrData} = useContext(UserContext)
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();
 
  const submit = (data) => {
    setData(data);
    setArrData((oldArr)=>[...oldArr,data])
    toast.success("User Registered Successfully")
    navigator("/signin");
  };


  return (
   
      <div style={{width:"100%"}}>
        <div className="parent-signup-con">
          <h1>Signup</h1>
          <form className="signup-form" onSubmit={handleSubmit(submit)}>
            <input
              type="text"
              placeholder="Enter Name"
              {...register("name", { required: "name required" })}
            />
            {errors.name && <p className="error">{errors.name.message}</p>}

            <input
              type="email"
              placeholder="Enter Email"
              {...register("email", {
                required: "Email required",
                pattern: {
                  value: /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/,
                  message: "email format is wrong",
                },
              })}
            />
            {errors.email && <p className="error">{errors.email.message}</p>}

            <input
              type="password"
              placeholder="Enter Password"
              {...register("password", { required: "Password required" })}
            />
            {errors.password && (
              <p className="error">{errors.password.message}</p>
            )}

            <input
              type="password"
              placeholder="Confirm Password"
              {...register("confirmPassword", {
                required: "Confirm Password required",
                validate: (value) =>
                  value === watch("password") || "Passwords doesn't match",
              })}
            />
            {errors.confirmPassword && (
              <p className="error">{errors.confirmPassword.message}</p>
            )}

            <button type="submit">Sign In</button>
          </form>
        </div>
      </div>
  
  );
}

export default SignUp;
