function add(a,b){
    return a + b;
}
var s = add(4,5);
console.log(s);

// async add(a,b){
//     return a + b; 
// }

// Async means it will execute in the function space in background in js
// once the system has time to run it will put in event loop

// 1.fetch means get the data from internet
// ofc it will take time to take data from intenet

var pre = fetch("https://jsonplaceholder.typicode.com/todos/1")
console.log(pre)

//.then 
// pre.then(function(data){console.log(data)});

// .json() also return a promise it means its async
// it will show promise pending
// pre.then(function(data){ console.log(data.json())});

// pre.then(function(data){
//     data.json().then(data=>console.log(data));
// });

// 2.
// await means this function will take some time to execute
async function showData(){
    var response = await fetch("https://jsonplaceholder.typicode.com/todos/1");
    var jsondata = await response.json();
    console.log(jsondata);
}
showData();

// if function is asyncit will return a promise , not the data

// 3. promise it is an class which says gimme two functions as arguments
// popularly one is resolve , reject
// new Promise(resolve,reject)

async function add2(a,b) {
    return (a+b);
}
console.log("add2 Promise function -> ", add2(4,5));
console.log("add2 Promise function -> ", await add2(4,5));

async function add3(a,b) {
    
    return new Promise((resolve,reject)=>{    
            if( typeof a != 'number' || typeof b !='number' ){
                    reject('did not possible');
                }
            else{
                var c = a + b;
                resolve("resolved "+c);
            }
        }
    )
}
add3(2,9).then(res=>console.log("sum is ",res));
add3("abc",{}).then(res=>console.log("sum is ",res)).catch(error=>console.log(error));