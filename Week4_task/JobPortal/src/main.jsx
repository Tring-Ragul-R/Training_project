import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import SignUp from './routes/SignUp.jsx'
import SignIn from './routes/SignIn.jsx'
import Home from './Home.jsx'
import Persona from './Persona.jsx'
import AddCard from './AddCard.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App/>}>
          <Route path='/' element={<Home/>}/>
          <Route path = '/persona' element={<Persona/>}/>
          <Route path="/signup" element={<SignUp />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path='/addcard' element={<AddCard/>} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
