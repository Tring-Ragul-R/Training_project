import { Outlet } from "react-router-dom";
import "./App.css";
import Header from "./Header.jsx";
import { createContext, useEffect, useState } from "react";


export const UserContext = createContext();
function App() {
  const [data, setData] = useState({
    name: "",
    email: "",
    password: "",
  });
  const [arrData, setArrData] = useState([]);
  const [log,setLog] = useState(false)
  const [cardData,setCardData] = useState([])
 


  return (
    <>
      <UserContext.Provider value={{ data, setData,arrData,setArrData,setLog,cardData,setCardData }}>
       { !log && <Header />}
        
        <Outlet />
        
      </UserContext.Provider>
    </>
  );
}

export default App;
