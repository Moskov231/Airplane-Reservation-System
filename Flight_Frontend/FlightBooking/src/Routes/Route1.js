import React from "react";
import Home from "../pages/home/Home";
import Navbar from "../components/navbar/Navbar";

import AddCustomer from "../pages/AddCutstomer/Add";

import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import FlightList from "../pages/AddCutstomer/FlightList";
import Ticket from "../pages/AddCutstomer/Ticket";

const Route1 = () => {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/flights" element={<FlightList></FlightList>}></Route>
        <Route path="/add_customer" element={<AddCustomer />} />
        <Route path="/ticket" element={<Ticket />} />
        <Route path="*" element={<Navigate to="/" replace={true} />} />
      </Routes>
    </>
  );
};

export default Route1;
