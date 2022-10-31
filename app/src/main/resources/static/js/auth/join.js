// 비밀번호 확인 script
var password = document.getElementById("password")
  ,confirm_password = document.getElementById("passwordConfirm");

function validatePassword() {
  if(password.value != passwordConfirm.value) {
    // 만일 두 인풋 필드값이 같지 않을 경우
    // setCustomValidity의 값을 지정해 무조건 경고 표시가 나게 하고
    passwordConfirm.setCustomValidity("Passwords Don't Match");
  }
  else {
    // 만일 두 인풋 필드값이 같을 경우
    // 오류가 없으면 메시지를 빈 문자열로 설정해야한다. 오류 메시지가 비어 있지 않은 한 양식은 유효성 검사를 통과하지 않고 제출되지 않는다.
    // 따라서 빈값을 주어 submit 처리되게 한다
    passwordConfirm.setCustomValidity('');
  }
}

password.onchange = validatePassword;
passwordConfirm.onkeyup = validatePassword;



// 아이디 중복 확인 script
  var doId = function () {
  var id = $("input.id").val();
  var idCheckBox = document.getElementById("idCheckBox");

  $.ajax({
    type: "POST",
    url: "../event/idCheck",
    data: { id: id},
    success: function (result) {
      if(result == "true") {
        idCheckBox.innerHTML = "멋진 아이디에요!";
        idCheckBox.style.color = "green";
      } else if (result == "duplicated") {
        idCheckBox.innerHTML = "같은 아이디가 이미 사용중이에요.";
        idCheckBox.style.color = "red";
      } else if (result == "incorrect") {
        idCheckBox.innerHTML = "영문, 숫자 조합으로 4~12자로 입력해주세요.";
        idCheckBox.style.color = "red";
      }
    },
  });
};
  $(".id").blur(doId);



// 닉네임 중복 확인 script
  var doNickName = function () {
  var nickName = $("input.nickName").val();
  var nickNameCheckBox = document.getElementById("nickNameCheckBox");

  $.ajax({
    type: "GET",
    url: "../event/nickNameCheck",
    data: { nickName: nickName},
    success: function (result) {
      if(result == "true") {
        nickNameCheckBox.innerHTML = "멋진 별명이에요!";
        nickNameCheckBox.style.color = "green";
      } else if (result == "duplicated") {
        nickNameCheckBox.innerHTML = "같은 별명이 이미 사용중이에요.";
        nickNameCheckBox.style.color = "red";
      } else if (result == "incorrect") {
        nickNameCheckBox.innerHTML = "영문, 한글, 숫자 조합으로 4~12자로 입력해주세요.";
        nickNameCheckBox.style.color = "red";
      }
    },
  });
};
  $(".nickName").blur(doNickName);



// 최종 확인 script
  var doJoin = function () {
  var lastId = $("input.id").val();
  var lastNickName = $("input.nickName").val();

  $.ajax({
    type: "POST",
    url: "../event/lastCheck",
    data: { id: lastId, nickName: lastNickName},
    success: function (result) {
      if(result == "true") {
        document.getElementById("joinForm").submit();
      } else if (result == "false") {
        alert("올바른 정보를 입력해주세요.");
        window.location.reload();
      }
    },
  });
};
  $(".joinForm").submit(doJoin);
