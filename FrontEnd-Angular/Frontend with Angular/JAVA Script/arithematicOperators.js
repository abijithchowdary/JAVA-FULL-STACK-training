//Binary operators
//arithematic operators

//+  addition as well as concatenation
let result=20+45+34
// console.log(result)
let re2="hui"+"jui"
// console.log(re2)
let r1="abc"+34
// console.log(r1)
let r2=34+"abc"
// console.log(r2)

//-     Subtraction
let r3=34+56-65
// console.log(r3)
let r4="hyy"-"rey"
// console.log(r4)  //NaN

//*     Multiplication
let arr1=[10, 20, 30, "kui"]
let arr2=[13, 14, 15, "gulu"]
let r5=arr1[0]*arr2[1]
// console.log(r5)
let r6=arr1[3]*arr2[3]
// console.log(r6)
let r7=arr1[3]*arr1[0]
// console.log(r7)

function division(v1, v2){
    return v1/v2
}

let r9=division(10,2)
let r8=division("hy", 2)
// console.log(r9)
// console.log(r8)

let r10=false+false
// console.log(r10)
let r11=true+true
// console.log(r11)
r11=true+false
// console.log(r11)

let r12=32525n-23423n
// console.log(r12)
r12=32523n*234234n
// console.log(r12)

let marks={
    mat:10,
    sci:40,
    eng:45
}
let a1=(marks.mat+marks.sci+marks.eng)/3
console.log(a1)


console.log(Math.floor(a1))
console.log(Math.ceil(a1))
console.log(Math.round(a1))


