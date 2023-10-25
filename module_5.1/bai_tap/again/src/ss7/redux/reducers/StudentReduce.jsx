import {GET_ALL} from "../ActionType.jsx";

export const studentReduce =  (students = [], action) => {
  const {type, payload} = action;
  switch (type){
      case GET_ALL:
          return payload;
      default:
          return students;
  }
}
