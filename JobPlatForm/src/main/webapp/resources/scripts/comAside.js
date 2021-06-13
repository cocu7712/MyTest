$(function(){
  //가로 길이가 일정이상 줄어들면 사이드바 제거
  $(window).resize(function(){
      if($(window).width() < 1700){
        $('#comAside').removeClass('comAside');
        $('#comAside').addClass('main-aside-none');
      }else{
        $('#comAside').removeClass('comAside-none');
        $('#comAside').addClass('comAside');
      }
    });
    $(window).trigger('resize');


  $(".comAside-menu").mouseenter(function(){
      $(this).children(".comAside-submenu").stop().slideDown(500);
  });
  
  $(".comAside-menu").mouseleave(function(){
      $(this).children(".comAside-submenu").stop().slideUp(500);
  });

});