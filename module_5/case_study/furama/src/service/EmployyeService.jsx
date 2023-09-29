import axios from "axios";

// export const getAll = async () => {
//     try {
//         const res = await axios.get("http://localhost:8080/employee");
//         return res.data;
//     } catch (e) {
//         alert("Không tìm thấy dữ liệu");
//     }
//
// }
export const add = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/employee/", data)
        return res;
    } catch (e) {
        alert("Không Thêm Mới Được")
    }
}
export const getAllLocation = async () => {
    try {
        const res = await axios.get("http://localhost:8080/location");
        return res.data;
    } catch (e) {
        alert("Không tìm thấy dữ liệu")
    }
}
export const getSearch = async (name, locationSearch) => {
    try {
        if (locationSearch === '') {
            const URL = `http://localhost:8080/employee?name_like=${name}`;
            const res = await axios.get(URL);
            return res.data;
        }
        const URL = `http://localhost:8080/employee?name_like=${name}&location.id=${locationSearch}`
        const res = await axios.get(URL);
        return res.data;
    } catch (e) {
        alert("Tìm Không Thấy")
    }
}
export const remove = async (data) => {
    try {
        const res = await axios.delete("http://localhost:8080/employee/" + data)
        return res;
    } catch (e) {
        alert("Xoá Thất Bại")
    }
}
export const getById = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/employee/" + id)
        return res.data
    } catch (e) {
        alert("Không tìm thấy")
    }
}
export const edit = async (employee) => {
    try {
        const res = await axios.put("http://localhost:8080/employee/" + employee.id, employee);
        return res;
    } catch (e) {
        alert("Không tìm thấy")
    }
}