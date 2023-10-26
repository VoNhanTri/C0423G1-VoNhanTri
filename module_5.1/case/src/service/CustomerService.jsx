import axios from "axios";

export const getAll = async (name, page) => {
    try {
        const res = await axios.get(`http://localhost:8080/customer?name_like=${name}&_page=${page}&_limit=5`);
        console.log(res)
        return res;
    } catch (e) {
        alert("Error");
    }
}

export const getPage = async (page,limit) => {
  try {
      const res = await axios.get(`http://localhost:8080/customer?_page=${page}&_limit=${limit}`);
      return res.data;
  }catch (e) {
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

export const getAllType = async () => {
    try {
        const res = await axios.get("http://localhost:8080/typeCustomer");
        return res.data
    } catch (e) {
        alert("Error");
    }
}
export const deleteCustomer = async (id) => {
    try {
        return await axios.delete("http://localhost:8080/customer/" + id);
    } catch (e) {
        alert("Error");
    }
}

export const getByIds = async (id) => {
    try {
        const res = await axios.get("http://localhost:8080/customer/" + id);
        return res.data;
    } catch (e) {
        alert("Error");
    }
}
export const edits = async (value) => {
    try {
        return await axios.put("http://localhost:8080/customer/" + value.id, value);
    }catch (e) {
        alert("Error");
    }
}
