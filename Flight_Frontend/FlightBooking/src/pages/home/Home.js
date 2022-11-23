import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";

import { useNavigate } from "react-router-dom";
import { useState } from "react";
import "./home.css";
import { DesktopDatePicker } from "@mui/x-date-pickers/DesktopDatePicker";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import dayjs from "dayjs";
const Home = () => {
  const navigate = useNavigate();

  const citiesList = [
    "Gwalior",
    "Indore",
    "Bhopal",
    "Delhi",
    "Banglore",
    "Ahemdabad",
    "Mumbai",
    "Goa",
    "Kolkata",
    "Vellore",
  ];
  const [source, setSource] = useState("Delhi");
  const [destination, setDestination] = useState("Goa");
  const [date, setDate] = useState(new Date());
  const [flightList, setFlightList] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const getFlightList = () => {
    const flightDate = date.$D + "-" + (date.$M + 1) + "-" + date.$y;
    // console.log("Source:- ", source);
    // console.log("Destination:- ", destination);
    // console.log("Flight Date:- ", flightDate);
    // const url =
    // "http://localhost:8080/journey?flightSource=kolkata&flightDestination=mumbai&journeyDate=10-12-2022";
    const url = `http://localhost:8080/journey?flightSource=${source}&flightDestination=${destination}&journeyDate=${flightDate}`;
    // console.log(url);
    navigate("/flights", { state: { url } });
  };

  return (
    <div>
      <div style={{ marginTop: 20 }}>
        <div class="container text-center">
          <div class="row">
            <div class="col-4">
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DesktopDatePicker
                  label="Journey Date"
                  class="form-control me-2"
                  placeholder="Journy Date"
                  inputFormat="DD/MM/YYYY"
                  value={date}
                  disablePast={true}
                  onChange={(value) => {
                    console.log(value);
                    setDate(value);
                  }}
                  renderInput={(params) => <TextField {...params} />}
                />
              </LocalizationProvider>
            </div>
            <div class="col-4">
              {/* <input class="form-control me-2" type="search" placeholder="Source" aria-label="Search"/> */}

              <Autocomplete
                disablePortal
                id="combo-box-demo"
                options={citiesList}
                sx={{ width: 300 }}
                renderInput={(params) => (
                  <TextField {...params} label="Source" />
                )}
                value={source}
                onChange={(e, value) => {
                  console.log("Source: ", value);
                  setSource(value);
                }}
                getOptionSelected={(option, value) => option === value}
              />
            </div>
            <div class="col-4">
              {/* <input class="form-control me-2" type="search" placeholder="Destination" aria-label="Search"/> */}

              <Autocomplete
                disablePortal
                id="combo-box-demo"
                options={citiesList}
                sx={{ width: 300 }}
                value={destination}
                renderInput={(params) => (
                  <TextField {...params} label="Destination" />
                )}
                onChange={(e, value) => {
                  setDestination(value);
                }}
                getOptionSelected={(option, value) => option === value}
              />
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
                  style={{ width: "100%" }}
                  onClick={getFlightList}
                  class="btn btn-success"
                >
                  Search
                </button>
              </div>
              <div class="col-4"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
