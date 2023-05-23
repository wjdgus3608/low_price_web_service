<template>
  <div class="container" id="signupMain">
    <title>회원가입</title>
        <h3>회원가입</h3>
        <form id="signupBox">
            <div class="mb-3">
                <label for="userId" class="form-label">ID</label>
                <input type="text" class="form-control" id="userId" v-model="userId" placeholder="ID">
            </div>
            <div class="mb-3">
                <label for="userPw" class="form-label">Password</label>
                <input type="password" class="form-control" id="userPw" v-model="password" placeholder="Password">
            </div>
            <div class="mb-3">
                <label for="userName" class="form-label">Password</label>
                <input type="text" class="form-control" id="userName" v-model="userName" placeholder="이름">
            </div>
            <button type="submit" class="btn btn-primary" id="signupBtn" @click="submitForm">가입신청</button>
        </form>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#signupMain {
  margin-top: 40px;
}
#signupBtn {
    float: right;
}
</style>