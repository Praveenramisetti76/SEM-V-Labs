// function evg()
// {
//     console.log("this is the evening");
// }

// function afternoon(evg) {  
//     console.log("it is not morning , it is evhening");
//     evg();
// }
// function greeting(name)   {  
//     console.log("Good Afternoon " +name);
//     afternoon(evg);
// }
// greeting("praveen", afternoon);


// console.log("start")
// function registeruser(name, callback)
// {
// setTimeout(() => {
//     console.log("user is registered with the name of "+name);
//     callback(name);
// }, 1000);
// }
// function sendmail(name,callback)
// {
//     setTimeout(() => {
//     console.log("send mail to the usesr with the name of "+name);
//     callback(name);
// }, 1000);
// }
// function otpvalidate(name, callback)
// {
//     setTimeout(() => {
//     console.log("otp is validated for the user with the name of "+name);
//     callback(name);
// }, 1000);
// }
// function savedpreference(name,callback)
// {
//     setTimeout(() => {
//     console.log("saved preference of the user with the name of "+name);
//     callback(name);
// }, 1000);
// }

// registeruser("praveen",function(name){
//     sendmail(name,function(name){
//         otpvalidate(name,function(name){
//             savedpreference(name,function(name){
//                 console.log("all done");
//             });
//         });
//     });
// })
// console.log("end")
// to overcome problem of callback hell promises were introduced

// const promise = new  Promise( function (resolve, reject){
//     let success=true;
//     if(success){
//         resolve("hurray i got the results")
//     }
//     else{
//         reject("i failed");
//     }
// });
// // when we have to show resolved data we use then()
// // wehn we have to show rejected data we use catch()
// promise.then(function(data){
//     console.log("on success ",data);
// }).catch(function (errorData) {
//     console.log("on failure ",errorData);
// }).finally(function () {
//     console.log("finally -> it prints wheather it is resolved or rejected");
// });

// modern way of writing promises is async await and try catch keywords
 url='https://pokeapi.co/api/v2/pokemon/ditto';

 // api gets the data from the server
async function pokemondata()
 {
   try{ const response = await fetch(url);  // fetch(url) is returning a promise
    console.log(response)
    const data = await response.json(); // parsing json
    console.log(data);}
    catch{
        console.log("error");
    }
 }
pokemondata();