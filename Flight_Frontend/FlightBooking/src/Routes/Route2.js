import React from "react";
import Login from "../pages/AuthPages/Login";
import Register from "../pages/AuthPages/Register";
import { 
    BrowserRouter,
    Routes,
    Route,
    Navigate
  } from "react-router-dom";


const Route2 = () => {

    return(

<>

      <Routes>
        <Route path="/" element={<Login/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" element={<Register/>}/>
        <Route path='*' element={<Navigate to='/'  replace={true}    />}  />

      </Routes>
</>

    )
}

export default Route2;