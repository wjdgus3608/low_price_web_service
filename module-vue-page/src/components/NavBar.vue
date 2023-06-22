<template>
    <div id="NavBar">
        <nav class="navbar fixed-top navbar-dark bg-dark justify-content-end">
            <div id="searchBarContainer">
                <SearchBar/>
            </div>
            <a class="navbar-brand" href="#">
                <img src="" alt="" width="30" height="24"
                    class="d-inline-block align-text-top">
                {{}} 님
            </a>
            <button class="btn btn-outline-success me-2 text-white border-white btn-sm" type="button" @click="logout">로그아웃</button>
        </nav>
    </div>
</template>

<script>
import SearchBar from './SearchBar.vue';
import axios from 'axios';

export default {
    components:{
        SearchBar
    },
    data(){
        return{
            // user: this.$session.get
        }
    },
    methods:{
        logout(){
            const json = JSON.parse(sessionStorage.getItem('loginUser'));
            this.callLogout(json.userId);

            this.initSessionStorage();
            this.$router.push('/');
        },
        callLogout(userId){
            axios.post('http://localhost:6060/user/logout', {
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