var money = 1000;
var buyCar = function (car) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            if (money >= 1000) {
                resolve("can buy " + car);
            }
            else {
                reject(" do not enough money");
            }
        }, 100);
    });
};
money = 10000;
var promise = buyCar("Vinfast")
    .then(function (data) {
    console.log(data);
})["catch"](function (err) {
    console.log(err);
});
