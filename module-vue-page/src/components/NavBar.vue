<template>
    <div id="NavBar">
        <nav class="navbar fixed-top navbar-dark bg-dark justify-content-end">
            <div id="searchBarContainer">
                <SearchBar/>
            </div>
            <a class="navbar-brand" href="/my-page">
                <img src="@/assets/images/userIcon.png" alt="" width="30" height="30"
                    class="d-inline-block align-text-top">
                {{loginUser.userName}} 님
            </a>
            <button class="btn btn-outline-success me-2 text-white border-white btn-sm" type="button" @click="logout">로그아웃</button>
        </nav>
    </div>
</template>

<script>
import SearchBar from './SearchBar.vue';
import axios from 'axios';

export default {
    props:['loginUser','sessionValue'],
    components:{
        SearchBar
    },
    methods:{
        logout(){
            
            this.callLogout(this.loginUser.userId);

            this.initSessionStorage();
            this.$router.push('/');
        },
        callLogout(userId){
            axios.post(this.$getUserBaseUrl()+'/user/logout', {
                userId: userId,
            })
                .then(() => {
                    console.log("로그아웃 성공");
                })
                .catch(error => {
                    console.error(error);
                });
        },
        initSessionStorage(){
            sessionStorage.clear();
        }
    }
}
</script>

<style scoped>
#searchBarContainer{
    margin-right: 50px;
}
</style>