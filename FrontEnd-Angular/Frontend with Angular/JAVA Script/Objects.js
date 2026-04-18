//onjects
let obj={
    mat:34,
    sci:56,
    eng:67,
    soc:90,
    hin:78,
    com:67
}
console.log(obj)

let obj1=Object({
    mat:34,
    sci:56,
    eng:67,
    soc:90,
    hin:78,
    com:67
})
console.log(obj1)

console.log(obj1.mat)
console.log(obj1.sci)
console.log(obj1.soc)

//add values
console.log("added value into oject")
obj1.pet=10
console.log(obj1)

//delete values
console.log("deleted value from object")
delete obj1.hin
console.log(obj1)

//update any values from object
console.log("updated")
obj1.pet=70
console.log(obj1)

//object methods
let listOfKeysOfMarks=Object.keys(obj1)
console.log(listOfKeysOfMarks)

let listOfValuesOfMarks=Object.values(obj1)
console.log(listOfValuesOfMarks)