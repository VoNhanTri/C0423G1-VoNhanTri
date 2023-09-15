let check = n => {
    if (n < 2) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}
let arr = [1, 2, 3, 4, 5];
let array = arr.filter((e) => check(e));
console.log(array);