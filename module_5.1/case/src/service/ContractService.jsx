import axios from "axios";

export const getAll = async (numContract) => {
    try {
        const res = await axios.get(`http://localhost:8080/contract?numContract_like${numContract}`);
        return res.data
    } catch (e) {
        alert("Error")
    }
};

export const addContract = async (value) => {
  try {
      return await axios.post("http://localhost:8080/contract/", value)
  }catch (e) {
      alert("Error");
  }
}