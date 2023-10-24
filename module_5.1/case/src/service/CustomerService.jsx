import axios from "axios";
import alert from "bootstrap/js/src/alert.js";

export const getAll = async (name) => {
    try {
        const res = await axios.get(`http://localhost:8080/customer?name_like=${name}`);
        return res.data;
    } catch (e) {
        alert("Error");
    }
}
export const addCustomer = async (value) => {
    try {
        return await axios.post("http://localhost:8080/customer/", value);

    } catch (e) {
        alert("Error");
    }
}

export const getAllType =  async () => {
  try {
      const res = await  axios.get("http://localhost:8080/typeCustomer");
      return res.data
  }catch (e) {
      alert("Error")
  }
}
export const deleteCustomer = async (id) => {
  try {
      return await axios.delete("http://localhost:8080/customer/" + id)
  }catch (e) {
      alert("Error")
  }
}
