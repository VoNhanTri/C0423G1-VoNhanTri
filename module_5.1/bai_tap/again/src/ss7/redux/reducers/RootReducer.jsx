import {combineReducers} from "redux";
import {studentReduce} from "./StudentReduce.jsx";



export const rootReducer = combineReducers({
    students: studentReduce,
})