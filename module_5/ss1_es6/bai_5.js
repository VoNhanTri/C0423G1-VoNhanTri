const person = {
    firstName: 'Tri',
    lastName: 'Võ',
    age: '29',
    gender: 'male',
    occupation: 'developer',
    nationality: 'Việt Nam',
    city: 'Đà Nẵng',
    hobbies:['reading','traveling','photography'],
    language: ['English','Vietnamese'],
    education: {
        degree: 'Bachelor',
        major: 'Computer Science',
        university: 'CodeGym'
    }
};

let {firstName,gender,education: {degree}, language:[lang,...rest]}=person;
let student={
    firstName,
    gender,
    degree,
    lang
}
console.log(student)
