import axios from "axios";

export const getAllStudent = async () => {
    try {
        const res = await axios.get("http://localhost:8080/students");
        return res.data;
    } catch (e) {
        alert("Error")
    }
}
export const addStudent = async (value) => {
    try {
        return await axios.post("http://localhost:8080/students/", value)
    } catch (e) {
        alert("Error")
    }
}