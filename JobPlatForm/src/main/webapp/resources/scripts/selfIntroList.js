$(function(){
	
	$(document).on("click","#delete",function(){
		let result = confirm("정말 삭제하시겠습니까?");
		
		if(result){
			let no = $(this).val();
			deleteList(no);
			console.log(no);
			location.replace("/myPage/selfIntroList");
		}
	})
});

//자소서 삭제
function deleteList(no){
	let data = {no : no};
	$.ajax({
		type:'post',
		url:"/myPage/selfIntroDelete",
		data:data,
		dataType:"json",
		success:function(r){
		  if(r.code == 200){
			 r.message;
		    }
		  else{
				r.message;
		  }
			console.log(r.message);
		}
	});
}