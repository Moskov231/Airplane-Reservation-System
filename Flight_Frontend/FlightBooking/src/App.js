import { BrowserRouter, Routes, Route } from "react-router-dom";
import Route1 from "./Routes/Route1";
import Route2 from "./Routes/Route2";
function App() {
  const Auth = localStorage.getItem("key");

  return (
    <>
      {Auth !== null && Auth !== undefined && Auth === "myLogin" ? (
        <Route1 />
      ) : (
        <Route2 />
      )}
    </>
  );
}

export default App;
