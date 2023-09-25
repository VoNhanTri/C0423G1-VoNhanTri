import {GET_ALL_STUDENT} from "../Types.jsx";

export const userReducer = (users = [], action) => {
    const {type, payload} = action;
    switch (type) {
        case GET_ALL_STUDENT: {
            return payload
        }
        default: {
            return users;
        }
    }
}