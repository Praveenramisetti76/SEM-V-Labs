const fruits=['manogo','apple','banana','grapes'];
const firstfruit=fruits[0];
const secondfruit=fruits[1];
// const [X]=fruits;
// console.log(X);
const [X,Y,Z]=fruits;
console.log(Y);
//destructiing , js remerber the position of the array
//in objects 
const person={
    fName:'john',
    age:28,
    role:'seniour developer',
    skills:{
        frontend:"react js",
        backend:{
            api: 'Postman',
            server:'node js'
        },
    },
}
const {fName,age,
    skills:{backend:{server}}
}=person;
const {frontend}=person.skills;
console.log(frontend);
console.log(server);
console.log(fName);
console.log(person.fName)

//destructing in function parameter
function something({age})
{
    return age;
}
// function something({age}=obj)
// {
//     return age;
// }
console.log(something(person));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//spread operator- > it means unpacking / spreading an iterable item(array) into individual items
//*syntax: ...variableName
const youtuber ='striver';
const alphabets=[...youtuber];
console.log(alphabets);
const boys=["dharma","praveen","madhav"];
const girls=["suma","anusha","nithya"];
const fsdclass2=[boys,girls];
console.log(fsdclass2);
const actor='tom cruise';
const fsdclass=[...boys, actor,...girls];
console.log(fsdclass);

const dog={
    name: "bud",
    img:' 🐶',
    age: 40,
};
const owner={
    ownername:"praveen",
    age2:20,
    ...dog,
}
console.log(owner);
console.log(dog);

//* rest operator -> it means packing individual items into an array(●'◡'●)╰(*°▽°*)╯
const fruits2=['mango','apple','banana','grapes','orange','kiwi'];
const [one ,...restoffruits]=fruits2;
console.log(one);
console.log(restoffruits);