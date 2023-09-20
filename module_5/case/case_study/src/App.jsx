
import './App.css'
import {Header} from "./components/Header";
import Customer from "./customer/component/Customer.jsx";
import Service from "./service/component/Service.jsx";
import Contract from "./contract/conponent/Contract.jsx";
import AddCustomer from "./customer/component/AddCustomer.jsx";
import EditCustomer from "./customer/component/EditCustomer.jsx";
import AddContract from "./contract/conponent/AddContract.jsx";
import Footer from "./components/Footer.jsx";

function App() {

    return (
        <>
            <Header/>
            <Customer/>
            <Service/>
            <Contract/>
            <AddCustomer/>
            <EditCustomer/>
            <AddContract/>
            <Footer/>
        </>
    )
}

export default App
