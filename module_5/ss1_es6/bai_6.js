const getInfo=({firstName='quân',degree='NA',gender,english})=>{
    console.log(firstName)
    console.log(degree)
    console.log(gender)
    console.log(english)
}
const sv1 = {
    firstName: 'Trí',
    gender: "Male",
    degree: 'Bachelor',
    english: 'English'
}
const sv2 = {
    english: 'English',
    gender: "Male"
}
getInfo(sv1)
getInfo(sv2)
