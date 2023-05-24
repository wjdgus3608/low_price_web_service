<template>
    <div id="myPage">
       <NavBar/>
        <div id="myPageContainer">
            <div id="menuContainer">
                <MyMenu/>
            </div>
            <div id="subPageContainer">
                <KeywordsSubPage v-if="menuNum===0"/>
                 <AdminSubPage v-if="menuNum===1"/>
            </div>
        </div>
        <KeywordPopup ref="modalView"/>
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
            isModelOpen: false
        }
    },

    methods:{
       
    }
}
</script>

<style scoped>
#myPageContainer {
    display: flex;
    margin: 200px 30px;
    width: 100%;
    height: 100%;
}

#menuContainer {
}

#subPageContainer {
}
</style>