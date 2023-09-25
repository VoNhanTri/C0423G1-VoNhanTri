
import './App.css'
import {Route, Routes} from "react-router-dom";
import {UserList} from "./components/UserList.jsx";

function App() {

  return (
    <>
      <Routes>
        <Route path="/user" element={<UserList/>}>
        </Route>
      </Routes>
    </>
  )
}

export default App
