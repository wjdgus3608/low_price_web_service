<template>
    <div id="login-main">
        <title>가격 비교 시스템 로그인</title>
        <h3>가격 비교 시스템</h3>
        <form>
            <div class="mb-3">
                <label for="userId" class="form-label">ID</label>
                <input type="text" class="form-control" id="userId" v-model="userId" placeholder="ID">
            </div>
            <div class="mb-3">
                <label for="userPw" class="form-label">Password</label>
                <input type="password" class="form-control" id="userPw" v-model="password" placeholder="Password">
            </div>
            <button type="button" class="btn btn-primary" @click="signUp">회원가입</button>
            <button type="submit" class="btn btn-primary" id="loginBtn" @click="submitForm">로그인</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'LoginView',
    data() {
        return {
            userId: '',
            password: ''
        }
    },
    created(){
        const sessionValue = JSON.parse(sessionStorage.getItem('sessionValue'));
        if(sessionValue!==null){
            this.callGetUserBySession(sessionValue);
        }
    },
    methods: {
        signUp() {
            this.$router.push('/signup-page');
        },
        submitForm(event) {
            event.preventDefault();
            if (!this.checkForm()) {
                return;
            }

            this.callGetSession(this.userId, this.password);
        },
        checkForm() {
            if (!this.userId || !this.password) {
                return false;
            }
            return true;
        },
        callGetSession(userId, password){
            axios.post('http://localhost:6060/user/auth', {
                userId: userId,
                userPw: password,
            })
                .then(response => {
                    console.log("로그인 성공");
                    sessionStorage.setItem('sessionValue', JSON.stringify(response.data));

                    const sessionValue = JSON.parse(sessionStorage.getItem('sessionValue'));
                    this.callGetUserBySession(sessionValue);
                })
                .catch(error => {
                    console.error(error);
                });
        },
        callGetUserBySession(sessionValue){
            axios.post('http://localhost:6060/user/session', {
                sessionValue: sessionValue,
            })
                .then(response => {
                    console.log("세션 로그인 성공");
                    sessionStorage.setItem('loginUser', JSON.stringify(response.data));

                    this.$router.push('/search-page');
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }
}
</script>

<style scoped>
#login-main {
    position: absolute;
    width: 500px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

#loginBtn {
    float: right;
}
</style>