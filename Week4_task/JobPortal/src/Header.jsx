import React, { useContext } from "react";
import HeaderImg from "./assets/tringapps-copy-2 (1).png";
import { useNavigate} from 'react-router-dom'
import { UserContext } from "./App";
import "./Home.css"

function Header(){
  const {log,setLog} = useContext(UserContext);
const navigator = useNavigate();
  const signup = ()=>{
    navigator("/signup")
  }
  const signin = ()=>{
    navigator("/signin")
  }
  const logout = ()=>{
    setLog(false);
    localStorage.removeItem("user")
    navigator("/signup")
  }
    return(
      <div className="header">
              <div>
                <img src={HeaderImg} alt="" />
              </div>
              <div
                className="header-btn"
                style={{ display: "flex", columnGap: "25px" }}
              >
                {!log?(
                  <>
                  <button className="sign" onClick={signup}>sign Up</button>
                
             
                  <button className="sign" onClick={signin}>sign In</button>
                  </>
                  ):

                  <button className="sign" onClick={logout}>Logout</button>
                  
                }
    
              </div>
            </div>
    );
  }
  
  
export default Header;