let money = 1000;
const buyCar = (car: any) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (money >= 1000) {
                resolve("can buy" + car);
            } else {
                reject(" do not enough money");
            }
        }, 100);
    })
}
money = 1000001;
const promise = buyCar("Vinfast")
    .then((data) => {
        console.log(data);
    })
    .catch((err) => {
        console.log(err);
    })