import axios from "axios";

export const getAll = async () =>{
    try {
        const rs = await axios.get("http://localhost:8080/dichVu")
        return rs.data;
    }catch (e) {
        alert("khong tim thay du lieu")
    }

}