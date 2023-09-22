import axios from "axios";

export const create = async (data) => {
  try {
      const res = await axios.post("http://localhost:8080/todos",data);
      return res;
  }catch (e){
      alert("ERROR")
  }
}

export const getAll = async () => {
    try {
        const res = await axios.get("http://localhost:8080/todos");
        return res.data;
    }catch (e){
        alert("Khong co du lieu")
    }

}