import { Outlet } from "react-router-dom";
import Header from "./Header.jsx";
import { createContext, useState } from "react"; 
import {ToastContainer} from 'react-toastify';
import 'bootstrap/dist/css/bootstrap.css';

export const UserContext = createContext();
function App() {
  const [log,setLog] = useState(false)
  const [cardData,setCardData] = useState([])
 


  return (
    <>
      <UserContext.Provider value={{log,setLog,cardData,setCardData }}>
        <ToastContainer/>
        
        
       <Header />
        
        <Outlet />
        
      </UserContext.Provider>
    </>
  );
}

export default App;
