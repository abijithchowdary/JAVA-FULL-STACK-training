import './style.css'
import typescriptLogo from './assets/typescript.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import { setupCounter,setdownCounter } from './counter.ts'


document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
<section id="center">
  <div class="hero">
    <img src="${heroImg}" class="base" width="170" height="179">
    <img src="${typescriptLogo}" class="framework" alt="TypeScript logo"/>
    <img src=${viteLogo} class="vite" alt="Vite logo" />
  </div>
  <div>
    <h1>Get startedfuck </h1>
    <p>Edit <code>src/main.ts</code> use condom <code>HMR</code></p>
  </div>
  <button id="counter" type="button" class="counter"></button>
  <button id="downcounter" type="button" class="counter"></button>
</section>

<div class="ticks"></div>

<section id="next-steps">
  <div id="docs">
    <svg class="icon" role="presentation" aria-hidden="true"><use href="/icons.svg#documentation-icon"></use></svg>
    <h2>Chicks</h2>
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
  
</section>

<div class="ticks"></div>
<section id="spacer"></section>
`

setupCounter(document.querySelector<HTMLButtonElement>('#counter')!)
setdownCounter(document.querySelector<HTMLButtonElement>('#downcounter')!)


async function getData():Promise<any> {
 var promise = await fetch('http://localhost:3434/laptops')
 var json = await promise.json();
  return json;
}
var ret=  await getData();
console.log("return value is ",ret[0]);
console.log("return type is ",typeof ret);
  var ans = "";
async function getData2():Promise<any>{
  var promise =  await fetch('http://localhost:3434/billa')

  var abc = await promise.json();
  console.log("ans value is ",abc);
  return abc.toString();
}
console.log("return value is ",getData2());
