<template>
  <div>
    <form id="login-box" @submit="submitForm">
        <div id="id-box">
            <label for="user-id">ID</label>
            <input id="user-id" type="text" v-model="userId"/>
        </div>
        <div id="pw-box">
            <label for="password">PW</label>
            <input id="password" type="password" v-model="password"/>
        </div>
        <button class="btn btn-primary" id="signup-btn" type="button" @click="signUp">회원가입</button>
        <button class="btn btn-primary" id="login-btn" type="submit">로그인</button>
    </form>
  </div>
</template>

<script>
export default {
    data: function(){
        return {
            userId : '',
            password : ''
        }
    },
    methods:{
        signUp(){
            this.$router.push('/signup');
        },
        submitForm(){
            console.log(this.userId);
            console.log(this.password);
        }
    }
}
</script>

<style>

</style>