import './App.css'
import {Route, Routes} from "react-router-dom";
import {Contract} from "./components/contract/Contract.jsx";
import {AddContract} from "./components/contract/AddContract.jsx";
import {ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import {AddCustomer} from "./components/customer/AddCustomer.jsx";
import Footer from "./components/Footer.jsx";
import {Header} from "./components/Header.jsx";
import {EditCustomer} from "./components/customer/EditCustomer.jsx";
import Customer from "./components/customer/Customer.jsx";
import {Facility} from "./components/facility/Facility.jsx";
import Home from "./components/Home.jsx";
export function App() {
    return (
        <>
            <Header/>
            <Routes>
                <Route path="/contract" element={<Contract/>}></Route>
                <Route path="/contract/add" element={<AddContract/>}></Route>
                <Route path="/customer" element={<Customer/>}></Route>
                <Route path="/customer/add" element={<AddCustomer/>}></Route>
                <Route path="/customer/edit/:id" element={<EditCustomer/>}></Route>
                <Route path="/facility" element={<Facility/>}></Route>
                <Route path="/home" element={<Home/>}></Route>
            </Routes>
            <ToastContainer></ToastContainer>
            <Footer/>
        </>
    )
}

