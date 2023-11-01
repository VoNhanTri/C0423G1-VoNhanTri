import axios from "axios";

export const getAll = async (name, type) => {
    try {
        if (type === '') {
            const res = await axios.get(`http://localhost:8080/goods?name_like=${name}`);
            return res.data;
        } else {
            const res = await axios.get(`http://localhost:8080/goods?name_like=${name}&type.id=${type}`);
            return res.data
        }

    } catch
        (e) {
        alert("Error")
    }
}

export const getAllType = async () => {
    try {
        const res = await axios.get("http://localhost:8080/type");
        return res.data;
    } catch (e) {
        alert("Error")
    }
}
export const addGoods = async (data) => {
    try {
        return await axios.post("http://localhost:8080/goods/", data);
    } catch (e) {
        alert("Error")
    }
}
export const remove = async (id) => {
    try {
        return await axios.delete("http://localhost:8080/goods/" + id);
    }catch (e) {
        alert("Error")
    }
}