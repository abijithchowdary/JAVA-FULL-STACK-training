let check= (isSirPresent, isStudentPresent)=>{
    if(isSirPresent && isStudentPresent)
        console.log("classes could happen")
    else{
        console.log("classes wont happen, go eat biryani")
    }
}
check(true, false)
check(true, true)
check(false, true)
check(false, false)

let joinCom=(isSelCap, isSelAcc)=>{
    return isSelAcc || isSelCap
}
let r=joinCom(true, true)

if(r){
    console.log("you are employed and earning salary")
}
else{
    console.log("go for tcs")
}

let takeMock=true
console.log("lets take mock: ", !takeMock)
console.log("my power for taking mock: ",!!takeMock)