import axios from "axios";

export const getAll = async () => {
    try {
        const res = await axios.get("http://localhost:8080/book");
        return res.data;
    }catch (e) {
        alert("ERROR")
    }
}
export const add = async (data) =>{
    try {
        const res = await axios.post("http://localhost:8080/book/",data);
        return res;
    }catch (e) {
        alert("ERROR")

    }
}