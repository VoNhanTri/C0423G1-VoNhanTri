import axios from "axios";

export const getAll = async (numContract) => {
    try {
        const res = await axios.get(`http://localhost:8080/contract?numContract=${numContract}`);
        return res.data
    } catch (e) {
        alert("Error")
    }
}