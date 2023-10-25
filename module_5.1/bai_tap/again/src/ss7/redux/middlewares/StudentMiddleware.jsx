import {addStudent, getAllStudent} from "../../service/StudentSetvice.jsx";
import {CREATE, GET_ALL} from "../ActionType.jsx";

export const getAll = () => async (dispatch) => {
    const data = await getAllStudent();
    dispatch({
        type: GET_ALL,
        payload: data
    })
}
export const add = (value) => async (dispatch) => {
    const res = await addStudent(value);
    if (res.status === 200) {
        dispatch({
            action: CREATE,
            payload: value
        })
    }
}