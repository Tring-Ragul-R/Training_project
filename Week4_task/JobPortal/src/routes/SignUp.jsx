import React, { useContext } from "react";
import { useForm } from "react-hook-form";
import "../routes/SignUp.css";

import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

function SignUp() {
  const navigator = useNavigate();

  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const submit = (data) => {
    const strData = JSON.stringify(data);
    localStorage.setItem("user", strData);
    toast.success("User Registered Successfully");
    navigator("/signin");
  };

  return (
    <div style={{ width: "100%" }}>
      <div className="parent-signup-con">
        <h1>Signup</h1>
        <form className="signup-form" onSubmit={handleSubmit(submit)}>
          <div>
            <label>Name</label>
            <input
              type="text"
              placeholder="Enter Name"
              {...register("name", { required: "name required" })}
            />
            {errors.name && <p className="error">{errors.name.message}</p>}
          </div>

          <div>
          <label>Email</label>
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
          </div>
          <div>
          <label>password</label>
            <input
              type="password"
              placeholder="Enter Password"
              {...register("password", {
                required: "Password required",
                pattern: {
                  value:
                    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/,
                  message: "password contain atleast 8 character",
                },
              })}
            />
            {errors.password && (
              <p className="error">{errors.password.message}</p>
            )}
          </div>
          <div>
            <label >confirm Password</label>
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
          </div>
          <button type="submit">Sign In</button>
        </form>
      </div>
    </div>
  );
}

export default SignUp;
