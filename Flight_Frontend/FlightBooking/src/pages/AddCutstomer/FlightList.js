import React from "react";

import { useNavigate, useLocation } from "react-router-dom";
import Button from "@mui/material/Button";

const FlightList = () => {
  const navigateTo = useNavigate();
  const location = useLocation();
  const [flightList, setFlightList] = React.useState([]);
  const url = location.state.url;

  React.useEffect(() => {
    fetch(url)
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        setFlightList(data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  console.log(flightList);
  return (
    <>
      <div>
        <div style={{ marginTop: 20 }}>
          <table class="table">
            <thead>
              <th scope="col">S.No.</th>
              <th scope="col">Airlines</th>
              <th scope="col">Departure</th>
              <th scope="col">Duration</th>
              <th scope="col">Arrive</th>
              <th scope="col">Fare</th>
              <th scope="col">Seats</th>
              <th scope="col"></th>
            </thead>
            <tbody>
              {flightList.map((data, index) => {
                return (
                  <tr key={`flight${index}`}>
                    <th scope="row">{index + 1}</th>
                    <td>{data.flightCarrier}</td>
                    <td>{data.departure}</td>
                    <td>{data.duration}</td>
                    <td>{data.reach}</td>
                    <td>{data.fare}</td>
                    <td>{data.seatCapacity}</td>
                    <td>
                      <Button
                        variant="contained"
                        onClick={() => {
                          navigateTo("/add_customer", {
                            state: { flight: data },
                          });
                        }}
                        color="success"
                      >
                        Book
                      </Button>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default FlightList;
