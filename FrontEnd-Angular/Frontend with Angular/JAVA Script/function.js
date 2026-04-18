
function greet(){
    console.log("hello")
}

// greet()

function addition(v1, v2, v3, v4){
    console.log(v1+v2+v3+v4)
}
// addition(10,20,30,40)
// addition("hy","ki","ki","lu")

function kui(){
    console.log(arguments)
}
// kui("hi", "helo", "goddi", "puski", "kanda")

function gku(){
    console.log("hello")        //return type undefined
}
let result=gku()
// console.log(`result from gku is ${result}`)
function hu(){
    return "gu" //return type string
}

// //funtion expression with named function
let funExp=function grr(){
    return 6.7
}
// console.log(typeof funExp)

// //function expression with anonymous function
const fun=function(){
    console.log("tofay is thursday")
}
// fun()

// //function expression with arrow function
const arrowfun= ()=>45+"this is the count"
// console.log(arrowfun)
// console.log(arrowfun())

const arfun=()=>45 + +"45"
// console.log(arfun())

const ar= ()=>"45"+45
// console.log(ar())

const r= ()=>45+'45'
// console.log(ar())

const f=(v1, v2)=>{
    console.log(v1)
    console.log(v2)
    return v1+v2
}
let resul=f(10, 20)
// console.log(resul)

// //highorder function and callback function
function calc(v1, v2, callbackfun){
    return callbackfun(v1, v2)
}

let add=calc(100, 200, (a, b)=>a+b)
// console.log("addition of two numbers:",add)

let sub=calc(100, 200, (a, b)=>a-b)
// console.log("subtraction of two numbers:",sub)

let mul=calc(100, 200, (a, b)=>a*b)
// console.log("nultiplication of two numbers:",mul)

let div=calc(100, 200, (a, b)=>a/b)
// console.log("Division of two numbers:",div)

let mod=calc(100, 200, (a, b)=>a%b)
// console.log("modulus of two numbers:",sub)



let arr=[10, 20 ,100, 102, 23, 34, 234, 43]
let rui=arr.sort((a,b)=>a-b)//asscending order
let arr1=[10, 20 ,100, 102, 23, 34, 234, 43]
let iur=arr1.sort((a,b)=>b-a)//descending order
// console.log(rui)
// console.log(iur)


//recursive funciton
function sumofDigits(n){
    if(n==0){
        return 0
    }
    return n+sumofDigits(n-1)
    
}
console.log(sumofDigits(5))

//factorial of a number
function fact(n){
    if(n==1){
        return 1
    }
    return n*fact(n-1)
}
console.log("factorial of a number: ",fact(5))