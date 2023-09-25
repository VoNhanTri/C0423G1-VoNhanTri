import {getAll} from "../../service/UserService.jsx";
import {GET_ALL_STUDENT} from "../Types.jsx";

export const getAllUser = () => async (dispatch)=>{
    const res = await getAll()
    dispatch({
        type: GET_ALL_STUDENT,
        payload: res
    })
}