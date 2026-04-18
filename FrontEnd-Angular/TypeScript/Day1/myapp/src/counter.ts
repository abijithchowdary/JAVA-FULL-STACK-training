export function setupCounter(element: HTMLButtonElement) {
  let counter = 0
  const setCounter = (count: number) => {
    counter = count
    element.innerHTML = `Count is ${counter}`
  }
  element.addEventListener('click', () => setCounter(counter + 1))
  setCounter(0)
}

export function setdownCounter(ele: HTMLButtonElement) {
  let counter = 0
  const setCounter = (count: number) => {
    counter = count
    ele.innerHTML = `Count is ${counter}`
  }
  ele.addEventListener('click', () => setCounter(counter - 1))
  setCounter(0)
}