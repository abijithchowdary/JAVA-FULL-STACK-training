let className = "my-class";
var count = 10;
const PI = 3.14;

console.log(className); // Output: my-class
console.log(count);
console.log(PI);

//var -> function scope
//let and const -> block scope

//console -> for developer -> console.log() -> print something in console   
//UI -> for user -> console.write() -> print something on webpage

//let and const introduced in ES6 (2015)

//difference between let and var
//1. Scope -> var is function scoped, let is block scoped
//2. Redeclaration -> var can be redeclared, let cannot be redeclared


let name = "John";
console.log(name); // Output: John
name = "Doe";
console.log(name); // Output: Doe

var name1 = "Alice";
console.log(name1);
var name1;
name1 = "Bob";
console.log(name1);
name1 = "Charlie";
console.log(name1); 