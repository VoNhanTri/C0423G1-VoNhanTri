import axios from "axios";

export const getAll = async () =>{
    try {
        const res = await axios.get("http://localhost:8080/contract");
        return res.data;
    }catch (e) {
        alert("Khong co du lieu");
    }
};
export const add = async (data) =>{
    try {
        return await axios.post("http://localhost:8080/contract/", data);
    }catch (e) {
        alert("ERROR")

    }
}