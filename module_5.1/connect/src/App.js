import './App.css';
import {Route, Routes} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import {Petro} from "./components/Petro";
import {PetroAdd} from "./components/PetroAdd";
import "react-toastify/dist/ReactToastify.css";

function App() {
    return (
        <>
            <Routes>
                <Route path="/petrols/" element={<Petro/>}></Route>
                <Route path="/petrols/add" element={<PetroAdd/>}></Route>
            </Routes>
        <ToastContainer></ToastContainer>
        </>
    );
}

export default App;
