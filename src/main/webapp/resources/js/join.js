// 전역 변수
// var
const pw = document.getElementById('pw');
const pw2 = document.getElementById('pw2');
const pwResult = document.getElementById('pwResult');
const pwResult2 = document.getElementById('pwResult2');

const idx = document.getElementById('idx');
const idResult = document.getElementById('idResult');

const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');


const frm = document.getElementById('frm');
const btn = document.getElementById('btn');

let idCheck = false; //check OK : 
let pwCheck = false;
let nameCheck = false;
let phoneCheck = false;
let emailCheck = false;

pw.addEventListener("change", function() {
    pwCheck = false;
    pw2.value = '';
    pwResult2.innerHTML = '';
    pw2.focus();
});


email.addEventListener("blur", function() {
    if(email.value == '') {
        emailCheck = false;
    }
    else {
        emailCheck = true;
    }
})

phone.addEventListener("blur", function() {
    if(phone.value == '') {
        phoneCheck = false;
    }
    else {
        phoneCheck = true;
    }
})

name.addEventListener("blur", function() {
    if(name.value == '') {
        nameCheck = false;
    }
    else {
        nameCheck = true;
    }
})

btn.addEventListener("click", function() {
    if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck) {
        frm.submit();
    }
    else {
        alert('필수요건을 확인하세요.');
    }
});

idx.addEventListener("blur",function() {
    let v = idx.value;

    if(v == '')  { // v.length == 0 
        idResult.innerHTML = '필수입력';
        idCheck = false;
    }
    else 
        idCheck = true;
});

pw.addEventListener("keyup", function() {
    let length = pw.value.length;
    let message = '잘못된 비밀번호';
    if(length>=8 && length<=12)
        message = '정상적인 비밀번호';
    
    pwResult.innerHTML = message;
});

pw2.addEventListener("blur", function() {
    let v1 = pw.value;
    let v2 = pw2.value;
    let message = '비번이 일치하지 않음';

    if(v1 == v2) {
        message = '비번이 일치함';
        pwCheck = true;
    }
    else
        pwCheck = false;

    pwResult2.innerHTML = message;

});

