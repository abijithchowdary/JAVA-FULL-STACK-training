// let array =[true, 42, "Hello", null, undefined, Symbol("sym"), 1234567890n];
// console.log(array);
// console.log(typeof array); 

// //Adding elements to an array
// array.push("Mango");
// console.log(array);
// array.unshift("Apple");
// console.log(array);

// //Removing elements from an array
// array.pop();
// console.log(array);
// array.shift();
// console.log(array);

fruits = ["Banana", "Orange", "Grapes", "Pineapple"];
console.log(fruits);

//splice(position, delete count, new values,.....) -> to add/remove elements at a specific position
fruits.splice(2, 1); //removing element at index 2
console.log(fruits);
fruits.splice(1, 0, "Strawberry"); //adding elements at index 1
console.log(fruits);
fruits.splice(3, 0, "Watermelon", "Kiwi"); //replacing element at index 3
console.log(fruits);

fruits.splice(0, 2, "Mango", "Papaya"); //replacing element at index
console.log(fruits);


let books = ["The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice"];
let authors = ["F. Scott Fitzgerald", "Harper Lee", "George Orwell", "Jane Austen"];
let library = books.concat(authors);
console.log(library);
console.log(library.length);

let colors = new Array("Red", "Green", "Blue");
console.log(colors);

let sports = Array.of("Football", "Basketball", "Tennis");
console.log(sports);

let obj ={
    math : 95,
    science : 97,
    english : 91
}

console.log(obj);

let obj1 = new Object({
    math : 95,
    science : 97,
    english : 91
});
console.log(obj1);

let obj2 = Object.create(obj);
console.log(obj2);
console.log(obj2.math);

obj["history"] = 89;
console.log(obj);

 

