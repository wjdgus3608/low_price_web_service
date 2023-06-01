<template>
    <div class="container" id="signupMain">
        <title>회원가입</title>
        <h3>회원가입</h3>
        <form id="signupBox" @submit="callSignUpApi">
            <div class="mb-3">
                <label for="userId" class="form-label">ID</label>
                <input type="text" class="form-control" id="userId" v-model="userId" placeholder="ID">
            </div>
            <div class="mb-3">
                <label for="userPw" class="form-label">Password</label>
                <input type="password" class="form-control" id="userPw" v-model="userPw" placeholder="Password">
            </div>
            <div class="mb-3">
                <label for="userPwRe" class="form-label">Repeat Password</label>
                <input type="password" class="form-control" id="userPwRe" v-model="passwordRe"
                    placeholder="Repeat Password">
                    <p v-show="passwordRe!='' && userPw!==passwordRe" style="color: red;">비밀번호가 일치하지 않습니다.</p>
            </div>
            <div class="mb-3">
                <label for="userName" class="form-label">이름</label>
                <input type="text" class="form-control" id="userName" v-model="userName" placeholder="이름">
            </div>
            <button type="submit" class="btn btn-primary" id="signupBtn">가입신청</button>
        </form>
    </div>
</template>

<script>
import axios from "axios"

export default {
    methods: {
        checkForm(){
            if(!this.userId || !this.userPw || !this.userName || !this.passwordRe){
                alert("필수값이 입력되지 않았습니다.");
                return false;
            }
            if(this.userPw!==this.passwordRe){
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }
            return true;
        },
        callSignUpApi(event) {
            event.preventDefault();
            if(!this.checkForm()){
                return;
            }
            
            axios.post('http://localhost:6060/user', {
                userId: this.userId,
                userPw: this.userPw,
                userName: this.userName
            })
                .then(response => {
                    console.log(response.data);
                })
                .catch(error => {
                    console.error(error);
                });
        }
    },
    data(){
        return{
            userId: '',
            userPw: '',
            userName: '',
            passwordRe: ''
        }
    }
}
</script>

<style scoped>
#signupMain {
    margin-top: 40px;
    width: 800px;
}

#signupBtn {
    float: right;
}
</style>