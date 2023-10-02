import axios from "axios";

export const getAll = async (tenHangHoa,loai) => {
    try {
        if (loai === ""){
            const res = await axios.get(`http://localhost:8080/hanghoa?tenHangHoa_like=${tenHangHoa}`);
            return res.data
        }else {
            const res = await axios.get(`http://localhost:8080/hanghoa?tenHangHoa_like=${tenHangHoa}&loai.id=${loai}`);
            return res.data
        }

    } catch (e) {
        alert("Lỗi")
    }
}

export const getAllLoai = async () => {
    try {
        const res = await axios.get("http://localhost:8080/loai")
        return res.data
    } catch (e) {
        alert("Lỗi")
    }
}
export const themMoi = async (data) => {
    try {
        const res = await axios.post("http://localhost:8080/hanghoa/", data);
        return res;
    } catch (e) {
        alert("Lỗi")
    }
}
export const xoa = async (data) =>{
    try {
        const res = await axios.delete("http://localhost:8080/hanghoa/"+data)
        return res;
    }catch (e) {
        alert("Lỗi")
    }
}