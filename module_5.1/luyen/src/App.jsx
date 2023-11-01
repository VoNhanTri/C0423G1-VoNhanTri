
import './App.css'
import {Route, Routes} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css"
import {GoodsList} from "./controller/GoodsList.jsx";
import 'bootstrap/dist/css/bootstrap.css';
import {AddGoods} from "./controller/AddGoods.jsx";
function App() {

  return (
    <>
     <Routes>
       <Route path="/goods" element={<GoodsList/>}></Route>
       <Route path="/goods/add" element={<AddGoods/>}></Route>
     </Routes>
      <ToastContainer></ToastContainer>
    </>
  )
}

export default App
