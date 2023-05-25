<template>
    <div id="itemListPage">
        <NavBar/>
        <div id="itemListPageContainer">
            <div id="leftSideContainer">leftSideContainer</div>
            <div id="middleSideContainer">
                <ItemCard/>
            </div>
            <div id="rightSideContainer">rightSideContainer</div>

        </div>
    </div>
</template>

<script>
import NavBar from './NavBar.vue'; 
import ItemCard from './ItemCard.vue'
export default {
    components:{
        NavBar,
        ItemCard
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