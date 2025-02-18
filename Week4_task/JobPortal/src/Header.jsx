import React from "react";
import HeaderImg from "./assets/tringapps-copy-2 (1).png";
import {Link} from 'react-router-dom'
import "./Home.css"

function Header(){
    return(
      <div className="header">
              <div>
                <img src={HeaderImg} alt="" />
              </div>
              <div
                className="header-btn"
                style={{ display: "flex", columnGap: "25px" }}
              >
                <Link to="/signup">
                  <button className="sign">sign Up</button>
                </Link>
                <Link to="/signin">
                  <button className="sign">sign In</button>
                </Link>
              </div>
            </div>
    );
  }
  
  
export default Header;