const body = document.querySelector("body");

const IMG_NUMBER = 5;

function handleImgLoad(){
    console.log("finished loading");
}

function paintImage(imgNumber){
    const image = new Image();
    image.src = `images/${imgNumber}.jpg`;
    image.classList.add("bgImage");
    body.appendChild(image);
    // image.addEventListener("loadend",handleImgLoad) //api에서 사용한다면 필요 할 수 있음 (로딩이 된 이후 나타남)
}

function genRandom(){
    const number = Math.floor(Math.random() * IMG_NUMBER) + 1;
    console.log(number);
    return number;
}

function init(){
    //Math.floor : 소수점 숫자를 내림  Math.ceil : 소수점 숫자를 올림
    const randomNumber = genRandom();
    paintImage(randomNumber);
}

init();