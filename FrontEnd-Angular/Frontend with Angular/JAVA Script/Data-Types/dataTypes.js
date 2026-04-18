//Data Type - it decides what type of value will be stored in a variable.

//Primitive Data Types - String, Number, Boolean, Null, Undefined, Symbol, BigInt ; holds a single value. immutable in nature

//Non-primitive Data Types - Object, Array, Function, Classes ; can hold multiple values and more complex data structures.

let day01 = "Monday";
console.log(day01); 
day01 = "Tuesday";
console.log(day01);  

//String - sequence of characters internally stored as an array
let day02 = "Wednesday";
console.log(day02);
let day03 = 'Thursday';
console.log(day03);
let day04 = `Friday`; //string template
console.log(day04);

//String methods -> to perform operations on strings
let message = " I came, I saw, I conquered. ";
console.log(message.toUpperCase());
console.log(message.toLowerCase());
console.log(message.length);
console.log(message.trim().length);
console.log(message.includes("saw"));
console.log(message.slice(0, 5));
console.log(message.split(","));
console.log(`The length of the complete string is ${message.length}`);