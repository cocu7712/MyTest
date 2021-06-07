/*
String
const what = "String";
*/

/*
Boolean
const wat = true;
*/

/*
Number
const wat = 666;
*/

/*
Float
const wat = 55.1;
console.log(wat);
*/

/*
변수를 5개 생성하여 월~금 데이터를 넣고 출력
const monday = "Mon";
const tue = "Tue";
const wed = "Wed";
const thu = "Thu";
const fri = "Fri";

console.log(monday,tue,wed,thu,fri);
*/

/*
배열에 데이터 넣고 출력
const dayOfWeek = ["Mon","Tue", "Wed", "Thu","Fri","Set","Sun"];
console.log(dayOfWeek[1]);
*/

/*
각각 다른 데이터를 배열에 넣음
const dongmin = ["DongMin",28, true,"Seoul"];
console.log(dongmin);
*/

/*
Object 사용법
const dongmin = {
    name:"dongmin",
    age:33,
    gender:"Male",
    isHandosme:true,
    favMovies: ['Along the gods','LOTR','Oldboy'],
    fabFood:[{
        name:"Kimchi",fatty:false},{
        name:"Cheese burger", fatty:true}]
}
console.log(dongmin.gender);
console.log(dongmin.fabFood.name);

dongmin.gender = "Female";

console.log(dongmin.gender);
*/

/*
console 함수의 종류
const dongmin = {
    name:"dongmin",
    age:33,
    gender:"Male",
    isHandosme:true
}
console.log(dongmin,console);
*/

/*
함수 만들기 & 아귀먼트 데이터 넣기 (필드)
function sayHello(potato,age){
     console.log("Hello!",potato,"age :",age);
}

sayHello("dongMin",15);
console.log('Hi');
*/

/*
함수를 사용하여 아귀먼트 값을 주고 리턴값을 받아오기
function sayHello(name, age){
  return  `Hello ${name} you are ${age} years old`;
}

const greetDongmin = sayHello("DongMin", 15);
console.log(greetDongmin);
*/

/*
변수안에 function 만들어 사용하기
const calculator = {
    plus: function(a,b){
        return a + b;
    },
    minus: function(a,b){
        return a - b;
    },
    x: function(a,b){
        return a * b;
    },
    dis: function(a,b){
        return a / b;
    }
}

//console.log(greetNicolas)
const plus = calculator.plus(5,5);
const minus = calculator.minus(5,5);
const x = calculator.multi(5,5);
const dis = calculator.div(5,5);


console.log(plus);
console.log(minus);
console.log(multi);
console.log(div);
*/

// 2021-05-10


/*
document 사용법 연습
const title = document.getElementById('title');
const title = document.querySelector('#title');
console.log(title);

//DOM (Document Object Module)
title.innerHTML = "Hi! From JS";    //ID가 title인 객체의 나타내는 값을 변경
title.style.color = "red";          //ID가 title인 객체 스타일 변경
document.title = 'I own you now';   //title 이름 변경
*/

/*
사이즈 변경시 이벤트 
function handleResize(event){
    console.log(event);
    console.log("I have been resized");
}

window.addEventListener('resize',handleResize);
*/

/*
클릭 이벤트
const title =  document.querySelector('#title');

function handleClick(){
    title.style.color = "red";
}

title.addEventListener('click',handleClick);
*/

/*
if문 연습
if(true){   //데이터 타입과 벨류가 같아야함
    console.log("hi");
}else{
    console.log("ho");
}

const lalala = 123;
if(lalala == '123'){
    console.log('lala')
}
*/

/*
prompt는 사용하지 않는 오래된 코드
(입력 받는 if else문 연습)
const age = prompt("How old are you");

console.log(age);

const age = prompt("How old are you");

if(age >= 18 && age <= 21){
    console.log('you can drink but you should not');
}else if(age > 21){
    console.log('go ahed');
}else{
    console.log('too young');
}
*/

/*
const title = document.querySelector('#title');

const BASE_COLOR = "rgb(52, 73, 94)";   //뭐가 다른지 모르겠음
const OTHER_COLOR = "#7f8c8d";

function handleClick() {
    const currentColor = title.style.color;
    console.log(currentColor);
    //만약 현재의 색이 기본색과 같다면
    if(currentColor === BASE_COLOR){
        title.style.color = OTHER_COLOR;
    }else{
        title.style.color = BASE_COLOR;
    }
}

function init(){
    title.style.color = BASE_COLOR;
    title.addEventListener('click',handleClick);
}
init();

//offline일때
function handleOffline(){
    console.log("lalal");
}

//online일때
function handleOnline(){
    console.log("online");
}

window.addEventListener("offline",handleOffline);
window.addEventListener("online",handleOnline);
*/

const title = document.querySelector('#title'); //해당 id값의 벨류를 가져옴

const CLICKED_CLASS = 'clicked';            //변수에 벨류값 셋팅

/*
토글 사용x
function handleClick(){

    const hasClass = title.classList.contains(CLICKED_CLASS);   //title의 value에 CLICKED_CLASS value값이 있다면 트루
    if(hasClass){     //트루면
        title.classList.remove(CLICKED_CLASS); //CLICKED_CLASS value값 제거
    }else{  
        title.classList.add(CLICKED_CLASS);    //CLICKED_CLASS value값 추가
    }
}
*/


//토글을 사용하면 위 코드와 동일
//클래스가 있는지 체크해서 있으면 add 아니면 remove
function handleClick(){
    title.classList.toggle(CLICKED_CLASS);
}



function init(){ // 2.해당 펑션실행
    title.addEventListener('click', handleClick); //3.클릭시 handleClick실행
}

init(); // 1.실행


