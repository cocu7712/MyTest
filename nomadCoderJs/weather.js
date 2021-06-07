const weather = document.querySelector(".js-weather")

const API_KEY = 'd9355679227fc65c71a0da5087b7e338';
const COORDS = 'coords';

function getWeather(lat,lng){
    //then은 데이터가 완전히 들어온 다음 호출
    fetch(`http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${API_KEY}&units=metric`
    ).then(function(response){
        // console.log(response.json()
        return response.json(); //response에 json객체 리턴
    }).then(function(json) {    //리턴한 json객체
        console.log(json);      //log를 찍음
        const temperature = json.main.temp; //json객체 안에 main안에 temp 정보 가져오기
        const place = json.name;
        weather.innerText = `온도 : ${temperature} @ 위치 : ${place}`;
    });


}


// 위치 값인 latitude값과 longitude값을 localStorage에 저장
function saveCoords(coordsObj){
    localStorage.setItem(COORDS, JSON.stringify(coordsObj));    //받아온 객체를 Stirng값으로 변경
}


//수락하면 실행
function handleGeoSucces(position){
    console.log(position.coords);
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    const coordsObj = {
        // latitude: latitude,
        // longitude: longitude
        //위 문장을 아래와 같이 변수명과 벨류를 같게 저장할 때는 그냥 사용 해도 됨
        latitude,
        longitude
    };
    saveCoords(coordsObj);
    getWeather(latitude,longitude);
}

//거절하면 실행
function handleGeoError(){
    console.log("Cant access geo location");
}

//현재 위치를 가져옴
function askForCoords(){
    navigator.geolocation.getCurrentPosition(handleGeoSucces,handleGeoError);
}

//위치 값을 storage에 저장
function loadCoords(){
    const loadedCoords = localStorage.getItem(COORDS);
    //저장된 위치 값이 없으면 실행
    if(loadedCoords === null){
        askForCoords(); //함수 실행
    }else{
        // getWeather
        const parseCoords = JSON.parse(loadedCoords);
        console.log(parseCoords);
        getWeather(parseCoords.latitude,parseCoords.longitude);
    }
}

function init(){
    loadCoords();
}

init();