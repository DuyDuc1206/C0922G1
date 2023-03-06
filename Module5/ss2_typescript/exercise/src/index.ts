let fibonacci = (n: number): number => {
    if (n <= 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

let sumFibonacci = (n: number): number => {
    let sum = 0;
    for (let i = 0; i <= n; i++) {
        sum += fibonacci(i);
    }
    return sum;
}

console.log(sumFibonacci(5));
