import React, { useState } from "react";

import Box from "@mui/material/Box";
import { Button } from "@mui/material";
import TextField from "@mui/material/TextField";

import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import InputLabel from "@mui/material/InputLabel";

const AddCustomer = () => {
  const location = useLocation();
  const navigateTo = useNavigate();
  const flight = location.state.flight;
  console.log(flight);
  const {
    fare,
    flightId,
    flightCarrier,
    flightSource,
    flightDestination,
    departure,
    journeyDate,
  } = flight;
  const [user, setUser] = React.useState({
    name: "",
    age: "",
    gender: "abc",
  });
  console.log(user);

  const [list, setList] = React.useState([]);
  const [totalFare, setTotalFare] = useState(0);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onAdd = () => {
    if (user.name == "") return;

    setList([...list, user]);
    alert("User Added Sucessfully !!");
    setTotalFare((list.length + 1) * fare);
  };
  console.log("fare: ", fare);

  function updateDB() {
    console.log("Id: ", flightId);
    const url = `http://localhost:8080/updateSeats/${flightId}?bookedSeat=${list.length}`;
    // const url = "http://localhost:8080/updateSeats/AIR 22345?bookedSeat=4";
    axios
      .put(url, flight)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }

  function bookTicket() {
    const passengers = list.map((data, index) => {
      return {
        passengerName: data.name,
        passengerGender: data.gender,
        passengerAge: data.age,
        seatNumber: `S${index + 1}`,
      };
    });
    const current = new Date();

    const date = `${current.getDate()}-${
      current.getMonth() + 1
    }-${current.getFullYear()}`;

    const data = {
      bookingId: "T" + Math.floor(Math.random() * 1000000),
      bookingDate: date,
      passengers,
      flight,
      price: totalFare,
    };

    axios
      .post("http://localhost:8080/bookTicket", data)
      .then((res) => {
        console.log(res);
        if (res.status === 200) {
          updateDB();
          navigateTo("/ticket", {
            state: { flight, list, ticketId: data.bookingId },
          });
        }
        console.log(ticketId);
      })
      .catch((err) => {
        console.log(err);
      });
  }

  return (
    <>
      <div>
        <div style={{ marginTop: 20 }}>
          <div class="container text-center">
            <div class="row">
              <div class="col-4">
                <TextField
                  id="outlined-basic"
                  name="name"
                  onChange={handleChange}
                  label="Name"
                  fullWidth
                  variant="outlined"
                />
              </div>
              <div class="col-4">
                <TextField
                  id="outlined-basic"
                  name="age"
                  onChange={handleChange}
                  label="Age"
                  fullWidth
                  variant="outlined"
                />
              </div>
              <div class="col-4">
                <FormControl fullWidth>
                  <InputLabel id="demo-simple-select-label">Gender</InputLabel>
                  <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={user.gender}
                    label="gender"
                    onChange={(e) => {
                      setUser({ ...user, gender: e.target.value });
                    }}
                  >
                    <MenuItem value={"Male"}>Male</MenuItem>
                    <MenuItem value={"Female"}>Female</MenuItem>
                  </Select>
                </FormControl>
              </div>
            </div>
          </div>

          <div style={{ marginTop: 30 }}>
            <div class="container text-center">
              <div class="row">
                <div class="col-4"></div>
                <div class="col-4">
                  <button
                    type="button"
                    onClick={onAdd}
                    style={{ width: "100%" }}
                    class="btn btn-success"
                  >
                    Add
                  </button>
                </div>
                <div class="col-4"></div>
              </div>
            </div>
          </div>
        </div>
        <div style={{ marginTop: "5em" }}>
          <table class="table">
            <thead>
              <th scope="col">SN.</th>
              <th scope="col">Name</th>
              <th scope="col">Age</th>
              <th scope="col">Gender</th>
            </thead>
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
          </table>
        </div>
        <div>
          <div style={{ marginLeft: "70em" }}>
            <h4>
              <span>Total : </span>
              <span>{totalFare}</span>
            </h4>
          </div>
          <div style={{ textAlign: "center" }}>
            <Button
              onClick={() => {
                bookTicket();
              }}
              variant="contained"
              color="success"
            >
              Confirm
            </Button>
          </div>
        </div>
      </div>
    </>
  );
};

export default AddCustomer;
