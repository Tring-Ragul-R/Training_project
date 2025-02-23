import { Outlet } from "react-router-dom";
import Header from "./Header.jsx";
import { createContext, useState } from "react"; 
import {ToastContainer} from 'react-toastify';
import 'bootstrap/dist/css/bootstrap.css';

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
        <ToastContainer/>
        
        
       { !log && <Header />}
        
        <Outlet />
        
      </UserContext.Provider>
    </>
  );
}

export default App;
