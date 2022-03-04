// id, pw, name, phone, email
const idResult = document.getElementById('idResult');
const idx = document.getElementById('idx');
const pw = document.getElementById('pw');
const pwResult = document.getElementById('pwResult');
const pw2 = document.getElementById('pw2');
const pwResult2 = document.getElementById('pwResult2');
const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');
const btn = document.getElementById('btn');




// -------- pw 와 pw2 같은지 검증
let pwCheck = true; //같지 않을 때 true, 같으면 false

pw2.addEventListener('blur', function() {
    let message = '비밀번호가 일치합니다.'
    if(pw.value != pw2.value){
        pwCheck = true;
        message = '비밀번호가 일치하지 않습니다.';
        pw2.value = '';
    }else {
       pwCheck = false;
    }
    pwResult2.innerHTML = message;
})

// -------- ID 입력 후 --------------------
idx.addEventListener('blur', function() {
    if(idx.value == '') {
        idResult.innerHTML='ID를 입력하세요.';
    }   
});

// -------- 검증이 끝나고 pw를 수정했을 경우
pw.addEventListener('change', function() {
    pwCheck = true;
    pw2.value = '';
    pwResult2.value = '';
    pw2.focus();
})

// -------- pw 길이 검증 --------------------
pw.addEventListener('blur', function() {
    if(pw.value.length < 8 || pw.value.length > 12) {
        pwResult.innerHTML = '비밀번호의 글자수가 맞지 않습니다.';
    }
})

// -------- join 버튼 클릭시 --------------
btn.addEventListener("click", function() {
    if(idx.value == '') {
        alert('id를 입력하세요.');
        idx.focus();
        return ; //메서드 강제종료
    }

    if(pw.value == '' || pw.value.length < 8 || pw.value.length> 12) {
        alert('pw가 정확하지 않습니다')
        pw.focus;
        return ;
    }

    if(pwCheck){
        alert('PW가 일치 하지 않습니다');
        pw2.focus();
        return;
    }

    if(name.value == '') {
        alert('이름을 입력하세요');
        name.focus();
        return ;
    }

    if(phone.value == '') {
        alert('전화번호를 입력하세요');
        phone.focus();
        return ;
    }

    if(email.value == '') {
        alert('이메일을 입력하세요');
        email.focus();
        return ;
    }

    frm.submit();
})