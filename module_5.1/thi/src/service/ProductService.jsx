import axios from "axios";

export const getAll = async (name) => {
    try {
            const res = await axios.get(`http://localhost:8080/product?name_like=${name}`);
            return res.data;
    } catch (e) {
        alert("Error");
    }
}
export const getAllType = async () => {
    try {
        const res = await axios.get("http://localhost:8080/type");
        return res.data;
    } catch (e) {
        alert("Error");
    }
}

export const addProduct = async (data) => {
    try {
        return await axios.post("http://localhost:8080/product/", data);
    } catch (e) {
        alert("Error")
    }
}