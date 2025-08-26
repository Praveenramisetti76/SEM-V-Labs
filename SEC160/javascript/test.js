console.log("hello world")
//js is single threaded , a thread can only execute one command at a time
// sync funs ,run one by one, async funs , run in parallel
// setTimeout( function something() {
//     console.log("hello after 1 second")
// }, 1000);
console.log("make a toast")
setTimeout( function makeupma() {
    console.log("making upma , and its done")
}, 9000);
console.log("make a sandwich")

const num=1000000n
console.log(num + 1n) // BigInt example

// array of strings
const arr = ['apple', 'banana', 'cherry'];
console.log(arr[1]); // Accessing the second element of the array
//adding at the end
arr.push('date'); // Adding a new element to the array  
arr.pop()
// adding at the start -- using unshift
arr.unshift('date');
// for removing an elemen at start use shift
arr.shift();

const obj={
    name: 'John',
    age:20,
    skills:['JavaScript', 'React', 'Node.js'],
    fun: function fun() {
        console.log("Hello from the function!");
    },
    movies:{
        superhero: 'Avengers',
        action: 'Mad Max',
        comedy: 'Superbad'
    }

}
console.log(obj.name); // Accessing the name property of the object
console.log(obj.skills[1]); // Accessing the second skill in the skills array

// json --> js object but all the pairs are in strings format 
const json ={
    "name" : "John",
    "age":19,
    "skills": ["JavaScript", "React", "Node.js"]
}