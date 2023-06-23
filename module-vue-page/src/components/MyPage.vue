<template>
    <div id="myPage">
       <NavBar :login-user="loginUser" :session-value="sessionValue"/>
        <div id="myPageContainer">
            <div id="menuContainer">
                <MyMenu/>
            </div>
            <div id="subPageContainer">
                <KeywordsSubPage v-if="menuNum===0" :login-user="loginUser" :session-value="sessionValue"/>
                 <AdminSubPage v-if="menuNum===1"/>
            </div>
        </div>
        <KeywordPopup/>
    </div>
</template>

<script>
import MyMenu from './MyMenu.vue';
import KeywordsSubPage from './KeywordsSubPage.vue';
import AdminSubPage from './AdminSubPage.vue';
import NavBar from './NavBar.vue';
import KeywordPopup from "./KeywordPopup.vue";


export default {
    components:{
        MyMenu,
        KeywordsSubPage,
        AdminSubPage,
        NavBar,
        KeywordPopup
    },

    data(){
        return {
            menuNum: 0,
            isModelOpen: false,
            loginUser:'',
            sessionValue:''
        }
    },

    created(){
        this.loginUser = JSON.parse(sessionStorage.getItem('loginUser'));
        this.sessionValue = JSON.parse(sessionStorage.getItem('sessionValue'));
    },

    methods:{
       
    }
}
</script>

<style scoped>
#myPageContainer {
    display: flex;
    margin: 100px 30px;
}

#menuContainer {
    margin-top: 100px;
}

#subPageContainer {
    flex-grow: 1;
}
</style>