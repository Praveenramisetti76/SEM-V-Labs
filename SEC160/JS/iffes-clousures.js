//TODO ) iife and closures
//* iifes - immediately invoked function expressions
// let x='praveen'
// let y= "hemmm"
// console.log(x+y);
// //es6 -> template literals
// console.log(`i am ${x} and i am ${y}`);

(function add(){
    let a=10;
    let b=20;
  console.log(`the sum of two numbers is ${a+b}`);
})();
// iifes are immediately invoked function expressions, -> they will be called only once and always , like a paper straw -> one time use

//* closures
// clousures give you access to an outer function's scope from an inner function
function outer()
{
    let privatevariable='secret key 🔑🔐'
    function inner()
    {
        console.log(`here is my password ${privatevariable}`);
    }
    return inner;
}
outer()(); // we are calling the outer function and then the inner function
let value = outer();
let final= value();
console.log(final);