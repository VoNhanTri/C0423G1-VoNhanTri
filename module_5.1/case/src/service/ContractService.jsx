import axios from "axios";

export const getAll = async (page,numContract) => {
    try {
        const res = await axios.get(`http://localhost:8080/contract?numContract_like${numContract}&_page=${page}&_limit=5`);
        return res
    } catch (e) {
        alert("Error")
    }
};
export const getPage = async (page,limit) => {
    try {
        const res = await axios.get(`http://localhost:8080/contract?_page=${page}&_limit=${limit}`);
        return res.data;
    }catch (e) {
        alert("Error");
    }
}

export const addContract = async (value) => {
  try {
      return await axios.post("http://localhost:8080/contract/", value)
  }catch (e) {
      alert("Error");
  }
}