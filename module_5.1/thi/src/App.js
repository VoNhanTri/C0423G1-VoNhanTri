import './App.css';
import "react-toastify/dist/ReactToastify.css"
import 'bootstrap/dist/css/bootstrap.css';
import {Route, Routes} from "react-router-dom";
import {ProductList} from "./components/ProductList";
import {ToastContainer} from "react-toastify";
import {ProductAdd} from "./components/ProductAdd";


function App() {
    return (
        <>
            <Routes>
                <Route path="/product" element={<ProductList/>}/>
                <Route path="/product/add" element={<ProductAdd/>}/>
            </Routes>
            <ToastContainer></ToastContainer>
        </>
    );
}

export default App;
