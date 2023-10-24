import './App.css'
import Footer from "./components/Footer.jsx";
import {Header} from "./components/Header.jsx";
import {Route, Routes} from "react-router-dom";
import Home from "./components/Home.jsx";
import {Facility} from "./components/facility/Facility.jsx";
import {AddFacility} from "./components/facility/AddFacility.jsx";
import {ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import {EditFacility} from "./components/facility/EditFacility.jsx";
import {Customer} from "./components/customer/Customer.jsx";
import {AddCustomer} from "./components/customer/AddCustomer.jsx";


function App() {

    return (
        <>
            <Header/>

            <Routes>
                <Route path="/" element={<Home/>} />
                <Route path="/facility" element={<Facility/>} />
                <Route path="/facility/add" element={<AddFacility/>} />
                <Route path="/facility/edit/:id" element={<EditFacility/>} />
                <Route path="/customer" element={<Customer/>} />
                <Route path="/customer/add" element={<AddCustomer/>} />
            </Routes>
                <ToastContainer></ToastContainer>
            <Footer/>


        </>
    )
}

export default App
