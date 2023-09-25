import {combineReducers} from "redux";
import {userReducer} from "./UserReducer.jsx";
export const rootReducer = combineReducers({
    users: userReducer
})