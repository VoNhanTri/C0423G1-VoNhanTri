import './App.css'
import Footer from "./components/Footer.jsx";
import {Header} from "./components/Header.jsx";
import {Route, Routes} from "react-router-dom";
import Home from "./components/Home.jsx";
import {Facility} from "./components/facility/Facility.jsx";
import {AddFacility} from "./components/facility/AddFacility.jsx";

function App() {

    return (
        <>
            <Header/>

            <Routes>
                <Route path="/" element={<Home/>} />
                <Route path="/facility" element={<Facility/>} />
                <Route path="/facility/add" element={<AddFacility/>} />
            </Routes>


            <Footer/>


        </>
    )
}

export default App
