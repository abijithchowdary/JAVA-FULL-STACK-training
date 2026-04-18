export function setupCounter(element: HTMLButtonElement) {
  let counter = 0
  const setCounter = (count: number) => {
    counter = count
    element.innerHTML = `Count is ${counter}`
  }
  element.addEventListener('click', () => setCounter(counter + 1))
  setCounter(0)
}

interface Laptop{
  id:number;
  brand: string;
  model: string;
  price: number;
}
export async function populateLaptops(tableElement: HTMLTableElement | null, apiUrl: string){
  const response = await fetch(apiUrl);
  const laptops: Laptop[] = await response.json();

  let tbody = tableElement?.querySelector('tbody');
  if(!tbody){
    tbody = document.createElement('tbody');
    tableElement?.appendChild(tbody);
  }

  tbody.innerHTML = ``;

  //adding cols
  laptops.forEach(laptop=>{
    const row = tbody.insertRow();
      row.insertCell(0).textContent = laptop.id.toString();
      row.insertCell(1).textContent = laptop.brand;
      row.insertCell(2).textContent = laptop.model;
      row.insertCell(3).textContent = `$${laptop.price}`;
  })
}