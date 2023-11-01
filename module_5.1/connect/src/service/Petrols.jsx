import axios from "axios";

export const createPetro = async (data) => {
  try {
      return await axios.post("http://localhost:8080/petrols/", data)
  }catch (e) {
      alert("Error")
  }
}
export const getAll = async () => {
  try {
      const res = await axios.get("http://localhost:8080/petrols/")
      return res.data
  }catch (e) {
      alert("Error")
  }
}