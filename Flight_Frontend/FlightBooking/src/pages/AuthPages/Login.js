import React from "react";
import "../../pages/AuthPages/login.css";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();

  const onlogin = (e) => {
    e.preventDefault();

    localStorage.setItem("key", "myLogin");
    window.location.reload();
  };
  const myStyle = {
    backgroundImage:
      "url('https://www.collinsdictionary.com/images/full/airport_324754607.jpg')",
    height: "100vh",
    //marginTop: "-70px",
    fontSize: "50px",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
  };

  return (
    <>
      <div style={myStyle}>
        <h1 style={{}}>Welcome to Travel Port</h1>
      </div>

      <div
        style={{ display: "flex", justifyContent: "center", marginTop: -450 }}
      >
        <div
          style={{
            border: "1px double green",
            padding: 2,
            borderStyle: "double",
          }}
        >
          <div
            style={{
              border: "1px double green",
              padding: 30,
              borderStyle: "double",
            }}
          >
            <form>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">
                  Email address
                </label>
                <input
                  type="email"
                  class="form-control"
                  id="exampleInputEmail1"
                  aria-describedby="emailHelp"
                />
                <div id="emailHelp" class="form-text">
                  We'll never share your email with anyone else.
                </div>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">
                  Password
                </label>
                <input
                  type="password"
                  class="form-control"
                  id="exampleInputPassword1"
                />
              </div>
              <div class="mb-3 form-check">
                <label class="form-check-label" for="exampleCheck1">
                  {" "}
                  <i>
                    Don't have an account ?{" "}
                    <span
                      style={{ color: "blue", cursor: "pointer" }}
                      onClick={() => navigate("/register")}
                    >
                      {" "}
                      Login Here!!{" "}
                    </span>
                  </i>{" "}
                </label>
              </div>

              <button
                class="btn btn-primary"
                onClick={(e) => {
                  onlogin(e);
                }}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
