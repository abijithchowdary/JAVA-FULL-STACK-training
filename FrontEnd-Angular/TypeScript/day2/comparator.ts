interface user{id : number, name : string};
interface comparator<T>{
    compare(obj1 : T, obj2 : T) : number;
}

function sort<T>(arr : T[], com : comparator<T>){
    let n = arr.length;
    for(let i = n-1; i > n-1; i--){
        for(let j = 0; j < i; j++){
            if(com.compare(arr[j], arr[j+1]) > 0){
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
var ar : user[] = [{id : 301,name : "Abijith"},{id : 101,name : "Ashish"},{id : 201,name :"Ashish"}];

var comp : comparator<user> = {compare : (obj1, obj2) => obj1.id - obj2.id};
var sortedUsers = sort(ar, comp);
console.log(sortedUsers);