import React, { useEffect, useState } from "react";

import Box from "@mui/material/Box";
import { Button } from "@mui/material";
import TextField from "@mui/material/TextField";

import axios from "axios";
import { useLocation } from "react-router-dom";

const Ticket = () => {
  const location = useLocation();
  const flight = location.state.flight;
  const persons = location.state.list;

  const ticketId = location.state.ticketId;

  return (
    <>
      <div>
        {/* <table class="table">
          <tbody>
            {list.reverse().map((row, index) => (
              <tr>
                 <th scope="row">{index + 1}</th>
                <td>{row.name}</td>
                <td>{row.age}</td>
                <td>{row.gender}</td> 
              </tr>
            ))}
          </tbody>
        </table> */}

        <div
          style={{
            width: "100%",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <div style={{ textAlign: "center", margin: "20px 0" }}>
            <h3>
              <span>Ticket : {ticketId}</span>
            </h3>
          </div>
        </div>
      </div>

      <div
        style={{
          width: "70%",
          margin: "0 auto",
          padding: "20px",
          border: "2px solid #000",
          borderRadius: "20px",
        }}
      >
        <div
          style={{
            width: "100%",
            display: "flex",
            justifyContent: "space-between",
            marginBottom: "20px",
          }}
        >
          <div>
            <p>Source : {flight.flightSource}</p>
            <p>Destination : {flight.flightDestination}</p>
            <p>Flight Name : {flight.flightCarrier}</p>
          </div>
          <div>
            {" "}
            <p>Date Of Journey : {flight.journeyDate}</p>
            <p>Departure Time : {flight.departure}</p>
            <p>Total Fare : {flight.fare * persons.length}</p>
          </div>
        </div>

        <table class="table">
          <tbody>
            {persons.map((row, index) => (
              <tr>
                <td>{row.name}</td>
                <td>{row.age}</td>
                <td>{row.gender}</td>
                <td>S{index + 1}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default Ticket;
