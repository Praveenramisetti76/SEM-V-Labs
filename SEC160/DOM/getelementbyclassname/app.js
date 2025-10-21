//query selector -> selects any single tag/class/id
//query selector all -> selects all tags/class/id
const result = document.querySelector('#result');
result.style.backgroundColor='blue';
const item= document.querySelector('.special');
const lastitem=document.querySelector('li:last-child');

const list=document.querySelectorAll('.special');
list.forEach(function(item)
{
    //console.log(item);
    item.style.color='red';
})