import axios from "axios";

export const getAllFacility = async () => {
    try {
        const res = await axios.get("http://localhost:8080/facility");
        return res.data;
    } catch (e) {
        alert("Error")
    }
}

export const getAllService = async () => {
    try {

        const res = await axios.get("http://localhost:8080/serviceName");
        return res.data

    } catch (e) {
        alert("Error")
    }
}

export const addFacility = async (data) => {
    try {
        return await axios.post("http://localhost:8080/facility", data)
    } catch (e) {
        alert("Error")
    }
}