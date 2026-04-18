let prevBalls  = []
var wincount = 0;
function displayBallHistory(){
    var ul = document.getElementById("ballHistory");
    ul.innerHTML = 'Ball History';
    for(var ball of prevBalls){
        var li = document.createElement("li");
        li.textContent = ball;
        ul.appendChild(li);
    }
}

function showWinMsg(userHit,computerHit){
    var winStatus = document.getElementById('winStatus');
    if(userHit==computerHit){
        winStatus.innerHTML="OUT";
        wincount++;
    }
    else{
        winStatus.innerHTML = "NOT OUT";
    }
}
function startMatch(){
    var computerHit = document.getElementById('computerHit');
    let random = Math.floor(Math.random()*7);
    computerHit.textContent = random;

    var userInput = document.getElementById('userInput')
    if(userInput){
        var userInp = userInput.value;
    }
    else{
        console.log("No Input");
    }
    if(userInp>=0 && userInp<=6){
        document.getElementById('errorMSG').style.display = 'none';
        var userHit = document.getElementById('userHit')
        userHit.textContent = userInp;
        prevBalls.push(random);
        console.log("prev balls list",prevBalls);
        showWinMsg(userInp,random);
        displayBallHistory();
    }
    else{
        document.getElementById('errorMSG').style.display = 'block';
    }
    var winCnt = document.getElementById('winCnt');
    winCnt.innerHTML = 'Win Count: '+wincount;
}

function clearHISTORY(){
    prevBalls = []
    displayBallHistory()
}