let numbers = 30;
function fibonacci(n) {
    if (n <= 1) {
        return n;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
console.log(fibonacci(numbers));
function fibonacci2(num) {
    var a = 0, b = 1, sum = 0, temp;
    while (num >= 0) {
        temp = b;
        b = a + b;
        a = temp;
        num--;
    }
    return a;
}
console.log(fibonacci2(10));
//# sourceMappingURL=main.js.map