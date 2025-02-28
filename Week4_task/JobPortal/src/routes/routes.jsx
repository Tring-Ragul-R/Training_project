import App from '../App.jsx'
import { Route, Routes } from 'react-router-dom'
import SignUp from './SignUp.jsx'
import SignIn from './SignIn.jsx'
import Home from '../Home.jsx'
import Persona from '../Persona.jsx'
import AddCard from '../AddCard.jsx'


const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="/" element={<Home />} />
        <Route path="/persona" element={<Persona />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/addcard" element={<AddCard />} />
      </Route>
    </Routes>
  );
};

export default Router;
