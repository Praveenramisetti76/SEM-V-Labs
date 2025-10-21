const headings = document.getElementsByTagName("h2");
// console.log(headings);
headings[0].style.color='red';
headings[1].style.color='blue';

const items =document.getElementsByTagName('li');
// console.log(items);
items[5].style.color='orange';

// for(let i=0;i<items.length;i++){
// console.log(items[i]);
// }

const betteritems= [...items];
betteritems.forEach(function (item)
{
    console.log(item);
});