<template>
    <div id="itemListPage">
        <NavBar/>
        <div id="itemListPageContainer">
            <div id="leftSideContainer">abc</div>
            <div id="middleSideContainer">ddd</div>
            <div id="rightSideContainer">fff</div>

        </div>
    </div>
</template>

<script>
import NavBar from './NavBar.vue';
export default {
    components:{
        NavBar
    }
}
</script>

<style scoped>
#itemListPageContainer {
    display: flex;
    margin: 70px 30px;
}
#leftSideContainer {
    flex-grow: 1;
}
#middleSideContainer {
    flex-grow: 10;
}
#rightSideContainer {
    flex-grow: 3;
}
</style>