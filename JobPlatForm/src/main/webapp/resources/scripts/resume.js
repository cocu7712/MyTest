$(function(){
	
	//대학교 정보 추가
	$("#insert-school-button").click(function(){
		insertSchool();
	});
	
	//대학 정보 삭제
	$(document).on("click","#deleteSchool",function(){
		
		let result = confirm("정말 삭제하시겠습니까?");
		
		if(result){
			let no = $(this).val();
			deleteSchool(no);
			location.replace("");
		}
	});

	
	//경력 정보 추가
	$("#insert-career-button").click(function(){
		insertCareer();
	});
	
	//경력  삭제
	$(document).on("click","#deleteCareer",function(){
		
		let result = confirm("정말 삭제하시겠습니까?");
		
		if(result){
			let no = $(this).val();
			deleteCareer(no);
			location.replace("");
		}
	});
	
	//자격증 정보 추가
	$("#insert-certificate-button").click(function(){
		insertCertificate();
	});
	
	//자격증  삭제
	$(document).on("click","#deleteCertificate",function(){
		
		let result = confirm("정말 삭제하시겠습니까?");
		
		if(result){
			let no = $(this).val();
			deleteCertificate(no);
			location.replace("");
		}
	});
	
	//클릭하면 드랍박스
//	$(document).on("click","#school-box",function(){
//		let select = $(".school-box");
//		
//		show(select);
//	});
	
	//제이쿼리 달력 api
    let dpFrom = $('#startDate').datepicker({
      dateFormat:'yy-mm-dd'   //데이터를 일-월-년 에서 -> 년-월-일 로 변경
    });
    dpFrom.datepicker('setDate',new Date());
   
    let dpTo = $('#endDate').datepicker({
      dateFormat:'yy-mm-dd',
      onSelect:function(){
        dpTo.datepicker('option','minDate',dpFrom.datepicker('getDate'));
      }
    });
    dpTo.datepicker('setDate',3);
	
	
	selectSchool();
	selectCertificate();
	selectCareer();
	
});
	
//--------------학교-------------------

//학교 등록
function insertSchool(){
	let schoolDetail = $("#schoolDetail").val();
	let admission = $("#admission").val();
	let graduated = $("#graduated").val();
	let size = schoolDetail.length;
		
	if(schoolDetail === ""){
		alert("학교를 입력해주세요");
		return false;
	}else if(size < 2 || size > 12){
		alert("2~12글자만 입력가능");
		return false;
	}
		
	if(admission === ""){
		alert("입학날짜를 입력해주세요");
		return false;
	}
		
	if(graduated === ""){
		alert("졸업(예정)날짜를 입력해주세요");
		return false;
	}
		
	let str = $("#insert-school").serialize();	//get
		
	$.ajax({
		url:"/insertSchool.do",
		data:str,
		dataType:"json",
		success:function(r){
			let tag = "";
			if(r.code == 200){
				r.message;
			}else{
				r.message;
			}
			console.log(r.message);
		}
	});
};

//학교 리스트
function selectSchool(){
	  $.ajax({
			url:"/selectSchool.do",
			dataType:"json",
			success:function(r){
		      let list = $("#schoolText");
			  if(r.code == 200){
				 r.message;
				 let arr = r.result;
			     for(let i = 0; i < arr.length; i++){
			         let data = arr[i];
			         let item = SchoolList(data);
		
			         list.append(item);
			    }
				}else{
					r.message;
				}
			}
		});
}

//학교 리스트 나타내기
function SchoolList(data){
	//id값을 지워서 none 속성 제거
	let box = $("#school-box").clone().removeAttr('id'); //id remove

	//받아온 데이터 입력
	box.find('.school').html(data.school);
	box.find('.schoolDetail').html(data.schoolDetail);
	box.find('.admission').html(data.admission);
	box.find('.graduated').html(data.graduated);
	box.find('#deleteSchool').val(data.no);
	return box;
}

//학교정보 삭제
function deleteSchool(no){
	let data = {no : no};
	$.ajax({
		url:"/deleteSchool.do",
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

//-----------------자격증--------------------

//자격증 등록
function insertCertificate(){
	let certificate = $("#certificate").val();
	let issuer = $("#issuer").val();
	let getDate = $("#getDate").val();
	
	let size = certificate.length;
		
	if(certificate === ""){
		alert("자격증을 입력해주세요");
		return false;
	}else if(size < 2 || size > 15){
		alert("2~15글자만 입력가능");
		return false;
	}
	
	let size1 = issuer.length;
	
	if(issuer === ""){
		alert("발행정보를 입력해주세요");
		return false;
	}else if(size1 < 2 || size1 > 15){
		alert("2~15글자만 입력가능");
		return false;
	}
		
	if(getDate === ""){
		alert("발행일자를 입력해주세요");
		return false;
	}
		
	let str = $("#insert-certificate").serialize();	//get
		
	$.ajax({
		url:"/insertCertificate.do",
		data:str,
		dataType:"json",
		success:function(r){
			let tag = "";
			if(r.code == 200){
				r.message;
			}else{
				r.message;
			}
			console.log(r.message);
		}
	});
};

//자격증 리스트
function selectCertificate(){
 $.ajax({
	url:"/selectCertificate.do",
	dataType:"json",
	success:function(r){
	let list = $("#certificateText");
		if(r.code == 200){
			r.message;
			let arr = r.result;
			for(let i = 0; i < arr.length; i++){
				let date = arr[i];
				let item = CertificateList(date);
				list.append(item);
			}
		}else{
			r.message;
		}
	}
  });
}

//자격증 리스트 나타내기
function CertificateList(date){
	//id값을 지워서 none 속성 제거
	let box = $("#certificate-box").clone().removeAttr('id'); //id remove

	//받아온 데이터 입력
	box.find('.certificate').html(date.certificate);
	box.find('.issuer').html(date.issuer);
	box.find('.getDate').html(date.getDate);
	box.find('#deleteCertificate').val(date.no);
	return box;
}

//자격증 삭제
function deleteCertificate(no){
	let data = {no : no};
	$.ajax({
		url:"/deleteCertificate.do",
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
//-----------------경력--------------------

//경력 등록
function insertCareer(){
	let position = $("#position").val();
	let company = $("#company").val();
	let startDate = $("#startDate").val();
	let endDate = $("#endDate").val();
	
	let size = position.length;
	
	if(position === ""){
		alert("직무를 입력해주세요");
		return false;
	}else if(size < 2 || size > 10){
		alert("2~10글자만 입력가능");
		return false;
	}
	
	let size1 = company.length;
	
	if(company === ""){
		alert("회사를 입력해주세요");
		return false;
	}else if(size1 < 2 || size1 > 20){
		alert("2~15글자만 입력가능");
		return false;
	}
	
	if(startDate === ""){
		alert("입사일자를 입력해주세요");
		return false;
	}
	
	if(endDate === ""){
		alert("퇴사일자를 입력해주세요");
		return false;
	}
	
	let str = $("#insert-career").serialize();
	
	$.ajax({
		url:"/insertCareer.do",
		data:str,
		dataType:"json",
		success:function(r){
			let tag = "";
			if(r.code == 200){
				r.message;
			}else{
				r.message;
			}
			console.log(r.message);
		}
	});
};

//경력 리스트
function selectCareer(){
	$.ajax({
		url:"/selectCareer.do",
		dataType:"json",
		success:function(r){
			let list = $("#careerText");
			if(r.code == 200){
				r.message;
				let arr = r.result;
				for(let i = 0; i < arr.length; i++){
					let date = arr[i];
					let item = CareerList(date);
					list.append(item);
				}
			}else{
				r.message;
			}
			console.log(r.message);
		}
	});
}

//경력 리스트 나타내기
function CareerList(date){
	//id값을 지워서 none 속성 제거
	let box = $("#career-box").clone().removeAttr('id'); //id remove
	
	//받아온 데이터 입력
	box.find('.position').html(date.position);
	box.find('.company').html(date.company);
	box.find('.startDate').html(date.startDate);
	box.find('.endDate').html(date.endDate);
	box.find('#deleteCareer').val(date.no);
	return box;
}

//경력 삭제
function deleteCareer(no){
	let data = {no : no};
	$.ajax({
		url:"/deleteCareer.do",
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



