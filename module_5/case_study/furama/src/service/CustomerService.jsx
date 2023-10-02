import axios from "axios"
export const getAll = async () =>{
    try {
        const res = await axios.get(`http://localhost:8080/customer`)
        console.log(res)
        return res.data;
    }catch (e) {
        alert("Không tìm thấy dữ liệu")

    }
}
// export const getAll = async () =>{
//     try {
//         const res = await axios.get(`http://localhost:8080/api/customer/list`);
//         return res.data;
//     }catch (e) {
//         alert("Không tìm thấy dữ liệu")
//
//     }
// }
export const getPage = async (page) =>{
    try {
        const res = await axios.get(`http://localhost:8080/customer?_page=${page}&_limit=2`)
        return res.data;
    }catch (e) {
        alert("không tìm thấy dữ liệu")
    }
}
export const add = async (data) => {
    try {
        return  await axios.post("http://localhost:8080/customer/",data)
    }catch (e){
        alert("Không thêm mới dữ liệu")
    }
}
export const remove = async (id) =>{
    try {
       const res = await  axios.delete("http://localhost:8080/customer/"+id)
        return res;
    }catch (e){
        alert("Không tìm thấy dữ liệu")
    }
}
export const getById = async (id) =>{
    try {
        const res = await axios.get("http://localhost:8080/customer/"+id);
        return res.data;
    }catch (e){
        alert("Không tìm thấy dữ liệu")
    }
}
export const edit = async (customer) =>{
    try {
        const res = await axios.put("http://localhost:8080/customer/"+customer.id,customer);
        return res;
    }catch (e) {
        alert("Không tìm thấy dữ liệu")
    }
}
export const getAllCustomerType = async () => {
    try{
        const result = await axios.get("http://localhost:8080/type");
        return result.data;
    }catch(e){
        alert("Không tìm thấy dữ liệu")
    }
}
export const getByName = async (hoTen) =>{
    try {
        const res = await axios.get(`http://localhost:8080/customer?hoTen_like=${hoTen}`)
        return res.data;
    }catch (e) {
        alert("Không tìm thấy dữ liệu")
    }
}