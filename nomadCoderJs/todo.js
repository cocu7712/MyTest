const toDoForm = document.querySelector(".js-toDoForm"),
      toDoInput = toDoForm.querySelector("input"),  //가져온 form안에 있는 자식 input
      toDoList = document.querySelector(".js-toDoList");

const TODOS_LS = 'toDos';

let toDos = []; //배열이 변경 될 수 있음으로 let



function filterFn(toDo){
    return toDo.id === 1;
}

function deleteToDo(event){ //클릭 이벤트가 발생하면 실행
    //console.log(event.target.parentNode);  //target : 클릭 대상 parentNode : 부모 엘리먼트
    const btn = event.target;   //이벤트가 발생한 버튼을 찾음
    const li = btn.parentNode;  //클릭한 btn의 부모 태그를 찾음 (id값도 나옴)
    toDoList.removeChild(li);   //toDoList안에 있는 li를 삭제
    //array 안에 있는 모든 toDos를 통함 / true인 것들인 toDos만 return 함
    //(1)
    //const cleanToDos = toDos.filter(filterFn)   //filter는 모든 아이템을 통해 함수를 실행하고
                                                  //true인 아이템들만 가지고 새로운 array를 만듬
    //(2) 파라미터에 함수를 만들어서 사용
    const cleanToDos = toDos.filter(function(toDo){ //filter 안에 function을 실행하여 parameta에 각 value를 넣어줌
        return toDo.id !== parseInt(li.id);   //toDo.id가 li.id와 다르면 리턴
    });
    toDos = cleanToDos;
    console.log(cleanToDos);
    saveToDos();
}

function saveToDos(){
    //localStorage는 string으로 받아야 함
    localStorage.setItem(TODOS_LS, JSON.stringify(toDos));  //JSON.stringify로 object를  string으로 바꿈
}

function paintToDo(text){   //text 파라미터를 받음
    const li = document.createElement("li");            //li를 생성
    const delBtn = document.createElement("button");    //button을 생성
    const span = document.createElement("span");        //span을 생성
    const newId = toDos.length + 1;                     //toDos의 길이 + 1의 값을 저장
    delBtn.innerHTML = "❌";                            //버튼을 x표시 형태로 만듬
    delBtn.addEventListener("click",deleteToDo)         //delBtn의 클릭 이벤트를 만듬(클릭시 deleteToDo 함수 실행)

    span.innerText = text;  //sapn 안에 내용을 text파라미터 값을 줌
    li.appendChild(delBtn); //li 안에 버튼을 생성
    li.appendChild(span);   //li 안에 span을 생성
    li.id = newId;          //li 엘리먼트에 id값을 줌
    toDoList.appendChild(li);   //toDoList 안에 li를 생성
    const toDoObj = {
        text: text,
        id: newId
    };
    toDos.push(toDoObj);
    saveToDos();
    
}

function handleSubmit(event){
    event.preventDefault();     //submit하여 데이터가 넘어가지 못하게함
    const currentValue = toDoInput.value;   //입력 받은 input 데이터를 변수에 저장
    paintToDo(currentValue);    //입력 받은 데이터를 파라미터에 넣고 함수 실행
    toDoInput.value = "";       //입력 후 입력한 내용을 초기화 함
}

//방법 1
function loadToDos(){
    const loadedToDos = localStorage.getItem(TODOS_LS); //localStorage 안에 있는toDos를 가져옴(toDos key에 value는 배열로 여러개 존재)
    //toDos가 null이 아니라면 실행
    if(loadedToDos !== null){   
        const parsedToDos = JSON.parse(loadedToDos);    //JSON.parse 로 객체 배열을 String[] 값으로 변경
       //괄호 안에서 함수를 만듬
        parsedToDos.forEach(function(toDo){ //forEach문을 배열길이 만큼 돌림
            paintToDo(toDo.text);   //함수 실행
        });
    }
}


//방법 2
// function loadToDos(){
//     const loadedToDos = localStorage.getItem(TODOS_LS);
//     //toDos가 null이 아니라면 실행
//     if(loadedToDos !== null){   
//         const parsedToDos = JSON.parse(loadedToDos);    //String[] 값으로 변경
//        //괄호 안에서 함수를 만듬
//         parsedToDos.forEach(something); //forEach문을 돌림(함수) 안의 벨류가 함수의 파라미터 값으로 들어감
//     }
// }

// function something(toDo){ //해당 함수를 forEach문을 돌림
//     console.log(toDo.text);
// }

//기본 실행 함수
function init(){
    loadToDos();
    toDoForm.addEventListener("submit",handleSubmit);   //.js-toDoForm 클래스 안에 submit 이벤트가 발생하면 handleSubmit 함수 실행
}

init();