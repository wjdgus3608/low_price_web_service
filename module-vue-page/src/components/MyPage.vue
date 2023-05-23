<template>
    <div id="myPage">
       <NavBar/>
        <div id="myPageContainer">
            <div id="menuContainer">
                <MyMenu/>
            </div>
            <div id="subPageContainer">
                abc
            </div>
        </div>
    </div>
</template>

<script>
import MyMenu from './MyMenu.vue';
// import KeywordsSubPage from './KeywordsSubPage.vue';
// import AdminSubPage from './AdminSubPage.vue';
import NavBar from './NavBar.vue'

export default {
    components:{
        MyMenu,
        // KeywordsSubPage,
        // AdminSubPage
        NavBar
    }
}
</script>

<style scoped>
#myPageContainer {
    margin: 200px 50px;
    width: 100%;
    height: 100%;
}

#menuContainer {
    display: inline;
}

#subPageContainer {
    display: inline;

}
</style>