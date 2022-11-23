import "./navbar.css";

import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();

  const onLogout = (e) => {
    e.preventDefault();

    localStorage.removeItem("key");
    window.location.reload();
  };

  return (
    <nav class="navbar navbar-expand-lg " style={{ backgroundColor: "#7bdcb5" }}>
      <div class="container-fluid">
        <a class="navbar-brand" onClick={() => navigate("/")}>
        Flight Booking System
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            {/* <li class="nav-item">
          <a class="nav-link"  onClick={()=> navigate('/hotels')}>Hotles</a>
        </li> */}
          </ul>
          <form class="d-flex" role="search">
            <button
              class="btn btn-outline-success"
              onClick={(e) => onLogout(e)}
            >
              Logout
            </button>
          </form>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
