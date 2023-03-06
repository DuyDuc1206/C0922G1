var fibonacci = function (n) {
    if (n <= 1) {
        return n;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
};
var sumFibonacci = function (n) {
    var sum = 0;
    for (var i = 0; i <= n; i++) {
        sum += fibonacci(i);
    }
    return sum;
};
console.log(sumFibonacci(5));
