import './App.css'

import "react-toastify/dist/ReactToastify.css";
import {ToastContainer} from "react-toastify";
import {Route, Routes} from "react-router-dom";
import {HangHoa} from "./components/HangHoa.jsx";
import {ThemHangHoa} from "./components/ThemHangHoa.jsx";


function App() {

    return (
        <>
            <Routes>
               <Route path="/" element={<HangHoa/>}></Route>
                <Route path="/add" element={<ThemHangHoa/>}></Route>
            </Routes>
            <ToastContainer></ToastContainer>
        </>
    )
}

export default App
