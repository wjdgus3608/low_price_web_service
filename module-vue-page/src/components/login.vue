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
export default {
    name: 'LoginView',
    data: function () {
        return {
            userId: '',
            password: ''
        }
    },
    methods: {
        signUp() {
            this.$router.push('/signup');
        },
        submitForm() {
            console.log(this.userId);
            console.log(this.password);
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