console.log("Running file...");
const a = 3.14;
let value = 10;
let value1 = 0.5;

console.log(typeof a);
console.log(typeof value);
console.log(typeof value1);

let value2 = +"true";
console.log(typeof value2);
console.log(value2);

let bigNumber = 1234567890n;
console.log(typeof bigNumber);

//unable to define the data of an uninitialized variable
let uninitialized;
console.log(typeof uninitialized);

let obj = null;
console.log(typeof obj); 

//Symbol - unique and immutable primitive value, often used as keys in objects to avoid name collisions

let first = Symbol("Anushka");
let second = Symbol("Anushka");

console.log(first === second); 

