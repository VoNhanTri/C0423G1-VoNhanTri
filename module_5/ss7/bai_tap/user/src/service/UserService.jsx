import axios from "axios";

export const getAll = async () =>{
    try {
        const res = await axios.get("http://localhost:8080/user");
        return res.data
    }catch (e) {
        alert("khong co du lieu");
    }
};