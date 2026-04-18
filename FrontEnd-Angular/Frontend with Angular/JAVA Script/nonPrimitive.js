//highorder function and callback function
//create a calculator that recevies multiple values and perform addition, substraction, multiplication, division, modulus 
function calc(v1, v2, callbackfun){
    return callbackfun(v1, v2)
}

let add=calc(100, 200, (a, b)=>a+b)
console.log("addition of two numbers:",add)

let sub=calc(100, 200, (a, b)=>a-b)
console.log("subtraction of two numbers:",sub)

let mul=calc(100, 200, (a, b)=>a*b)
console.log("nultiplication of two numbers:",mul)

let div=calc(100, 200, (a, b)=>a/b)
console.log("Division of two numbers:",div)

let mod=calc(100, 200, (a, b)=>a%b)
console.log("modulus of two numbers:",mod)


//method 2

function calculator(val1,val2,callbackFunction){
    return callbackFunction(val1,val2);
}

function all2Gether(val1,val2,callbackFunction){
    var sum1 = callbackFunction(val1,val2,(val1,val2)=>val1+val2);
    var diff1 = callbackFunction(val1,val2,(val1,val2)=>val1-val2);
    var mul1 = callbackFunction(val1,val2,(val1,val2)=>val1*val2);
    var div1 = callbackFunction(val1,val2,(val1,val2)=>val1/val2);
    var mod1 = callbackFunction(val1,val2,(val1,val2)=>val1%val2);

    console.log(sum1,diff1,mul1,div1,mod1);
}
all2Gether(10,20,calculator)