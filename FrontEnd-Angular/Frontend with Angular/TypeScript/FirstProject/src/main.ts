import './style.css'
import typescriptLogo from './assets/typescript.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import { setupCounter, populateLaptops } from './counter.ts'
import type { User } from './users.ts'

document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
<section id="center">
  <div class="hero">
    <img src="${heroImg}" class="base" width="170" height="179">
    <img src="${typescriptLogo}" class="framework" alt="TypeScript logo"/>
    <img src=${viteLogo} class="vite" alt="Vite logo" />
  </div>
  <div>
    <h1>Get started</h1>
    <p>Edit <code>src/main.ts</code> and save to test <code>HMR</code></p>
  </div>
  <button id="counter" type="button" class="counter"></button>
</section>

<div class="ticks"></div>

<section id="next-steps">
  <div id="docs">
    <svg class="icon" role="presentation" aria-hidden="true"><use href="/icons.svg#documentation-icon"></use></svg>
    <h2>Documentation</h2>
    <p>Your questions, answered</p>
    <ul>
      <li>
        <a href="https://vite.dev/" target="_blank">
          <img class="logo" src=${viteLogo} alt="" />
          Explore Vite
        </a>
      </li>
      <li>
        <a href="https://www.typescriptlang.org" target="_blank">
          <img class="button-icon" src="${typescriptLogo}" alt="">
          Learn more
        </a>
      </li>
    </ul>
  </div>
  <div id="social">
    <svg class="icon" role="presentation" aria-hidden="true"><use href="/icons.svg#social-icon"></use></svg>
    <h2>Connect with us</h2>
    <p>Join the Vite community</p>
    <ul>
      <li><a href="https://github.com/vitejs/vite" target="_blank"><svg class="button-icon" role="presentation" aria-hidden="true"><use href="/icons.svg#github-icon"></use></svg>GitHub</a></li>
      <li><a href="https://chat.vite.dev/" target="_blank"><svg class="button-icon" role="presentation" aria-hidden="true"><use href="/icons.svg#discord-icon"></use></svg>Discord</a></li>
      <li><a href="https://x.com/vite_js" target="_blank"><svg class="button-icon" role="presentation" aria-hidden="true"><use href="/icons.svg#x-icon"></use></svg>X.com</a></li>
      <li><a href="https://bsky.app/profile/vite.dev" target="_blank"><svg class="button-icon" role="presentation" aria-hidden="true"><use href="/icons.svg#bluesky-icon"></use></svg>Bluesky</a></li>
    </ul>
  </div>
  <table id='laptops'>
    <th>id</th>
    <th>brand</th>
    <th>model</th>
    <th>price</th>
  </table>
</section>

<div class="ticks"></div>
<section id="spacer"></section>
`

setupCounter(document.querySelector<HTMLButtonElement>('#counter')!)
populateLaptops(document.querySelector<HTMLTableElement>('#laptops'),'http://localhost:3434/laptops')

function utitllityMethod(str:String){
  console.log(`string given is  ${str}`);
}

var nameStudent = 'Ashish';
utitllityMethod(nameStudent);

function getData() : Promise<User> | String {
  //if data is ready from local storage return it

  //else get the data from server and , then return promise
  var data = localStorage.getItem('mydata');
  if(data) return data;
  return fetch('http://localhost:3434/laptops/1').then((response)=>response.json());
}

function showData(){
  var data = getData();
  // narrowing down
  if(typeof(data)== 'string'){
    console.log(`from lcoal storage data ${data}`);
  }
  //else other wise data is promise
  if(data instanceof Promise){
    console.log(typeof(data));
    data.then((jsonObj)=>console.log('from server',jsonObj));
  }
}
showData();

//2
function getAllData(): Promise<laptop[]>{
  let promise = fetch("https://localhost:3434/laptops")
  return promise.then((res)=>resp.json());
}