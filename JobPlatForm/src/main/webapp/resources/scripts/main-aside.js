$(function(){
  //가로 길이가 일정이상 줄어들면 사이드바 제거
  $(window).resize(function(){
      if($(window).width() < 1700){
        $('#main-aside').removeClass('main-aside');
        $('#main-aside').addClass('main-aside-none');
      }else{
        $('#main-aside').removeClass('main-aside-none');
        $('#main-aside').addClass('main-aside');
      }
    });
    $(window).trigger('resize');


  $(".main-aside-menu").mouseenter(function(){
      $(this).children(".main-aside-submenu").stop().slideDown(500);
  });
  
  $(".main-aside-menu").mouseleave(function(){
      $(this).children(".main-aside-submenu").stop().slideUp(500);
  });

});