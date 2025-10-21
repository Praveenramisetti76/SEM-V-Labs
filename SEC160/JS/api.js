const url='https://pokeapi.co/api/v2/pokemon?limit=10';
async function fetchData(){
    try{
        const response=await fetch(url);
        //console.log(response);
        const data=await response.json();
      //  console.log(data);
        // const ans=data.results.forEach(pokemon =>console.log(pokemon.name));
        // console.log(ans);
         const ans2=data.results.map(pokemon =>pokemon.name);
         console.log(ans2);
    }
    catch(error){
        console.error('Error fetching data:',error);
    }
}
fetchData();
