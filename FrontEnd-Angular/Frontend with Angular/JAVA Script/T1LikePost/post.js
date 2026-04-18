
let likeCnt = 0;
let dislikeCnt = 0;
let btn1Inc = document.getElementById("btn1");
let btn2Dec = document.getElementById("btn2");

function incLike(){
    ++likeCnt;
    console.log("Count of like ",likeCnt);
    btn1Inc.innerText = "❤️ "+likeCnt;
}
function decLike(){
    dislikeCnt++;
    console.log("Count of dislike ",dislikeCnt);
    btn2Dec.innerText = "👎 "+dislikeCnt;
}
btn1Inc.addEventListener("click",incLike);
// btn2Dec.addEventListener("click",()=>dislikeCnt);