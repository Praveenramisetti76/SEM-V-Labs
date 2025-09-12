const people =[
    {
        name :"praveen",
        age:"20",
        profilepic:"https:.....",
        role:"tech lead",
    },
    {
        name:"dharma",
        age:"10",
        profilepic:"https:...",
        role:"ui ux design",
    }
]
//* for each does not return any value
// const itcompany=people.forEach(function (x)
// {
//     console.log(x.age);
    
// })
// const maping=people.map( function (x){
//     console.log(x.age)
//     console .log(x.profilepic)
// })
// const itcomp=people.map((x)=>{
//     return 
// })
// const findage=people.find((person) =>{
//     return people.age <=35;
// })

// const filterage=people.filter((person) =>{
//     return people.age<=35
// })
// console.log(filterage);

// console.log(findage)
// const filtering=people.filter(function(x){
//     return
// })

// syntax
//syntax -> reduce ((previousvalue,currentvalue) => {},initial value)
const arr=[1,2,3,4]
const red=arr.reduce((prev,curr)=>{
    console.log(prev,curr);
    return prev+curr;
},0);
console.log(red);

// es6  features of js 
/*
1 let and const -
2.=== type checking (strictly equal)
3.destructuring
4. rest operator and spread operator
*/