//웹페이지가 준비되면 실행
// 스크롤을 내리면 이벤트 발생 스크립트
$(function(){

  $(window).trigger('scroll');    //강제로 함수를 한번 실행 시킴

  $(window).scroll(function(){
      let top = $(window).scrollTop();    //scrollTop() 최상단이면 0 스크롤바의 위치값을 나타냄
      if(top > 0){
        $('#nav').addClass('inverted');
        $('#nav-right-last').removeClass('last');
        $('#nav-right > li > a').addClass('right-color');
        $('.nav-right-last').addClass('right-color');
      }else{
          $('#nav').removeClass('inverted');
          $('#nav-right > li > a').removeClass('right-color');
          $('#nav-right-last').addClass('last');
      }
  });

  
  // $('#nav-menubar').click(function(){
  //   let subMenu = $('.nav-submenu');

  //   //display가 none면 show로 show면 none로 변경
  //   subMenu.toggle();
  // });

  // $('#nav-job').click(function(){
  //   let subMenuJob = $('.nav-submenu-job');

  //   //display가 none면 show로 show면 none로 변경
  //   subMenuJob.toggle();
  // });
  $('#nav-menubar').mouseenter(function(){
    $(this).next().stop().slideDown(500);
  });

  $('#nav-menubar').mouseleave(function(){
    $(this).stop().slideUp(500);
  });

  // $('.nav-submenu').mouseleave(function(){
  //   $(this).stop().slideUp(500);
  // });

  // $('#nav-job').mouseenter(function(){
  //   console.log('dgs');
  //   $(this).next().stop().slideDown(500);
  // });

  // $('.nav-submenu-job').mouseleave(function(){
  //   $(this).stop().slideUp(500);
  // });


});