let day1="sunday"
// console.log(day1)
day1="monday"
// console.log(day1)


let day2="sunday"
// console.log(day2)
day2[2]='j' //doesnt change or modify the value
// console.log("immutable string", day2)
let day3='hunday'
// console.log(day3)
let day4=`gudday`
// console.log(day4)


let sen1="honesty is the best policy"
let sen2=sen1.toUpperCase()
console.log(sen1)
console.log(sen1.toUpperCase())

console.log(sen2)
console.log(sen2.toLowerCase())


console.log(sen1.length)
console.log("after trim:",sen1.trim())
console.log("lentgth after trim:",sen1.trim().length)

console.log(sen1.includes("is"))
console.log(sen2.includes("is"))

console.log(sen1.endsWith("cy"))
console.log(sen1.endsWith("policy"))

console.log(sen1.startsWith("honesty"))

console.log(`is it true ${sen1.includes("ist")}`)

let n1="hui"
let n2="jui"
console.log(n1+n2)
console.log(n1.concat(n2))


