//Class ID 엘리먼트의 첫 번쨰 요소 검색하여 가져오기
const form = document.querySelector('.js-form'),
      input = form.querySelector('input'),
      greeting = document.querySelector('.js-greetings');

//css에 있는 클래스 속성을 주기위한 String값
const USER_LS = "currenUser",
      SHOWING_CN = 'showing';

    //4
    function handleSubmit(event){
        event.preventDefault(); //form 데이터를 다른곳으로 전송하지 못하게 막음
        const currenValue = input.value;    //입력한 데이터의 vlaue값을 가져옴
        //console.log(currenValue);
        paintGreeting(currenValue); // 가져온 입력 데이터를 파라미터에 넣고 함수 실행        saveNmae(currenValue);
    }

    function saveNmae(text){
        localStorage.setItem(USER_LS,text); //localStorage 유저 컴퓨터에 저장하는 방법.
    }

    //localStorage에 저장된 값이 없으면 form 엘리먼트 none을 block으로 변경
    function askForName(){
        form.classList.add(SHOWING_CN); //해당 class를 추가함(display:none인 속성을 block으로 변경함)
        form.addEventListener('submit',handleSubmit);
    }

    //글씨 색을 바꾸는 함수 3(5)
    function paintGreeting(text){
        form.classList.remove(SHOWING_CN);      //form의 class를 지움
        greeting.classList.add(SHOWING_CN);     //greeting의 class값을 추가함
        greeting.innerText = `Hello ${text}`;   //localStorage가 있다면 변경
    }

    //localStorage를 가져오는 함수 2
    function loadName(){
        const currenUser = localStorage.getItem(USER_LS);   //해당하는 변수의 컴퓨터에 저장된 변수값을 가져옴
        if(currenUser === null){
            //she is not
            askForName();
        }else{
            //she is
            paintGreeting(currenUser);
        }

    }

//1
function init(){
    loadName();
    //localStorage.removeItem(USER_LS); //localStorege를 삭제
}

init();
