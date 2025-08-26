// types of functions
// normal functions
// anonymous functions
// arrow functions


function fun()
{
    return 'good morning';
}
console.log(fun());


// variable expression function
const x= function fun()
{
    return 'good morning';
};
console.log(x());

//anonymous functions
const anon=function (){
    return 'good morning';
}

//arrow functions
const arr =() => {
    return 'I am the arrow function';
};
console.log(arr());